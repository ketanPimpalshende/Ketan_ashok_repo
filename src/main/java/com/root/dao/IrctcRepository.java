package com.root.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.root.response.TicketResponse;

@Repository
public class IrctcRepository {
	private Map<String, TicketResponse> map = new HashMap<>();

	public String saveTicketDetails(TicketResponse res) {
		map.put(res.getPnr(), res);
		return res.getPnr();
	}

	public TicketResponse getTicketDetails(String pnr) {
		if (map.containsKey(pnr)) {
			return map.get(pnr);
		}

		return null;
	}

}
