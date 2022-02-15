package be.intecbrussel.hrms.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
	
	@Id
	@Column(name = "city_id")
	private int cityId;
	
	@Column(name = "city_name")
	private String cityName;
	
	@OneToMany(mappedBy="city")
	@JsonIgnore
	private List<JobAdvertisement> advertisements;
}
