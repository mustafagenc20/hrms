package be.intecbrussel.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@NotBlank
	@NotNull
	@Length(min=10, max = 10)
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@NotBlank
	@NotNull
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@NotNull
	@Length(min=6, max=20)
	@Column(name = "password")
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	@Column(name="mail_is_verify")
	private Boolean mailIsVerify = false;
}
