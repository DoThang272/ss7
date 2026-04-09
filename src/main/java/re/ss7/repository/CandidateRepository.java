package re.ss7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ss7.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    boolean existsByEmail(String email);
}
