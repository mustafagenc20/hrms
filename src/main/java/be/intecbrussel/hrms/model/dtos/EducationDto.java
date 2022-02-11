package be.intecbrussel.hrms.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	
	private int unemployedId;
	
	@NotNull
	@NotBlank
	private String schoolName;
	
	@NotNull
	@NotBlank
	private String department;
	
	@NotNull
	@NotBlank
	private LocalDate startDate;
	
	@Nullable
	private LocalDate graduatedDate;

}
