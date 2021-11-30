package com.app.main.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.app.main.model.Search;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchServiceImpl implements SearchService{
    @Override
    public Map<String, Object> searchStock(Search search){
        
        final String apiKey = System.getProperty("apiKey");
        String str2 = "https://finnhub.io/api/v1/stock/metric?symbol=" + search.getStr() + "&metric=all&token=" + apiKey;
        try { 
            URI uri = new URI(str2);
            RestTemplate r = new RestTemplate();
            Map<String, Map<String, Object>> a = r.getForObject(uri, Map.class);
            return a.get("metric");
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            return new HashMap<String, Object>();
        }
    }
}
