package com.app.main.service;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import yahoofinance.YahooFinance;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.app.main.model.Stock;
import com.app.main.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public List<Stock> getAllStocks() {
		return stockRepository.findAll();
	}

	@Override
	public void enterStock(Stock stock) {
		this.stockRepository.save(stock);
	}

	@Override
	public Stock getStockById(long id) {
		Optional<Stock> optional = stockRepository.findById(id);
		Stock employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public Page<Stock> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {

		// String[] stocks = {"TSLA", "GOOGL", "BTC", "AAPL", "FB", "AMZN", "MSFT", "NIO", "NVDA", "MRNA"};

		// for(int i = 0; i < stocks.length; i++) {
		// 	try {
		// 		HttpRequest request = HttpRequest.newBuilder()
		// 		.uri(URI.create("https://yfapi.net/v8/finance/chart/" + stocks[i] + "/"))
		// 		.header("x-api-key", "ZRq5PxxiQK5XPX3U12e3F3b8i6RSmQlA4c49PqTk")
		// 		.method("GET", HttpRequest.BodyPublishers.noBody())
		// 		.build();
		// 		HttpResponse<String> response = HttpClient.newHttpClient()
		// 		.send(request, HttpResponse.BodyHandlers.ofString());
	
		// 		JSONObject jsonObject = new JSONObject(response.body());
		// 		System.out.println(jsonObject);
		// 		JSONObject object = jsonObject.getJSONObject("chart");
		// 		JSONArray object2 = object.getJSONArray("result");
		// 		JSONObject object3 = object2.getJSONObject(0).getJSONObject("meta");
		// 		Double price = object3.getDouble("regularMarketPrice");
	
		// 		Stock stock = new Stock(stocks[i],price.toString());
		// 		enterStock(stock);
	
		// 	} catch (Exception e) {
		// 		System.out.println(e.toString());
		// 	}
		// }

		// Insert initial test data
		// Stock stock1 = new Stock("TSLA","1156.87");
		// enterStock(stock1);
		// Stock stock2 = new Stock("GOOGL","2926.04");
		// enterStock(stock2);
		// Stock stock3 = new Stock("BTC","56444.30");
		// enterStock(stock3);
		// Stock stock4 = new Stock("AAPL","161.02");
		// enterStock(stock4);
		// Stock stock5 = new Stock("FB","341.01");
		// enterStock(stock5);
		// Stock stock6 = new Stock("AMZN","3572.57");
		// enterStock(stock6);
		// Stock stock7 = new Stock("MSFT","339.83");
		// enterStock(stock7);
		// Stock stock8 = new Stock("NIO","41.49");
		// enterStock(stock8);
		// Stock stock9 = new Stock("NVDA","319.56");
		// enterStock(stock9);
		// Stock stock10 = new Stock("MRNA","282.69");
		// enterStock(stock10);

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
		Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		// for(Stock x : this.stockRepository.findAll(pageable)) {
		// 	try {
		// 		HttpRequest request = HttpRequest.newBuilder()
		// 		.uri(URI.create("https://yfapi.net/v8/finance/chart/" + stocks[i] + "/"))
		// 		.header("x-api-key", "ZRq5PxxiQK5XPX3U12e3F3b8i6RSmQlA4c49PqTk")
		// 		.method("GET", HttpRequest.BodyPublishers.noBody())
		// 		.build();
		// 		HttpResponse<String> response = HttpClient.newHttpClient()
		// 		.send(request, HttpResponse.BodyHandlers.ofString());
	
		// 		JSONObject jsonObject = new JSONObject(response.body());
		// 		JSONObject object = jsonObject.getJSONObject("chart");
		// 		JSONArray object2 = object.getJSONArray("result");
		// 		JSONObject object3 = object2.getJSONObject(0).getJSONObject("meta");
		// 		Double price = object3.getDouble("regularMarketPrice");
	
		// 		Stock stock = new Stock(stocks[i],price.toString());
		// 		// stock.setSymbol();
		// 		// stock.setPrice();
		// 		enterStock(stock);
	
		// 	} catch (Exception e) {
		// 		System.out.println(e.toString());
		// 	}
		// }

		return this.stockRepository.findAll(pageable);
	}
}
