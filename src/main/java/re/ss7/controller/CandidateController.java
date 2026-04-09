package re.ss7.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.ss7.dto.request.CandidateCreateRequest;
import re.ss7.dto.respose.ApiResponse;
import re.ss7.dto.respose.CandidateResponse;
import re.ss7.service.CandidateService;

@RestController
@RequestMapping("api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    @PostMapping
    public ResponseEntity<ApiResponse<CandidateResponse>> createCandidate(
            @Valid @RequestBody CandidateCreateRequest request
    ) {
        CandidateResponse response = candidateService.createCandidate(request);

        ApiResponse<CandidateResponse> apiResponse = ApiResponse.<CandidateResponse>builder()
                .status("SUCCESS")
                .message("Candidate created successfully")
                .data(response)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
