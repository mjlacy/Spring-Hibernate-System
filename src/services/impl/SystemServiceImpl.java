package services.impl;

import java.util.List;

import Form.EmployeeForm;
import Form.EmployeeSearchForm;
import Form.InventoryForm;
import Form.InventorySearchForm;
import dao.daoImpl.SystemDaoImpl;
import domain.Employee;
import domain.Inventory;
import services.SystemService;

public class SystemServiceImpl implements SystemService {
	SystemDaoImpl systemDao;

	public void setSystemDao(SystemDaoImpl systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public void addEmployee(EmployeeForm employeeForm) {
		systemDao.addEmployee(employeeForm);
	}

	public List<Employee> findEmployee(EmployeeSearchForm employeeSearchForm) {
		return systemDao.findEmployee(employeeSearchForm);
	}

	@Override
	public List<Employee> displayEmployee(EmployeeForm employeeForm) {
		return systemDao.displayEmployee(employeeForm);
	}

	@Override
	public void editEmployee(EmployeeForm employeeForm) {
		systemDao.editEmployee(employeeForm);
	}

	public EmployeeForm findEmployee(int id) {
		return systemDao.findEmployee(id);
	}

	public void deleteEmployee(int id) {
		systemDao.deleteEmployee(id);
	}
	
	@Override
	public void addInventory(InventoryForm inventoryForm) {
		systemDao.addInventory(inventoryForm);
	}

	public List<Inventory> findInventory(InventorySearchForm inventorySearchForm) {
		return systemDao.findInventory(inventorySearchForm);
	}

	@Override
	public List<Inventory> displayInventory(InventoryForm inventoryForm) {
		return systemDao.displayInventory(inventoryForm);
	}

	@Override
	public void editInventory(InventoryForm inventoryForm) {
		systemDao.editInventory(inventoryForm);
	}

	public InventoryForm findInventory(int id) {
		return systemDao.findInventory(id);
	}

	public void deleteInventory(int id) {
		systemDao.deleteInventory(id);
	}
}
