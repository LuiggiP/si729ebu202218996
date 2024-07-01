package org.hign.platform.u202218996.assessment.interfaces.rest.resources;

public record MentalStateExamResource(
        Long id,
        Long patientId,
        String examinerNationalProviderIdentifier,
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
