package org.hign.platform.u202218996.personnel.application.acl;

import java.util.Optional;
import java.util.UUID;

public interface ExaminerService {
    Optional<ExaminerDTO> findExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier);
}

