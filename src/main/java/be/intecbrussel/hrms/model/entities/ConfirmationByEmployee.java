package be.intecbrussel.hrms.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "confirmation_by_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","employee"})
public class ConfirmationByEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "confirm_id")
	private int confirmId;
	
	@Column(name = "verified_status")
	private boolean verifiedStatus;
	
	@JsonIgnore
	@Column(name = "approval_date")
	private LocalDateTime approvalDate = LocalDateTime.now();
	
	@ManyToOne()
	@JoinColumn(name="employee_id", referencedColumnName = "user_id")
	private Employee employee;
}
