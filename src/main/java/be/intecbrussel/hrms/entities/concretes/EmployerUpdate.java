package be.intecbrussel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employer_updates")
public class EmployerUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="update_id")
	private int updateId;
	
	@NotNull
	@NotBlank
	@Column(name="employer_id")
	private int employerId;
	
	@JsonIgnore
	@Column(name="employee_id")
	private Integer employeeId;
	
	@NotNull
	@NotBlank
	@Length(min=10, max=10)
	@Column(name="phone_number")
	private String phoneNumber;
	
	@NotNull
	@NotBlank
	@Email
	@Column(name="email")
	private String email;
	
	@NotNull
	@NotBlank
	@Length(min=5)
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@NotBlank
	@Column(name="web_site")
	private String webSite;
	
	@JsonIgnore
	@Column(name="approve_status")
	private Boolean approveStatus = false;
	
	@JsonIgnore
	@Column(name="approve_date")
	private LocalDate approveDate = LocalDate.now();
	
	@JsonIgnore
	@OneToOne(mappedBy = "employerUpdate")
	private ConfirmingUpdate confirmingUpdate;
}
