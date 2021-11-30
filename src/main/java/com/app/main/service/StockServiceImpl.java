package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.app.main.model.Stocks;
import com.app.main.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stocks> getAllStocks() {
		return stockRepository.findAll();
	}

	@Override
	public void enterStock(Stocks stock) {
		this.stockRepository.save(stock);
	}

	@Override
	public Stocks getStockById(long id) {
		Optional<Stocks> optional = stockRepository.findById(id);
		Stocks stock = null;
		if (optional.isPresent()) {
			stock = optional.get();
		} else {
			throw new RuntimeException(" Stock not found for id :: " + id);
		}
		return stock;
	}

	@Override
	public Page<Stocks> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {

		

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		return this.stockRepository.findAll(pageable);
	} 
}
