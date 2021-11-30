package com.app.main.service;

import java.util.List;

import com.app.main.model.Position;
import com.app.main.model.Trade;

public interface TradeService {
	List<Trade> getAllTrades();

	void enterTrade(Trade trade);

	List<Position> getAllPositions();
} 
