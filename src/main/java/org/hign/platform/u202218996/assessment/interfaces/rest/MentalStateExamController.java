package org.hign.platform.u202218996.assessment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202218996.assessment.application.services.MentalStateExamService;
import org.hign.platform.u202218996.assessment.domain.model.MentalStateExam;
import org.hign.platform.u202218996.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202218996.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202218996.assessment.interfaces.rest.transform.MentalStateExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * MentalStateExamController.
 * <p>
 * This class provides RESTful endpoints for managing mental state exams.
 * </p>
 * <ul>
 *     <li>POST /api/v1/mental-state-exams - Create a new mental state exam</li>
 * </ul>
 *
 * @author Luiggi Paredes U202218996
 */
@RestController
@RequestMapping("/api/v1/mental-state-exams")
@Tag(name = "Mental State Exams", description = "Endpoints for managing mental state exams")
public class MentalStateExamController {

    private final MentalStateExamService mentalStateExamService;

    public MentalStateExamController(MentalStateExamService mentalStateExamService) {
        this.mentalStateExamService = mentalStateExamService;
    }

    /**
     * Create a new mental state exam.
     *
     * @param resource the resource containing the mental state exam information
     * @return the created mental state exam resource
     */
    @PostMapping
    @Operation(summary = "Create a new mental state exam")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mental state exam created successfully",
                    content = @Content(schema = @Schema(implementation = MentalStateExamResource.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {
        Date examDate = Date.valueOf(resource.examDate());
        MentalStateExam exam = mentalStateExamService.addMentalStateExam(
                resource.patientId(),
                resource.examinerNationalProviderIdentifier(),
                examDate,
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
        MentalStateExamResource examResource = MentalStateExamResourceFromEntityAssembler.toResourceFromEntity(exam);
        return new ResponseEntity<>(examResource, HttpStatus.CREATED);
    }
}


