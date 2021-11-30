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
        model.addAttribute("reults", new ArrayList<Map>());
        return "index";
    }
    @PostMapping("/search")
    public String search(Model model, @ModelAttribute("search") Search search){
        System.out.println("HELLLLLL");
        ArrayList<Map> result = searchService.searchStock(search);
        System.out.println(result);
        model.addAttribute("results", result);
        return "index";
    }
}
