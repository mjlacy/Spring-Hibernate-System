package Form;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class InventoryForm {
	private int id;

	@NotEmpty(message = "Please Specify Description")
	private String description;

	@NotNull
	private Integer quantityStored;

	@NotNull
	private Integer quantityOrdered;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantityStored() {
		return quantityStored;
	}

	public void setQuantityStored(Integer quantityStored) {
		this.quantityStored = quantityStored;
	}
	
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
}