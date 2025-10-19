package org.ncm.ncmv2.domain.repo;
import org.ncm.ncmv2.domain.model.Station; import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import org.springframework.stereotype.Repository; import java.util.List;
@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
  @Query(value = """
     select * from station s
     where ST_DWithin(
       s.lat_long::geography,
       ST_SetSRID(ST_MakePoint(:lon, :lat), 4326)::geography,
       :meters
     )
     """, nativeQuery = true)
  List<Station> findWithin(@Param("lat") double lat, @Param("lon") double lon, @Param("meters") double meters);

  @Query(value = """
    select * from station
    order by lat_long <-> ST_SetSRID(ST_MakePoint(:lon,:lat),4326)::geography
    limit :limit
    """, nativeQuery = true)
  List<Station> nearest(@Param("lat") double lat, @Param("lon") double lon, @Param("limit") int limit);

  @Query(value = """
    select * from station s
    where ST_Intersects(
      s.lat_long::geometry,
      ST_MakeEnvelope(:minLon,:minLat,:maxLon,:maxLat, 4326)
    )
    """, nativeQuery = true)
  List<Station> withinBbox(@Param("minLon") double minLon, @Param("minLat") double minLat,
                           @Param("maxLon") double maxLon, @Param("maxLat") double maxLat);

  @Query(value = """
    select * from station s
    where ST_Intersects(
      s.lat_long::geometry,
      ST_SetSRID(ST_GeomFromGeoJSON(:geomJson), 4326)
    )
    """, nativeQuery = true)
  List<Station> withinPolygon(@Param("geomJson") String geomJson);

  @Query(value = """
    select * from station s
    where ST_DWithin(
      s.lat_long::geography,
      ST_SetSRID(ST_GeomFromGeoJSON(:lineGeoJson),4326)::geography,
      :meters
    )
    """, nativeQuery = true)
  List<Station> alongRoute(@Param("lineGeoJson") String lineGeoJson, @Param("meters") double meters);
}
