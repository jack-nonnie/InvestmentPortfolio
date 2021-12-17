package com.app.main.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.app.main.model.Search;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class SearchServiceImpl implements SearchService{

    @Value("${apiKey}")
    private String apiKey;

    @Value("${cryptoKey}")
    private String cryptoKey;

    @Value("${currKey}")
    private String currKey;
    
    @Override
    public Map<String, Object> searchStock(Search search){
        
        String str = "https://finnhub.io/api/v1/quote?symbol=" + search.getStr().toUpperCase() + "&token=" + apiKey;
        String str2 = "https://finnhub.io/api/v1/stock/metric?symbol=" + search.getStr() + "&metric=all&token=" + apiKey; 
        try { 
            URI uri = new URI(str);
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> priceMap = restTemplate.getForObject(uri, Map.class);
            URI uri2 = new URI(str2);
            RestTemplate r = new RestTemplate();
            Map<String, Map<String, Object>> a = r.getForObject(uri2, Map.class);
            if(a == null){
                return new HashMap<>();
            }
            Map<String, Object> map = a.get("metric");
            if(priceMap == null){
                return new HashMap<>();
            }
            map.put("currentPrice", priceMap.get("c"));
            return map;
        } catch (URISyntaxException e) {
            return new HashMap<>();
        }
    }
    @Override
    public Map<String, Object> searchCrypto(Search search){
        String str = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=" + search.getStr().toUpperCase() + "&CMC_PRO_API_KEY=" + cryptoKey;
        URI uri;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            uri = new URI(str);
            RestTemplate coinRestTemplate = new RestTemplate();
            Map<String, Map<String, Map<String, Map<String, Map<String, Object>>>>> coinMap = coinRestTemplate.getForObject(uri, Map.class);
            if(coinMap == null){
                return map;
            }
            if(coinMap.get("data") == null){
                return map;
            }
            if(coinMap.get("data").get(search.getStr().toUpperCase()) == null){
                return map;
            }
            if(coinMap.get("data").get(search.getStr().toUpperCase()).get("quote") == null){
                return map;
            }
            if(coinMap.get("data").get(search.getStr().toUpperCase()).get("quote").get("USD") == null){
                return map;
            }
            map.put("max_supply", coinMap.get("data").get(search.getStr().toUpperCase()).get("max_supply"));
            map.put("circulating_supply", coinMap.get("data").get(search.getStr().toUpperCase()).get("circulating_supply"));
            map.put("total_supply", coinMap.get("data").get(search.getStr().toUpperCase()).get("total_supply"));
            map.put("name", coinMap.get("data").get(search.getStr().toUpperCase()).get("name"));
            map.put("symbol", coinMap.get("data").get(search.getStr().toUpperCase()).get("symbol"));
            
            map.put("price", coinMap.get("data").get(search.getStr().toUpperCase()).get("quote").get("USD").get("price"));
            map.put("market_cap", coinMap.get("data").get(search.getStr().toUpperCase()).get("quote").get("USD").get("market_cap"));
            return map;
        } catch (URISyntaxException | HttpClientErrorException.BadRequest  e) {
            return map;
        }
        
    }
    @Override
    public Map<String, Object> searchCurr(Search search){
        String str = "https://web-services.oanda.com/rates/api/v1/rates/" + search.getStr() + ".json?api_key=" + currKey + "&quote=usd";
        URI uri;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            uri = new URI(str);
            RestTemplate currRestTemplate = new RestTemplate();
            Map<String, Map<String, Map<String, Object>>> currMap = currRestTemplate.getForObject(uri, Map.class);
            if(currMap == null){
                return map;
            }
            map.put("symbol", search.getStr().toUpperCase());
            map.put("price", currMap.get("quotes").get("USD").get("ask"));
            return map;
        } catch (URISyntaxException | HttpClientErrorException.BadRequest  e) {
            return map;
        }
        
    }
}
