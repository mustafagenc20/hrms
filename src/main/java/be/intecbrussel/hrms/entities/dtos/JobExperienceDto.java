package be.intecbrussel.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
	
	private int unemployedId;
	
	private String workplaceName;
	private String positionName;
	private LocalDate startDate;
	private LocalDate leaveDate;

}
