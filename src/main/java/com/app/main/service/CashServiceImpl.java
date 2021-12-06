package com.app.main.service;

import java.util.List;

import com.app.main.model.Cash;
import com.app.main.repository.CashRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashServiceImpl implements CashService{
    @Autowired
    private CashRepository cashRepository;

    @Override
    public double getBalance(){
        List<Cash> transactions = cashRepository.findAll();
        double sum = 0;
        for(int i = 0; i < transactions.size(); i ++){
            sum += transactions.get(i).getAmount();
        }
        return sum;
    }
    @Override
    public void enterTransaction(Cash cash){
        this.cashRepository.save(cash);
    }

}
