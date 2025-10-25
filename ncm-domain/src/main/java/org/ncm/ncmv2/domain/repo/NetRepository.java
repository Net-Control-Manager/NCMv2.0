package org.ncm.ncmv2.domain.repo;

import org.ncm.ncmv2.domain.model.Net;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetRepository extends JpaRepository<Net, Long> {
}
