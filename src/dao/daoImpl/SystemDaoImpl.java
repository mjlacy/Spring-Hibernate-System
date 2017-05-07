package dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Form.EmployeeForm;
import Form.EmployeeSearchForm;
import Form.InventoryForm;
import Form.InventorySearchForm;
import dao.SystemDao;
import domain.Employee;
import domain.Inventory;

public class SystemDaoImpl implements SystemDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(EmployeeForm employeeForm) {
		Employee employee = new Employee();
		employee.setName(employeeForm.getName());
		employee.setAddress(employeeForm.getAddress());
		if(employeeForm.getSalary() instanceof Integer)
			employee.setSalary(employeeForm.getSalary());
		else
			employee.setSalary(-1);
		sessionFactory.openSession().saveOrUpdate(employee);
	}

	public List<Employee> displayEmployee(EmployeeForm employeeForm) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = new ArrayList<Employee>();
		employees = criteria.list();
		
		return employees;
	}

	public List<Employee> findEmployee(EmployeeSearchForm employeeSearchForm) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "SELECT emp FROM Employee emp";
		String where = "";

		if (employeeSearchForm.getName() != "") {
			where = " where emp.name like '%" + employeeSearchForm.getName() + "%'";
		}
		
		if (employeeSearchForm.getAddress() != "") {
			where = " where emp.address like '%" + employeeSearchForm.getAddress() + "%'";
		}

		if (employeeSearchForm.getSalary() != "") {
			try{
				int x = Integer.parseInt(employeeSearchForm.getSalary());
				if (where == "") {
					where = " where emp.salary=" + x;
				} else {
					where = where + " and emp.salary=" + x;
				}
			}
			catch(NumberFormatException ex){
				if (where == "") {
					where = " where emp.salary=" + -1;
				} else {
					where = where + " and emp.salary=" + -1;
				}
			}
		}

		if (employeeSearchForm.getId() != "") {
			try{
				int x = Integer.parseInt(employeeSearchForm.getId());
				if (where == "") {
					where = " where emp.emp_id=" + x;
				} else {
					where = where + " and emp.emp_id=" + x;
				}
			}
			catch(NumberFormatException ex){
				if (where == "") {
					where = " where emp.emp_id=" + -1;
				} else {
					where = where + " and emp.emp_id=" + -1;
				}
			}
		}

		Query query = session.createQuery(sql + where);
		tx.commit();
		return query.list();
	}

	public void editEmployee(EmployeeForm employeeForm) {
		Employee employee = new Employee();

		employee.setEmp_id(employeeForm.getId());
		employee.setName(employeeForm.getName());
		employee.setAddress(employeeForm.getAddress());
		employee.setSalary(employeeForm.getSalary());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(employee);
		tx.commit();
		session.close();
		
	}

	public EmployeeForm findEmployee(int id) {
		Session session = sessionFactory.openSession();
		String sql = "select emp from Employee emp where emp.emp_id=" + id;
		Query query = session.createQuery(sql);
		Employee employee = (Employee) query.list().get(0);
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setId(employee.getEmp_id());
		employeeForm.setName(employee.getName());
		employeeForm.setAddress(employee.getAddress());
		employeeForm.setSalary(employee.getSalary());
		return employeeForm;
	}

	public Employee loadEmployee(int id) {
		Session session = sessionFactory.openSession();
		String sql = "select emp from Employee emp where emp.emp_id=" + id;
		Query query = session.createQuery(sql);
		Employee employee = (Employee) query.list().get(0);
		return employee;
	}

	public void deleteEmployee(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = loadEmployee(id);
		Transaction tx = session.beginTransaction();
		session.delete(employee);
		tx.commit();
		session.close();
	}
	
	@Override
	public void addInventory(InventoryForm inventoryForm) {
		Inventory inventory = new Inventory();
		inventory.setDescription(inventoryForm.getDescription());
		if(inventoryForm.getQuantityStored() instanceof Integer)
			inventory.setQuantityStored(inventoryForm.getQuantityStored());
		else
			inventory.setQuantityStored(-1);
		if(inventoryForm.getQuantityOrdered() instanceof Integer)
			inventory.setQuantityOrdered(inventoryForm.getQuantityOrdered());
		else
			inventory.setQuantityOrdered(-1);
		sessionFactory.openSession().saveOrUpdate(inventory);
	}

	public List<Inventory> displayInventory(InventoryForm inventoryForm) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Inventory.class);
		List<Inventory> inventories = new ArrayList<Inventory>();
		inventories = criteria.list();
		
		return inventories;
	}

	public List<Inventory> findInventory(InventorySearchForm inventorySearchForm) {
		System.out.println("In Dao's findInventory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "SELECT inv FROM Inventory inv";
		String where = "";

		if (inventorySearchForm.getDescription() != "") {
			where = " where inv.description like '%" + inventorySearchForm.getDescription() + "%'";
		}

		if (inventorySearchForm.getQuantityOrdered() != "") {
			try{
				int x = Integer.parseInt(inventorySearchForm.getQuantityOrdered());
				if (where == "") {
					where = " where inv.quantityOrdered=" + x;
				} else {
					where = where + " and inv.quantityOrdered=" + x;
				}
			}
			catch(NumberFormatException ex){
				if (where == "") {
					where = " where inv.quantityOrdered=" + -1;
				} else {
					where = where + " and inv.quantityOrdered=" + -1;
				}
			}
		}
		
		if (inventorySearchForm.getQuantityStored() != "") {
			try{
				int x = Integer.parseInt(inventorySearchForm.getQuantityStored());
				if (where == "") {
					where = " where inv.quantityStored=" + x;
				} else {
					where = where + " and inv.quantityStored=" + x;
				}
			}
			catch(NumberFormatException ex){
				if (where == "") {
					where = " where inv.quantityStored=" + -1;
				} else {
					where = where + " and inv.quantityStored=" + -1;
				}
			}
		}

		if (inventorySearchForm.getId() != "") {
			try{
				int x = Integer.parseInt(inventorySearchForm.getId());
				if (where == "") {
					where = " where inv.inv_id=" + x;
				} else {
					where = where + " and inv.inv_id=" + x;
				}
			}
			catch(NumberFormatException ex){
				if (where == "") {
					where = " where inv.inv_id=" + -1;
				} else {
					where = where + " and inv.inv_id=" + -1;
				}
			}
		}

		System.out.println("Final Query= " + sql + where);
		Query query = session.createQuery(sql + where);
		System.out.println("Before Commit");
		tx.commit();
		System.out.println("After Commit");
		return query.list();
	}

	public void editInventory(InventoryForm inventoryForm) {
		Inventory inventory = new Inventory();

		inventory.setInv_id(inventoryForm.getId());
		inventory.setDescription(inventoryForm.getDescription());
		inventory.setQuantityStored(inventoryForm.getQuantityStored());
		inventory.setQuantityOrdered(inventoryForm.getQuantityOrdered());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(inventory);
		tx.commit();
		session.close();
		
	}

	public InventoryForm findInventory(int id) {
		Session session = sessionFactory.openSession();
		String sql = "select inv from Inventory inv where inv.inv_id=" + id;
		Query query = session.createQuery(sql);
		Inventory inventory = (Inventory) query.list().get(0);
		InventoryForm inventoryForm = new InventoryForm();
		inventoryForm.setId(inventory.getInv_id());
		inventoryForm.setDescription(inventory.getDescription());
		inventoryForm.setQuantityStored(inventory.getQuantityStored());
		inventoryForm.setQuantityOrdered(inventory.getQuantityOrdered());
		return inventoryForm;
	}

	public Inventory loadInventory(int id) {
		Session session = sessionFactory.openSession();
		String sql = "select inv from Inventory inv where inv.inv_id=" + id;
		Query query = session.createQuery(sql);
		Inventory inventory = (Inventory) query.list().get(0);
		return inventory;
	}

	public void deleteInventory(int id) {
		Session session = sessionFactory.openSession();
		Inventory inventory = loadInventory(id);
		Transaction tx = session.beginTransaction();
		session.delete(inventory);
		tx.commit();
		session.close();
	}
}