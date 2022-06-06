package com.springbootinterview.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Stock.
 * Stock Domain Object
 */
@Entity
@Table(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stock {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The name. */
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	/** The current price. */
	@Column(name = "current_price", nullable = false)
	private Double currentPrice = 0.0;
	
	/** The last updated date. */
	@Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonIgnore
	@JsonProperty(access = Access.READ_ONLY)
	private ZonedDateTime lastUpdatedDate = ZonedDateTime.now();
	
	
	
}
