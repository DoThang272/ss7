package re.ss7.dto.respose;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateResponse {
    private Integer id;
    private String fullName;
    private String email;
    private Integer age;
    private Integer yearsOfExperience;
}
