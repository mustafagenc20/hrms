package be.intecbrussel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "confirming_employers")
@PrimaryKeyJoinColumn(name = "confirm_id")
@EqualsAndHashCode(callSuper = true)
public class ConfirmingEmployer extends ConfirmationByEmployee{
	
	@OneToOne
	@JoinColumn(name="employer_id", referencedColumnName = "user_id")
	private Employer employer;
}
