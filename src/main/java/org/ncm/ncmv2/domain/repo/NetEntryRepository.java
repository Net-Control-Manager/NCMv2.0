package org.ncm.ncmv2.domain.repo;

import org.ncm.ncmv2.domain.model.NetEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface NetEntryRepository extends JpaRepository<NetEntry, Long> {
    @Query(value = "select e.* from net_entry e where e.net_id=:netId and (e.check_in_time + e.time_on_duty) <= :beforeTs", nativeQuery = true)
    List<NetEntry> completedBy(@Param("netId") long netId, @Param("beforeTs") OffsetDateTime beforeTs);

    @Query(value = "select e.* from net_entry e where e.net_id=:netId and (e.check_in_time + make_interval(secs => :seconds)) <= :beforeTs", nativeQuery = true)
    List<NetEntry> elapsedBySeconds(@Param("netId") long netId, @Param("seconds") long seconds, @Param("beforeTs") OffsetDateTime beforeTs);
}
