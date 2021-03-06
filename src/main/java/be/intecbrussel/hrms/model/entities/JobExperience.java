package be.intecbrussel.hrms.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "job_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","unemployed"})
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int experienceId;
	
	@NotNull
	@NotBlank
	@Column(name = "workplace_name")
	private String workplaceName;
	
	@NotNull
	@NotBlank
	@Column(name = "position_name")
	private String positionName;
	
	@NotNull
	@NotBlank
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "leave_date")
	private LocalDate leaveDate;
	
	@ManyToOne()
	@JoinColumn(name = "unemployed_id", referencedColumnName = "user_id")
	private Unemployed unemployed;
	
}
