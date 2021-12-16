package com.app.main.controller;

import java.util.List;

import com.app.main.model.Cash;
import com.app.main.model.Position;
import com.app.main.service.CashService;
import com.app.main.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {
	@Autowired
	private TradeService tradeService;
	@Autowired
	private CashService cashService;

	@GetMapping("/portfolio") 
	public String portfolio(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		List<Position> positions = tradeService.getAllPositions();
		model.addAttribute("positions", positions);
		String totalInitialPrice = tradeService.getInitialPositionTotalValue(positions);
		String totalValuation = tradeService.getTotalPositionValue(positions);
		model.addAttribute("totalInitialPrice", totalInitialPrice);
		model.addAttribute("totalValuation", totalValuation);
		String totalProfitLoss = tradeService.getTotalProfitLoss(totalInitialPrice,totalValuation);
		model.addAttribute("totalProfitLoss", totalProfitLoss);
		double cashBalance = cashService.getBalance();
		model.addAttribute("cashBalance", String.valueOf(cashBalance));
		Cash cash = new Cash();
		model.addAttribute("cash", cash);
		return "portfolio";
	}

	@GetMapping("/list")
	public String list(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "list";
	}

	@PostMapping("/deposit")
	public String deposit(@ModelAttribute("cash") Cash cash){
		cashService.enterTransaction(cash);
		return "redirect:/portfolio";
	}
}
