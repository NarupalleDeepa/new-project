package com.abc.onlinevegetablestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vegetables")
public class Vegetable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long vegId;
	
	@Column(name = "Vegetable_name")
	private String vegName;
	
	@Column(name = "Vegetable_cost")
	private double vegCost;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Discount")
	private long discount;
	
	@Column(name = "Discount_type")
	private String discountType;
	
	
	
	


	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Vegetable(long vegId, String vegName, double vegCost, int quantity, long discount, String discountType) {
		super();
		this.vegId = vegId;
		this.vegName = vegName;
		this.vegCost = vegCost;
		this.quantity = quantity;
		this.discount = discount;
		this.discountType = discountType;
	}



	public long getVegId() {
		return vegId;
	}


	public void setVegId(long vegId) {
		this.vegId = vegId;
	}


	public String getVegName() {
		return vegName;
	}


	public void setVegName(String vegName) {
		this.vegName = vegName;
	}


	public double getVegCost() {
		return vegCost;
	}


	public void setVegCost(double vegCost) {
		this.vegCost = vegCost;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public long getDiscount() {
		return discount;
	}



	public void setDiscount(long discount) {
		this.discount = discount;
	}



	public String getDiscountType() {
		return discountType;
	}



	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	
	


}
