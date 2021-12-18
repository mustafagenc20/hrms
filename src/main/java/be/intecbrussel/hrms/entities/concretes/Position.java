package be.intecbrussel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="positions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","advertisements"})
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="position_id")
	private int positionId;
	
	@NotBlank
	@NotNull
	@Column(name="position_name")
	private String positionName;
	
	@OneToMany(mappedBy="position")
	@JsonIgnore
	private List<JobAdvertisement> advertisements;
	
	@OneToMany(mappedBy="position")
	@JsonIgnore
	private List<Employee> employee;
	
}
