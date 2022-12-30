package net.sms.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Field must not be null or blank")
	@Column(name = "first_name")
	private String firstName;
	@NotNull(message="Field must not be null or blank")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message="Field must not be null or blank")
	@Email(message="Enter a valid email address")
	@Column(name = "email_id")
	private String emailId;
	

}
