package de.gwzberlin.zas.survey.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alternative {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String color;	
	private String material;
	private Integer colorValue;
	private Integer materialValue;
	private boolean selected;
		
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Integer getColorValue() {
		return colorValue;
	}
	public void setColorValue(Integer colorValue) {
		this.colorValue = colorValue;
	}
	public Integer getMaterialValue() {
		return materialValue;
	}
	public void setMaterialValue(Integer materialValue) {
		this.materialValue = materialValue;
	}
}
