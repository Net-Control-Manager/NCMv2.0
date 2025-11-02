package org.ncm.ncmv2.domain.repo;
import org.ncm.ncmv2.domain.model.SystemPOI; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import org.springframework.stereotype.Repository; import java.util.List;
@Repository
public interface SystemPOIRepository extends JpaRepository<SystemPOI, Long> {
  @Query(value = """
    select * from system_poi
    where is_deleted = false
      and geojson -> 'properties' ->> 'category' = :category
    """, nativeQuery = true)
  List<SystemPOI> findActiveByCategory(@Param("category") String category);

  @Query(value = """
    select * from system_poi
    where is_deleted = false
      and ST_DWithin(
          geom::geography,
          ST_SetSRID(ST_MakePoint(:lon,:lat),4326)::geography,
          :meters
      )
    """, nativeQuery = true)
  List<SystemPOI> findWithin(@Param("lat") double lat, @Param("lon") double lon, @Param("meters") double meters);

  @Query(value = """
    select * from system_poi
    where is_deleted = false
    order by geom <-> ST_SetSRID(ST_MakePoint(:lon,:lat),4326)
    limit :limit
    """, nativeQuery = true)
  List<SystemPOI> nearest(@Param("lat") double lat, @Param("lon") double lon, @Param("limit") int limit);

  @Query(value = """
    select * from system_poi
    where is_deleted = false
      and ST_Intersects(
          geom,
          ST_MakeEnvelope(:minLon,:minLat,:maxLon,:maxLat, 4326)
      )
    """, nativeQuery = true)
  List<SystemPOI> withinBbox(@Param("minLon") double minLon, @Param("minLat") double minLat,
                              @Param("maxLon") double maxLon, @Param("maxLat") double maxLat);

  @Query(value = """
    select * from system_poi
    where is_deleted = false
      and ST_Intersects(
          geom,
          ST_SetSRID(ST_GeomFromGeoJSON(:geomJson), 4326)
      )
    """, nativeQuery = true)
  List<SystemPOI> withinPolygon(@Param("geomJson") String geomJson);

  @Query(value = """
    select * from system_poi
    where is_deleted = false
      and ST_DWithin(
        geom::geography,
        ST_SetSRID(ST_GeomFromGeoJSON(:lineGeoJson),4326)::geography,
        :meters
      )
    """, nativeQuery = true)
  List<SystemPOI> alongRoute(@Param("lineGeoJson") String lineGeoJson, @Param("meters") double meters);
}
