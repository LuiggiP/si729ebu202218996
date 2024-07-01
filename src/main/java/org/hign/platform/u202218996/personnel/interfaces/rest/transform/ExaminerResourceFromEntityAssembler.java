package org.hign.platform.u202218996.personnel.interfaces.rest.transform;

import org.hign.platform.u202218996.personnel.domain.model.Examiner;
import org.hign.platform.u202218996.personnel.interfaces.rest.resources.ExaminerResource;

public class ExaminerResourceFromEntityAssembler {
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier().getValue().toString()
        );
    }
}
