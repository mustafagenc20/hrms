package be.intecbrussel.hrms.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","confirmingJobAdvertisement"})
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advert_id")
	private int advertId;

	@NotBlank
	@NotNull
	@Column(name = "min_salary")
	private int minSalary;

	@NotBlank
	@NotNull
	@Column(name = "max_salary")
	private int maxSalary;

	@NotBlank
	@NotNull
	@Column(name = "quota")
	private int quota;

	@NotBlank
	@NotNull
	@Column(name = "last_application")
	private String lastApplication;

	@Column(name = "created_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "advert_status")
	private Boolean advertStatus = false;
	
	@Column(name = "advert_is_confirmed")
	private Boolean advertIsConfirmed = false;

	@NotBlank
	@NotNull
	@Column(name = "job_description")
	private String jobDescription;

	@ManyToOne()
	@JoinColumn(name = "employer_id", referencedColumnName = "user_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "position_id")
	private Position position;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="type_id")
	private EmploymentType employmentType;
	
	@ManyToOne()
	@JoinColumn(name="time_id")
	private EmploymentTime employmentTime;
	
	@OneToMany(mappedBy="jobAdvertisement")
	@JsonIgnore
	private List<JobAdvertFavorite> advertFavorites; 
	
	@JsonIgnore
	@OneToOne(mappedBy="jobAdvertisement")
	private ConfirmingJobAdvertisement confirmingJobAdvertisement;
	
	
	

}
