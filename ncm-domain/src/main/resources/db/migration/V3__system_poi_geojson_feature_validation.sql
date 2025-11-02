CREATE TABLE IF NOT EXISTS system_poi (
  id          BIGSERIAL PRIMARY KEY,
  geojson     jsonb        NOT NULL,
  geom        geometry     NULL,
  poi_type_id BIGINT       NULL REFERENCES system_poi_type(id),
  date_added  timestamptz  NOT NULL DEFAULT now(),
  is_deleted  boolean      NOT NULL DEFAULT false
);
CREATE OR REPLACE FUNCTION system_poi_apply_feature() RETURNS trigger LANGUAGE plpgsql AS $$
DECLARE feature_type text; geom_json jsonb; BEGIN
  feature_type := NEW.geojson ->> 'type';
  IF feature_type IS DISTINCT FROM 'Feature' THEN RAISE EXCEPTION 'system_poi.geojson must be a GeoJSON Feature'; END IF;
  geom_json := NEW.geojson -> 'geometry';
  IF geom_json IS NULL OR jsonb_typeof(geom_json) <> 'object' THEN RAISE EXCEPTION 'system_poi.geojson Feature must contain a geometry object'; END IF;
  NEW.geom := ST_SetSRID(ST_GeomFromGeoJSON(geom_json), 4326);
  IF NOT ST_IsValid(NEW.geom) THEN RAISE EXCEPTION 'Invalid geometry (ST_IsValid=false)'; END IF;
  RETURN NEW; END $$;
DROP TRIGGER IF EXISTS trg_system_poi_feature ON system_poi;
CREATE TRIGGER trg_system_poi_feature BEFORE INSERT OR UPDATE OF geojson ON system_poi FOR EACH ROW EXECUTE FUNCTION system_poi_apply_feature();

BEGIN;
ALTER TABLE system_poi DROP CONSTRAINT IF EXISTS chk_system_poi_geom_valid;
ALTER TABLE system_poi ADD CONSTRAINT chk_system_poi_geom_valid CHECK (geom IS NOT NULL AND ST_IsValid(geom));
COMMIT;

CREATE INDEX IF NOT EXISTS idx_system_poi_geom_gist ON system_poi USING GIST (geom);
