package com.app.main.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.app.main.model.Stocks;

public interface StockService {
	List<Stocks> getAllStocks();

	void enterStock(Stocks stock);

	Stocks getStockById(long id);

	// void deleteStockById(long id);
	Page<Stocks> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
 