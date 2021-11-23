package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.main.model.Trade;
import com.app.main.repository.TradeRepository;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	// @Override
	// public List<Trade> getAllTrades() {
	// 	return tradeRepository.findAll();
	// }

	@Override
	public void enterTrade(Trade trade) {
		this.tradeRepository.save(trade);
	}

	// @Override
	// public Trade getTradeById(long id) {
	// 	Optional<Trade> optional = tradeRepository.findById(id);
	// 	Trade trade = null;
	// 	if (optional.isPresent()) {
	// 		trade = optional.get();
	// 	} else {
	// 		throw new RuntimeException(" Trade not found for id :: " + id);
	// 	}
	// 	return trade;
	// }

	// @Override
	// public void deleteTradeById(long id) {
	// 	this.tradeRepository.deleteById(id);
	// }

	// @Override
	// public Page<Trade> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	// 	Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	// 		Sort.by(sortField).descending();
		
	// 	Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	// 	return this.tradeRepository.findAll(pageable);
	// }
}
