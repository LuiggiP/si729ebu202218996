package org.hign.platform.u202218996.personnel.application.services;

import org.hign.platform.u202218996.personnel.domain.model.Examiner;
import org.hign.platform.u202218996.personnel.infrastructure.persistence.jpa.ExaminerRepository;
import org.hign.platform.u202218996.shared.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ExaminerService.
 * <p>
 * This class provides services for managing examiners.
 * </p>
 *
 * @author Luiggi Paredes U202218996
 */
@Service
public class ExaminerService {

    private final ExaminerRepository examinerRepository;

    public ExaminerService(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Add a new examiner.
     *
     * @param firstName the first name of the examiner
     * @param lastName the last name of the examiner
     * @param nationalProviderIdentifier the national provider identifier of the examiner
     * @return the created examiner
     */
    public Examiner addExaminer(String firstName, String lastName, String nationalProviderIdentifier) {
        NationalProviderIdentifier npi = new NationalProviderIdentifier(nationalProviderIdentifier);
        if (examinerRepository.findByNationalProviderIdentifier(npi).isPresent()) {
            throw new IllegalArgumentException("Examiner with same National Provider Identifier already exists");
        }
        Examiner examiner = new Examiner(firstName, lastName, npi);
        return examinerRepository.save(examiner);
    }

    /**
     * Find an examiner by national provider identifier.
     *
     * @param nationalProviderIdentifier the national provider identifier
     * @return an optional containing the examiner if found, or empty if not
     */
    public Optional<Examiner> findExaminerByNPI(String nationalProviderIdentifier) {
        return examinerRepository.findByNationalProviderIdentifier(new NationalProviderIdentifier(nationalProviderIdentifier));
    }
}

