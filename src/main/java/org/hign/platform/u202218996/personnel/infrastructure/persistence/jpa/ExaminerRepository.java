package org.hign.platform.u202218996.personnel.infrastructure.persistence.jpa;

import org.hign.platform.u202218996.personnel.domain.model.Examiner;
import org.hign.platform.u202218996.shared.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    Optional<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}


