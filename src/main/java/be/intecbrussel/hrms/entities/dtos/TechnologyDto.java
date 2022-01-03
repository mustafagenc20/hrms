package be.intecbrussel.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDto {
	
	private int unemployedId;
	private String technologyName;
	
	@Min(1)
	@Max(5)
	private int technologyLevel;

}
