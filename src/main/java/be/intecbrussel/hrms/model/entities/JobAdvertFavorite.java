package be.intecbrussel.hrms.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="job_advert_favorites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFavorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="favorite_id")
	private int favoriteId;
	
	@ManyToOne
	@JoinColumn(name="unemployed_id", referencedColumnName = "user_id")
	private Unemployed unemployed;
	
	@ManyToOne
	@JoinColumn(name="advert_id")
	private JobAdvertisement jobAdvertisement;
}
