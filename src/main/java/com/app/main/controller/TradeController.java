package com.app.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.main.model.Stock;

import com.app.main.model.Trade;
import com.app.main.service.StockService;
import com.app.main.service.TradeService;

@Controller
public class TradeController {

	@Autowired
	private TradeService tradeService;
	private StockService stockService;
	
	@GetMapping("/trade/")//{id}")
	public String trade(Model model){//(@PathVariable ( value = "id") long id, Model model) {
		// create model attribute to bind form data
		// Stock stock = stockService.getStockById(id);
		Trade trade = new Trade();
		// trade.setSymbol(stock.getSymbol());
		model.addAttribute("trade", trade);
		return "trade";
	}
	
	@PostMapping("/enterTrade")
	public String enterTrade(@ModelAttribute("trade") Trade trade) {
		// enter trade to database
		tradeService.enterTrade(trade);
		return "redirect:/";
	}
}
