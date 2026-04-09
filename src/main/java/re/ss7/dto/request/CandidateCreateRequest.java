package re.ss7.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateCreateRequest {
    @NotBlank(message = "Full name must not be blank")
    @Size(min = 5, max = 50, message = "Full name must be between 5 and 50 characters")
    private String fullName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email is invalid")
    private String email;

    @NotNull(message = "Age must not be null")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotNull(message = "Years of experience must not be null")
    @Min(value = 0, message = "Years of experience must be greater than or equal to 0")
    private Integer yearsOfExperience;
}
