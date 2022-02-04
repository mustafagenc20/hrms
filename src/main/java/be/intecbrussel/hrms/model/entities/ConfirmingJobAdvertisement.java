package be.intecbrussel.hrms.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="confirming_jobadvertisements")
@PrimaryKeyJoinColumn(name = "confirm_id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ConfirmingJobAdvertisement extends ConfirmationByEmployee {
	
	@OneToOne()
	@JoinColumn(name="advert_id")
	private JobAdvertisement jobAdvertisement;
}
