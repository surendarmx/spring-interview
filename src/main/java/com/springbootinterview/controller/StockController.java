package com.springbootinterview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootinterview.entity.Stock;
import com.springbootinterview.service.StockService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class StockController.
 * All operations with a stock will be routed by this controller.
 */
@RestController

/** The Constant log. */
@Slf4j
@RequestMapping("/api/stocks")
public class StockController {

	/** The stock service. */
	@Autowired
	private StockService stockService;


	/**
	 * Gets the stock.
	 *
	 * @param stockId the stock id
	 * @return the stock
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@GetMapping("/{stockId}")
	public ResponseEntity<Object> getStock(@PathVariable Long stockId) {
		log.info("StockController:getStock - parameters:stockId {} ", stockId);
		
		Stock result = stockService.getStockByStockId(stockId);
		
		log.info("StockController:getStock - finished execution");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
