package com.almacenes.microservicio.commons.rack.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.almacenes.microservicio.commons.product.models.entity.Product;

@Entity
@Table(name="rack")
public class Rack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRack;
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Product> products;
	
	public Rack() {
		this.products = new ArrayList<>();
	}
	public Long getIdRack() {
		return idRack;
	}
	public void setIdRack(Long idRack) {
		this.idRack = idRack;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void addProducts(Product product) {
		this.products.add(product);
	}
	public void removeProducts(Product product) {
		this.products.remove(product);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Rack)) {
			return false;
		}
		Rack r = (Rack)obj;
		return this.idRack != null && this.idRack.equals(r.getIdRack());
	}
	
}
