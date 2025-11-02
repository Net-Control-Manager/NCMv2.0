package org.ncm.ncmv2.domain.repo;

import org.ncm.ncmv2.domain.model.NetType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DTO for {@link org.ncm.ncmv2.domain.model.NetType}
 */
public interface NetTypeRepository extends JpaRepository<NetType, Long> {

}