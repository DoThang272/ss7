package re.ss7.service;

import re.ss7.dto.request.CandidateCreateRequest;
import re.ss7.dto.respose.CandidateResponse;

public interface CandidateService {
    CandidateResponse createCandidate(CandidateCreateRequest request);
}
