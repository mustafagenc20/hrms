package be.intecbrussel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "educations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int educationId;
	
	@NotBlank
	@NotNull
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank
	@NotNull
	@Column(name = "department")
	private String department;

	@NotBlank
	@NotNull
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Nullable
	@Column(name = "graduated_date")
	private LocalDate graduatedDate;
	
	@ManyToOne
	@JoinColumn(name = "unemployed_id", referencedColumnName = "user_id")
	private Unemployed unemployed;
}
