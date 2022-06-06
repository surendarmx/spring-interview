package com.springbootinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootinterview.entity.Stock;


/**
 * The Interface StockRepository.
 * Database Access Object for stock table.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}
