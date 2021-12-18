package be.intecbrussel.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cover_letters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "letter_id")
	private int letterId;
	
	@NotBlank
	@NotNull
	@Column(name = "letter_content")
	private String letterContent;

	@ManyToOne
	@JoinColumn(name = "unemployed_id", referencedColumnName = "user_id")
	private Unemployed unemployed;
}
