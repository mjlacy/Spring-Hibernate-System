package Form;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeForm {
	private int id;

	@NotEmpty(message = "Please Specify Name")
	private String name;

	@NotEmpty(message = "Please Specify Address")
	private String address;

	@NotNull
	private Integer salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}