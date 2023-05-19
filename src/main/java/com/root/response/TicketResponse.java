package com.root.response;

import lombok.Data;

@Data
public class TicketResponse 
{
	private Integer ticketId;
	private String status;
	private Double cost;
	private String from;
	private String to;
	private String pnr;
	private String jDate;
	private String name;
}
