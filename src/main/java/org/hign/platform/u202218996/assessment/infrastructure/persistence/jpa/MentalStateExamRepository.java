package org.hign.platform.u202218996.assessment.infrastructure.persistence.jpa;

import org.hign.platform.u202218996.assessment.domain.model.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}
