package be.intecbrussel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employment_times")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "time_id")
	private int timeId;
	
	@Column(name = "time_name")
	private String timeName;
	
	@JsonIgnore
	@OneToMany(mappedBy="employmentTime")
	private List<JobAdvertisement> jobAdvertisements;
}
