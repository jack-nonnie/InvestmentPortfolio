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
        //System.setProperty("apiKey", );
        final String apiKey = System.getProperty("apiKey");

        String str = "https://finnhub.io/api/v1/quote?symbol=" + search.getStr().toUpperCase() + "&token=" + apiKey;
        String str2 = "https://finnhub.io/api/v1/stock/metric?symbol=" + search.getStr() + "&metric=all&token=" + apiKey;
        try { 
            URI uri = new URI(str);
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> priceMap = restTemplate.getForObject(uri, Map.class);
            URI uri2 = new URI(str2);
            RestTemplate r = new RestTemplate();
            Map<String, Map<String, Object>> a = r.getForObject(uri2, Map.class);
            Map<String, Object> map = a.get("metric");
            map.put("currentPrice", priceMap.get("c"));
            return map;
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            return new HashMap<String, Object>();
        }
    }
}