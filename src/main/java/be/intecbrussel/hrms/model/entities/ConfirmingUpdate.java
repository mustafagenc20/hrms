package be.intecbrussel.hrms.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="confirming_updates")
@PrimaryKeyJoinColumn(name = "confirm_id")
@EqualsAndHashCode(callSuper = true)
public class ConfirmingUpdate extends ConfirmationByEmployee {

	@ManyToOne()
	@JoinColumn(name="employer_id", referencedColumnName = "user_id")
	private Employer employer;
	
	@OneToOne()
	@JoinColumn(name="update_id")
	private EmployerUpdate employerUpdate;
}
