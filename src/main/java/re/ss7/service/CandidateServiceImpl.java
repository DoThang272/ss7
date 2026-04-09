package re.ss7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.ss7.dto.request.CandidateCreateRequest;
import re.ss7.dto.respose.CandidateResponse;
import re.ss7.entity.Candidate;
import re.ss7.exception.ResourceAlreadyExistsException;
import re.ss7.repository.CandidateRepository;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl  implements CandidateService{

    private final CandidateRepository candidateRepository;

    @Override
    public CandidateResponse createCandidate(CandidateCreateRequest request) {
        if (candidateRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Email already exists");
        }

        Candidate candidate = Candidate.builder()
                .fullName(request.getFullName().trim())
                .email(request.getEmail().trim())
                .age(request.getAge())
                .yearsOfExperience(request.getYearsOfExperience())
                .build();

        Candidate savedCandidate = candidateRepository.save(candidate);

        return mapToResponse(savedCandidate);
    }

    private CandidateResponse mapToResponse(Candidate candidate) {
        return CandidateResponse.builder()
                .id(candidate.getId())
                .fullName(candidate.getFullName())
                .email(candidate.getEmail())
                .age(candidate.getAge())
                .yearsOfExperience(candidate.getYearsOfExperience())
                .build();
    }
}
