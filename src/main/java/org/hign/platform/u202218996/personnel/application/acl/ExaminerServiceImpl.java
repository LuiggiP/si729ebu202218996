package org.hign.platform.u202218996.personnel.application.acl;

import org.hign.platform.u202218996.personnel.infrastructure.persistence.jpa.ExaminerRepository;
import org.hign.platform.u202218996.shared.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final ExaminerRepository examinerRepository;

    public ExaminerServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<ExaminerDTO> findExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier) {
        return examinerRepository.findByNationalProviderIdentifier(new NationalProviderIdentifier(nationalProviderIdentifier.toString()))
                .map(examiner -> new ExaminerDTO(
                        examiner.getId(),
                        examiner.getFirstName(),
                        examiner.getLastName(),
                        examiner.getNationalProviderIdentifier().getValue()
                ));
    }
}

