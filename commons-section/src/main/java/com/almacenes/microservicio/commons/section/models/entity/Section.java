package com.almacenes.microservicio.commons.section.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.almacenes.microservicio.commons.rack.models.entity.Rack;

@Entity
@Table(name="section")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSection;
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Rack> racks;
	
	public Section() {
		this.racks = new ArrayList<>();
	}

	public Long getIdSection() {
		return idSection;
	}

	public void setIdSection(Long idSection) {
		this.idSection = idSection;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Rack> getRacks() {
		return racks;
	}

	public void setRacks(List<Rack> racks) {
		this.racks = racks;
	}
	
	public void addRacks(Rack rack) {
		this.racks.add(rack);
	}
	public void removeRack(Rack rack) {
		this.racks.remove(rack);
	}
	
	
}
