package com.root.request;

import lombok.Data;

@Data
public class PassengerRequest 
{
	private String name;
	private String email;
	private Long phoneNo;
	private String from;
	private String to;
	private String jDate;
	private String trainNo;

}
