package be.intecbrussel.hrms.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employment_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentType {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="type_id")
	private int typeId;
	
	@Column(name = "type_name")
	private String typeName;
	
	@JsonIgnore
	@OneToMany(mappedBy="employmentType")
	private List<JobAdvertisement> jobAdvertisements;
}
