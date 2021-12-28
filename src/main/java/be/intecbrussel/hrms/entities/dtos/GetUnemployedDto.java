package be.intecbrussel.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUnemployedDto {
	
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String email;

}
