package be.intecbrussel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "unemployeds")
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Unemployed extends User {

	@NotBlank
	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name = "nationality_id")
	private String nationalityId;

	@NotNull
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "unemployed")
	@JsonIgnore
	private List<Language> languages;

	@OneToMany(mappedBy = "unemployed")
	@JsonIgnore
	private List<Link> links;

	@OneToMany(mappedBy = "unemployed")
	@JsonIgnore
	private List<JobExperience> jobExperiences;

	@OneToMany(mappedBy = "unemployed")
	@JsonIgnore
	private List<CoverLetter> coverLetters;

	@OneToMany(mappedBy = "unemployed")
	@JsonIgnore
	private List<Technology> technologies;

	@OneToMany(mappedBy = "unemployed")
	@JsonIgnore
	private List<JobAdvertFavorite> advertFavorites;

	@OneToOne(mappedBy = "unemployed")
	@JsonIgnore
	private Photo photos;
}
