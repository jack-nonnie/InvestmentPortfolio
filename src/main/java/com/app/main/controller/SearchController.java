package com.app.main.controller;

import java.util.ArrayList;
import java.util.Map;

import com.app.main.model.Search;
import com.app.main.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping("/")
    public String viewHome(Model model){
        Search search = new Search();
        model.addAttribute("search", search);
        model.addAttribute("results", new ArrayList<Map<String,Object>>());
        model.addAttribute("cryptoResults", new ArrayList<Map<String,Object>>());
        model.addAttribute("currResults", new ArrayList<Map<String,Object>>());
        return "index";
    }
    @PostMapping("/search")
    public String search(Model model, @ModelAttribute("search") Search search){
        Map<String,Object> result = searchService.searchStock(search);
        if(result.size() <= 1){
            model.addAttribute("errorMessage", "The ticker you searched for cannot be found. Please try a different ticker.");
            return "error";
        }
        result.put("ticker", search.getStr());
        ArrayList<Map<String, Object>> r = new ArrayList<Map<String,Object>>(); 
        r.add(result);
        model.addAttribute("results", r);
        model.addAttribute("cryptoResults", new ArrayList<Map<String,Object>>());
        model.addAttribute("currResults", new ArrayList<Map<String,Object>>());
        return "index";
    }
    @PostMapping("/cryptoSearch")
    public String cryptoSearch(Model model, @ModelAttribute("search") Search search){
        Map<String, Object> crypto = searchService.searchCrypto(search);
        if(crypto.size() <= 1){
            model.addAttribute("errorMessage", "The coin you searched for cannot be found. Please try a different coin.");
            return "error";
        }
        ArrayList<Map<String,Object>> cryptoResults = new ArrayList<Map<String,Object>>();
        cryptoResults.add(crypto);
        model.addAttribute("search", search);
        model.addAttribute("results", new ArrayList<Map<String,Object>>());
        model.addAttribute("cryptoResults", cryptoResults);
        model.addAttribute("currResults", new ArrayList<Map<String,Object>>());
        return "index";
    }
    @PostMapping("/currSearch")
    public String currSearch(Model model, @ModelAttribute("search") Search search){
        Map<String, Object> curr = searchService.searchCurr(search);
        if(curr.size() <= 1){
            model.addAttribute("errorMessage", "The currency you searched for cannot be found. Please try again.");
            return "error";
        }
        ArrayList<Map<String,Object>> currResults = new ArrayList<Map<String,Object>>();
        currResults.add(curr);
        model.addAttribute("search", search);
        model.addAttribute("results", new ArrayList<Map<String,Object>>());
        model.addAttribute("cryptoResults", new ArrayList<Map<String,Object>>());
        model.addAttribute("currResults", currResults);
        return "index";
    }
}
