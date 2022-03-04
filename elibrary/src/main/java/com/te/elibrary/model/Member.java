package com.te.elibrary.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
	
	@Id
	@GeneratedValue
	private Integer memberId;
	private String name;
	private String address;
	private String email;
	private long phone;
	

}

