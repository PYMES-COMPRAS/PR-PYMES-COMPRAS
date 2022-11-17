package com.almacenes.microservicio.app.warehouse.models.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.almacenes.microservicio.commons.section.models.entity.Section;


@Entity
@Table(name="warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idWarehouse;
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Section> sections;

	public Long getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(Long idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public void addSection(Section section) {
		this.sections.add(section);
	}
	public void removeRack(Section section) {
		this.sections.remove(section);
	}
	
	
}
