package com.app.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

import com.app.main.model.Cash;
import com.app.main.model.Trade;
import com.app.main.model.Search;
import com.app.main.service.CashService;
import com.app.main.service.SearchService;
import com.app.main.service.TradeService;

@Controller
public class TradeController {

	@Autowired
	private TradeService tradeService;
	@Autowired
	private SearchService searchService;
	@Autowired 
	private CashService cashService;

	@GetMapping("/trade/{id}")  // {id}")
	public String trade(@PathVariable ( value = "id") String id, Model model) {
		// create model attribute to bind form data
		// Stock stock = stockService.getStockById(id);
		Search search = new Search();
		search.setStr(id);
		// trade.setSymbol(stock.getSymbol());
		Map<String, Object> stock = searchService.searchStock(search);
		Trade trade = new Trade();
		trade.setSymbol(id.toUpperCase());
		trade.setPrice(stock.get("currentPrice").toString());
		model.addAttribute("trade", trade);
		return "trade";
	}

	@PostMapping("/enterTrade")
	public String enterTrade(Model model, @ModelAttribute("trade") Trade trade) {
		// enter trade to database
		trade.setSymbol(trade.getSymbol().toUpperCase());
		double cashBalance = cashService.getBalance();
		if(Double.parseDouble(trade.getCash()) > cashBalance){
			model.addAttribute("errorMessage", "There is not enough cash in your balance to complete the trade. Please deposit more into the account or reduce the amount trying to be purchased.");
			return "error";
		}
		Cash withdrawl = new Cash();
		withdrawl.setAmount(-1 * Double.parseDouble(trade.getCash()));
		cashService.enterTransaction(withdrawl);
		tradeService.enterTrade(trade);
		return "redirect:/";
	}
}
