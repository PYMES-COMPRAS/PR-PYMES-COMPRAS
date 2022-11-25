package com.almacenes.microservicio.commons.product.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="product")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productID;
	
	private String name;
	private int quantity;
	private String description;
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;
	private Date expireDate;
	private String brand;
	private double price;
	private String barcode;
	private double discount;
	private Long supplier;
	private double iva;
	private String category;
	private double batch;
	
	
	@PrePersist
	public void prePersist() {
		this.entryDate = new Date();
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Product)) {
			return false;
		}
		Product p = (Product)obj;
		return this.productID != null && this.productID.equals(p.getProductID());
	}
	public Long getSupplier() {
		return supplier;
	}
	public void setSupplier(Long supplier) {
		this.supplier = supplier;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getBatch() {
		return batch;
	}
	public void setBatch(double batch) {
		this.batch = batch;
	}
	
	
	
	
	
	
	
}
