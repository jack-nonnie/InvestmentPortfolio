package com.app.main.service;

import com.app.main.model.Cash;

public interface CashService {
    public double getBalance();
    public void enterTransaction(Cash cash);
}
