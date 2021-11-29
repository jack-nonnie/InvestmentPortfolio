package com.app.main.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.main.model.Position;
import com.app.main.model.Trade;

public interface TradeService {
	List<Trade> getAllTrades();

	void enterTrade(Trade trade);

	// Trade getTradeById(long id);
	// void deleteTradeById(long id);
	// Page<Trade> findPaginated(int pageNo, int pageSize, String sortField, String
	// sortDirection);
	List<Position> getAllPositions();
}
