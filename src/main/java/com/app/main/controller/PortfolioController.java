package com.app.main.controller;

import java.util.List;

import com.app.main.model.Position;
import com.app.main.service.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {
	@Autowired
	private TradeService tradeService;

	@GetMapping("/portfolio") 
	public String portfolio(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		List<Position> positions = tradeService.getAllPositions();
		model.addAttribute("positions", positions);

		return "portfolio";
	}

	@GetMapping("/list")
	public String list(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "list";
	}
}
