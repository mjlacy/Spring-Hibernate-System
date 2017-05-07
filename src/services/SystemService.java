package services;

import java.util.List;

import Form.EmployeeForm;
import Form.EmployeeSearchForm;
import Form.InventoryForm;
import Form.InventorySearchForm;
import domain.Employee;
import domain.Inventory;

public interface SystemService{
	public void addEmployee(EmployeeForm employeeForm);
	public List<Employee> displayEmployee(EmployeeForm employeeForm);
	public List<Employee> findEmployee(EmployeeSearchForm employeeSearchForm);
	public void editEmployee(EmployeeForm employeeForm);
	public EmployeeForm findEmployee(int id);
	public void deleteEmployee(int id);
	public void addInventory(InventoryForm inventoryForm);
	public List<Inventory> displayInventory(InventoryForm inventoryForm);
	public List<Inventory> findInventory(InventorySearchForm inventorySearchForm);
	public void editInventory(InventoryForm inventoryForm);
	public InventoryForm findInventory(int id);
	public void deleteInventory(int id);
}