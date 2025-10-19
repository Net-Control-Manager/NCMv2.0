-- Runs only on initial cluster creation.
-- If POSTGRES_DB is set (e.g., "ncm") this enables PostGIS there.
CREATE EXTENSION IF NOT EXISTS postgis;
-- Optional extras:
-- CREATE EXTENSION IF NOT EXISTS postgis_topology;
