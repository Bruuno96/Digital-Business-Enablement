package br.com.fiap.model;

import java.math.BigDecimal;    
import javax.persistence.*;

@Entity
@SequenceGenerator(name="setup", sequenceName = "SQ_TB_SETUP", allocationSize = 1)
public class Setup {

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setup")
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Setup [name=" + name + ", description=" + description + ", price=" + price + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}