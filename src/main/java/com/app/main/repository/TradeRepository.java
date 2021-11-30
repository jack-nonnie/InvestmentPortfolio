package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.main.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>{
 
}
