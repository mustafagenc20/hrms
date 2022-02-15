package be.intecbrussel.hrms.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {

	@NotBlank
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@Nullable
	@ManyToOne()
	@JoinColumn(name = "position_id")
	private Position position;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<ConfirmationByEmployee> confirmationByEmployee;

}
