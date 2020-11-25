package org.acme.resource;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonForm {

	public String name;
	
	@JsonFormat(pattern = "yyyy/mm/dd")
	public LocalDate birth;
	
	public Status status;
	
	public enum Status{
		Alive,
		DECEASED
	}
	
}
