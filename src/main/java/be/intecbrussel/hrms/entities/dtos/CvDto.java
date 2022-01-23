package be.intecbrussel.hrms.entities.dtos;

import be.intecbrussel.hrms.entities.concretes.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	@JsonIgnoreProperties({"id","password"})
	private Unemployed unemployed;
	
	@JsonIgnoreProperties({"unemployed"})
	private List<Education> educations;
	
	@JsonIgnoreProperties({"unemployed"})
	private List<JobExperience> jobExperiences;
	
	@JsonIgnoreProperties({"unemployed"})
	private List<Technology> technologies;
	
	@JsonIgnoreProperties({"unemployed"})
	private List<Language> languages;
	
	@JsonIgnoreProperties({"unemployed"})
	private Link link;
	
	@JsonIgnoreProperties({"unemployed"})
	private CoverLetter coverLetter;
	
	@JsonIgnoreProperties({"unemployed"})
	private Photo photo;
}
