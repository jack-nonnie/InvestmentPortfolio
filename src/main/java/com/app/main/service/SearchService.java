package com.app.main.service;

import java.util.Map;

import com.app.main.model.Search;

public interface SearchService {
    public Map<String, Object> searchStock(Search search);
    public Map<String, Object> searchCrypto(Search search);
    public Map<String, Object> searchCurr(Search search);
}
