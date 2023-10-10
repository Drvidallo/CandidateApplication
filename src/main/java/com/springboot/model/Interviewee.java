package com.springboot.model;



import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "interviewee")
public class Interviewee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,50}", message = "Invalid characters in firstName")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,50}", message = "Invalid characters in Last Name")
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,50}", message = "Invalid characters in RRF Number")
	@Column(name = "rrf_number")
	private String rrfNumber;

	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,50}", message = "Invalid characters in Position")
	@Column(name = "position")
	private String position;
	
	@Pattern(regexp = "[a-zA-Z0-9_.-]{1,50}", message = "Invalid characters in noticePeriod")
	@Column(name = "notice_period")
	private String noticePeriod;

	 public Interviewee(
			 String firstName,
			 String lastName,
			 String rrfNumber,
			 String position,
			 String noticePeriod) {
		 
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.rrfNumber = rrfNumber;
	        this.position = position;
	        this.noticePeriod = noticePeriod;
	    }
	

	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}"; // Return an empty JSON object in case of an error
        }
	}
 
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getRrfNumber() {
		return rrfNumber;
	}


	public void setRrfNumber(String rrfNumber) {
		this.rrfNumber = rrfNumber;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getNoticePeriod() {
		return noticePeriod;
	}


	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}


	public Interviewee() {
		
	}
	
}
