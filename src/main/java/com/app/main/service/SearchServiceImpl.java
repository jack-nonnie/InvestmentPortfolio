package com.app.main.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import com.app.main.model.Search;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchServiceImpl implements SearchService{
    @Override
    public ArrayList<Map> searchStock(Search search){
        
        final String apiKey = System.getProperty("apiKey");
        String str = "https://finnhub.io/api/v1/search?q=" + search.getStr() + "&token=" + apiKey;
        try { 
            URI uri = new URI(str);
            RestTemplate restTemplate = new RestTemplate();
            Map<String, ArrayList<Map>> s = restTemplate.getForObject(uri, Map.class);
            
            return s.get("result");
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            return new ArrayList<Map>();
        }
    }
}
