package com.app.main.service;

import java.util.ArrayList;
import java.util.Map;

import com.app.main.model.Search;

public interface SearchService {
    public ArrayList<Map> searchStock(Search search);
}
