package com.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.root.request.PassengerRequest;
import com.root.response.TicketResponse;
import com.root.service.IrctcService;

@RestController
public class IrctcRestController {
	@Autowired
	private IrctcService service;

	@PostMapping(value = "/bookTicket", consumes = { "application/xml", "application/json" })
	public ResponseEntity<String> bookTicket(@RequestBody PassengerRequest request) {
		String pnr = service.saveTicket(request);
		String msg = "Tickt booking confirmed... "+pnr;
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{pnr}", produces = { "application/xml", "application/json" })
	public ResponseEntity<TicketResponse> fetchTicketDetails(@PathVariable("pnr") String pnr) {
		TicketResponse response = service.getTicketDetails(pnr);
		return new ResponseEntity<TicketResponse>(response, HttpStatus.OK);
	}

}
