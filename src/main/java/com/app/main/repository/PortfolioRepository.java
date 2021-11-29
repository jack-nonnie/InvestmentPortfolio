package com.app.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.main.model.Stock;

@Repository
public interface PortfolioRepository extends JpaRepository<Stock, String> {

}
