package Form;

public class InventorySearchForm {
	private String id;
	private String description;
	private String quantityStored;
	private String quantityOrdered;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getQuantityStored() {
		return quantityStored;
	}

	public void setQuantityStored(String quantityStored) {
		this.quantityStored = quantityStored;
	}

	public String getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(String quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

}