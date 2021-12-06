package com.app.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.main.model.Cash;
import com.app.main.model.Trade;
import com.app.main.service.CashService;
import com.app.main.service.TradeService;

@Controller
public class TradeController {

	@Autowired
	private TradeService tradeService;
	@Autowired 
	private CashService cashService;

	@GetMapping("/trade")  // {id}")
	public String trade(Model model) {// (@PathVariable ( value = "id") long id, Model model) {
		// create model attribute to bind form data
		// Stock stock = stockService.getStockById(id);
		Trade trade = new Trade();
		// trade.setSymbol(stock.getSymbol());
		model.addAttribute("trade", trade);
		return "trade";
	}
	@GetMapping("/error")
	public String error(Model model){
		return "error";
	}

	@PostMapping("/enterTrade")
	public String enterTrade(@ModelAttribute("trade") Trade trade) {
		// enter trade to database
		double cashBalance = cashService.getBalance();
		if(Double.parseDouble(trade.getCash()) > cashBalance){
			return "redirect:/error";
		}
		Cash withdrawl = new Cash();
		withdrawl.setAmount(-1 * Double.parseDouble(trade.getCash()));
		cashService.enterTransaction(withdrawl);
		tradeService.enterTrade(trade);
		return "redirect:/";
	}
}
