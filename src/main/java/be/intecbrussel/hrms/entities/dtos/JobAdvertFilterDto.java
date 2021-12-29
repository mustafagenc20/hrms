package be.intecbrussel.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilterDto {
	
	private List<Integer> cityId;
	private List<Integer> positionId;
	private List<Integer> timeId;
	private List<Integer> typeId;
}
