package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	private int inv_id;
	private String description;
	private Integer quantityStored;
	private Integer quantityOrdered;

	@Id
	@GeneratedValue
	@Column(name = "inv_id")
	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int invId) {
		inv_id = invId;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "quantityStored")
	public Integer getQuantityStored() {
		return quantityStored;
	}

	public void setQuantityStored(Integer quantityStored) {
		this.quantityStored = quantityStored;
	}

	@Column(name = "quantityOrdered")
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

}