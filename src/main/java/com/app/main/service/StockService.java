package com.app.main.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.main.model.Stock;

public interface StockService {
	List<Stock> getAllStocks();
	void enterStock(Stock stock);
	Stock getStockById(long id);
	// void deleteStockById(long id);
	Page<Stock> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
