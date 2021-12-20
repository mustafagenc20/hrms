package be.intecbrussel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employer extends User {
	
	@NotBlank
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name = "web_site")
	private String webSite;
	
	@JsonIgnore
	@Column(name="waiting_for_update")
	private Boolean waitingForUpdate = false;
	
	@JsonIgnore
	@Column(name="employer_is_confirmed")
	private Boolean employerIsConfirmed = false;
	
	@JsonIgnore
	@OneToOne(mappedBy="employer")
	private ConfirmingEmployer confirmingEmployer;
	
	@OneToMany(mappedBy="employer")
	@JsonIgnore
	private List<JobAdvertisement> advertisements;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<ConfirmingUpdate> confirmingUpdates;
}
