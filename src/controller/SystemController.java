package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import Form.EmployeeForm;
import Form.EmployeeSearchForm;
import Form.InventoryForm;
import Form.InventorySearchForm;
import services.SystemService;

@Controller
public class SystemController {

	@Autowired
	SystemService service;

	/* Loading Home Page */
	@RequestMapping("/indexpage.htm")
	public String loadIndexPage() {
		return "home";
	}

	/* Loading Employee Page */
	@RequestMapping("/employeeForm.htm")
	public String loadEmployeeForm(Map<String, EmployeeForm> model, EmployeeForm employeeForm) {
		model.put("employeeForm", employeeForm);
		return "employeePage";
	}

	/* Add new Employee */
	@RequestMapping("/displayemployee.htm")
	public String saveEmployee(Map<?, ?> model, @Valid EmployeeForm employeeForm,
			BindingResult result) {
		/*if (result.hasErrors()) {
			return "employeePage";
		} else {*/
			if (employeeForm.getId() >= 0) {
				service.editEmployee(employeeForm);
			} else {
				service.addEmployee(employeeForm);
			}
			return "redirect:/employeeDisplay.htm";
		}
	//}

	/* Display employee record */
	@RequestMapping("/employeeDisplay.htm")
	public String displayForm(Map<String, List<?>> model, EmployeeForm employeeForm) {
		model.put("employee", service.displayEmployee(employeeForm));

		return "employeeDisplayForm";
	}

	/* Load Employee Search Form */
	@RequestMapping("/searchemployeeform.htm")
	public String loadSearchForm(Map<String, EmployeeSearchForm> model, EmployeeSearchForm employeeSearchForm) {
		model.put("search", employeeSearchForm);
		return "employeeSearchForm";
	}

	/* Display searched employee details */
	@RequestMapping("/searchemployee.htm")
	public String findEmployee(Map<String, List<?>> model, EmployeeSearchForm employeeSearchForm) {
		model.put("employee", service.findEmployee(employeeSearchForm));
		return "employeeDisplayForm";
	}

	/* Edit record of employee */
	@RequestMapping("/editEmployeeData.htm")
	public String searchForEdit(Map<String, EmployeeForm> model, EmployeeForm employeeForm,
			HttpServletRequest request) {
		model.put("employeeForm", service.findEmployee(new Integer(request
				.getParameter("id"))));
		return "employeePage";
	}

	/* Delete Employee Record */
	@RequestMapping("/deleteEmployeeData.htm")
	public String deleteEmployee(Map<?, ?> model, HttpServletRequest request) {
		service.deleteEmployee(new Integer(request.getParameter("id")));
		return "redirect:/employeeDisplay.htm";
	} 
	
	/* Loading Inventory Page */
	@RequestMapping("/inventoryForm.htm")
	public String loadInventoryForm(Map<String, InventoryForm> model, InventoryForm inventoryForm) {
		model.put("inventoryForm", inventoryForm);
		return "inventoryPage";
	}

	/* Add new Inventory */
	@RequestMapping("/displayinventory.htm")
	public String saveInventory(Map<?, ?> model, @Valid InventoryForm inventoryForm,
			BindingResult result) {
		/*if (result.hasErrors()) {
			return "inventoryPage";
		} else {*/
			if (inventoryForm.getId() >= 0) {
				service.editInventory(inventoryForm);
			} else {
				service.addInventory(inventoryForm);
			}
			return "redirect:/inventoryDisplay.htm";
		}
	//}

	/* Display inventory record */
	@RequestMapping("/inventoryDisplay.htm")
	public String displayForm(Map<String, List<?>> model, InventoryForm inventoryForm) {
		model.put("inventory", service.displayInventory(inventoryForm));

		return "inventoryDisplayForm";
	}

	/* Load Inventory Search Form */
	@RequestMapping("/searchinventoryform.htm")
	public String loadSearchForm(Map<String, InventorySearchForm> model, InventorySearchForm inventorySearchForm) {
		model.put("search", inventorySearchForm);
		return "inventorySearchForm";
	}

	/* Display searched inventory details */
	@RequestMapping("/searchinventory.htm")
	public String findInventory(Map<String, List<?>> model, InventorySearchForm inventorySearchForm) {
		model.put("inventory", service.findInventory(inventorySearchForm));
		return "inventoryDisplayForm";
	}

	/* Edit record of inventory */
	@RequestMapping("/editInventoryData.htm")
	public String searchForEdit(Map<String, InventoryForm> model, InventoryForm inventoryForm,
			HttpServletRequest request) {
		model.put("inventoryForm", service.findInventory(new Integer(request
				.getParameter("id"))));
		return "inventoryPage";
	}

	/* Delete Inventory Record */
	@RequestMapping("/deleteInventoryData.htm")
	public String deleteInventory(Map<?, ?> model, HttpServletRequest request) {
		service.deleteInventory(new Integer(request.getParameter("id")));
		return "redirect:/inventoryDisplay.htm";
	}
}