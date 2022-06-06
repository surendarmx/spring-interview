package com.springbootinterview.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootinterview.entity.Stock;
import com.springbootinterview.repository.StockRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class StockServiceImpl.
 * Service to encapsulate the link between DAO and controller and to have business logic for some stock specific things.
 * <p/>
 */
@Service
@Slf4j
public class StockService {

	/** The stock repository. */
	@Autowired
	private StockRepository stockRepository;


	/**
	 * Get the stock by stock id.
	 *
	 * @param stockId the stock id
	 * @return the stock by stock id
	 * @throws EntityNotFoundException the entity not found exception
	 */
	public Stock getStockByStockId(Long stockId) {
		log.info("StockServiceImpl:getStockByStockId - parameters:stockId {} ", stockId);
		
		//invoked a helper method to find stock details by the stock id
		Stock stock = findStock(stockId);
		
		log.info("StockServiceImpl:getStockByStockId - finished execution");
		return stock;
	}
	
	/**
	 * Find the stock by stock id.
	 * Helper method
	 *
	 * @param stockId the stock id
	 * @return the stock
	 * @throws EntityNotFoundException the entity not found exception
	 */
	private Stock findStock(Long stockId) throws EntityNotFoundException {
		log.info("StockServiceImpl:findStock - parameters:stockId {} ", stockId);
		return stockRepository.findById(stockId)
				.orElseThrow(() -> new EntityNotFoundException("Not found"));
	}

}
