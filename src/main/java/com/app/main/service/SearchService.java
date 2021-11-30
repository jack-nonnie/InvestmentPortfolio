package com.app.main.service;

import java.util.ArrayList;
import java.util.Map;

import com.app.main.model.Search;

public interface SearchService {
    public Map<String, Object> searchStock(Search search);
}
