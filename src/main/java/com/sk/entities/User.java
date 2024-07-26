package com.sk.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private int id;
	private String name;
	private String email;
	private String phno;
	private String password;
	private String address;
	private String landmark;
	private String city;
	private String state;
	private String pincode;
	private String check;
	

}
