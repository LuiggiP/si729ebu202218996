package org.hign.platform.u202218996.assessment.interfaces.rest.transform;

import org.hign.platform.u202218996.assessment.domain.model.MentalStateExam;
import org.hign.platform.u202218996.assessment.interfaces.rest.resources.MentalStateExamResource;

import java.text.SimpleDateFormat;

public class MentalStateExamResourceFromEntityAssembler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier().getValue().toString(),
                dateFormat.format(entity.getExamDate()),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore()
        );
    }
}
