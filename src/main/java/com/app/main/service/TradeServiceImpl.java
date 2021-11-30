package com.app.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.main.model.Trade;
import com.app.main.model.Position;
import com.app.main.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	@Override
	public List<Trade> getAllTrades() {
		return tradeRepository.findAll();
	}

	@Override
	public void enterTrade(Trade trade) {
		this.tradeRepository.save(trade);
	}

	@Override
	public List<Position> getAllPositions() {
		List<Trade> trades = tradeRepository.findAll();
		List<Position> positions = new ArrayList<Position>();
		for (int i = 0; i < trades.size(); i++) {
			int index = -1;
			for (int j = 0; j < positions.size(); j++) {
				if (trades.get(i).getSymbol().equals(positions.get(j).getTicker())) {
					index = j;
					break;
				} 
			}
			if (index == -1) {
				Position p = new Position(trades.get(i).getSymbol(), trades.get(i).getAmount(),
						trades.get(i).getPrice());
				positions.add(p);
			} else {
				Position p = positions.get(index);
				p.addTradeToPosition(trades.get(i).getAmount(), trades.get(i).getPrice());
				positions.set(index, p);
			}
		}
		return positions;
	}
}
