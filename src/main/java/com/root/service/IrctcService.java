package com.root.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.dao.IrctcRepository;
import com.root.request.PassengerRequest;
import com.root.response.TicketResponse;

@Service
public class IrctcService {

	@Autowired
	private IrctcRepository dao;

	public String saveTicket(PassengerRequest request) {
		TicketResponse res = new TicketResponse();
		res.setTicketId(123456);
		res.setName(request.getName());
		res.setStatus("CONFIRMED!!");
		res.setCost(400.0);
		res.setFrom(request.getFrom());
		res.setTo(request.getTo());
		res.setJDate(request.getJDate());
		String pnr = UUID.randomUUID().toString();
		res.setPnr(pnr);

		dao.saveTicketDetails(res);

		return pnr;

	}

	public TicketResponse getTicketDetails(String pnr) {

		return dao.getTicketDetails(pnr);
	}

}
