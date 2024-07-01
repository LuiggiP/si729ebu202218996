package org.hign.platform.u202218996.personnel.application.acl;

import java.util.UUID;

public record ExaminerDTO(Long id, String firstName, String lastName, UUID nationalProviderIdentifier) {
}

