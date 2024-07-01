package org.hign.platform.u202218996.assessment.domain.model;

import org.hign.platform.u202218996.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.u202218996.shared.domain.model.valueobjects.NationalProviderIdentifier;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

/**
 * MentalStateExam.
 * <p>
 * Represents a mental state exam.
 * </p>
 *
 * @author Luiggi Paredes U202218996
 */
@Entity
@Getter
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @Column(nullable = false)
    private Long patientId;

    @Embedded
    private NationalProviderIdentifier examinerNationalProviderIdentifier;

    @Column(nullable = false)
    private Date examDate;

    @Column(nullable = false)
    private Integer orientationScore;

    @Column(nullable = false)
    private Integer registrationScore;

    @Column(nullable = false)
    private Integer attentionAndCalculationScore;

    @Column(nullable = false)
    private Integer recallScore;

    @Column(nullable = false)
    private Integer languageScore;

    /**
     * Constructs a new MentalStateExam with the given values.
     *
     * @param patientId the patient ID
     * @param examinerNationalProviderIdentifier the national provider identifier of the examiner
     * @param examDate the date of the exam
     * @param orientationScore the orientation score
     * @param registrationScore the registration score
     * @param attentionAndCalculationScore the attention and calculation score
     * @param recallScore the recall score
     * @param languageScore the language score
     */
    public MentalStateExam(Long patientId, NationalProviderIdentifier examinerNationalProviderIdentifier, Date examDate, Integer orientationScore, Integer registrationScore, Integer attentionAndCalculationScore, Integer recallScore, Integer languageScore) {
        this.patientId = patientId;
        this.examinerNationalProviderIdentifier = examinerNationalProviderIdentifier;
        this.examDate = examDate;
        this.orientationScore = orientationScore;
        this.registrationScore = registrationScore;
        this.attentionAndCalculationScore = attentionAndCalculationScore;
        this.recallScore = recallScore;
        this.languageScore = languageScore;
    }

    /**
     * Default constructor for JPA.
     */
    protected MentalStateExam() {
    }
}

