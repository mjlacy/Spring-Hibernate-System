<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
    border-right:1px solid #bbb;
}

li:last-child {
    border-right: none;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

body {
    background-image: url("https://images.freecreatives.com/wp-content/uploads/2015/12/Plaid-Texture-Seamless-Pattern.jpg");
  	background-size: 100%;
  	}
    
</style>
</head>
<body>

<ul>
  <li><a href="indexpage.htm">Home</a></li>
 
 <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Employees</a>
    <div class="dropdown-content">
      <a href="employeeForm.htm">Add Employee</a>
      <a href="searchemployeeform.htm">Search Employees</a>
      <a href="employeeDisplay.htm">Display Employees</a>
      <a href="employeeDisplay.htm">Edit Employee</a>
      <a href="employeeDisplay.htm">Delete Employee</a>
    </div>
  </li>
 
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Inventory</a>
    <div class="dropdown-content">
      <a href="inventoryForm.htm">Add Inventory</a>
      <a href="searchinventoryform.htm">Search Inventory</a>
      <a href="inventoryDisplay.htm">Display Inventory</a>
      <a href="inventoryDisplay.htm">Edit Inventory</a>
      <a href="inventoryDisplay.htm">Delete Inventory</a>
    </div>
  </li>
</ul>

<h2>Welcome To The Inventories Page</h2>

<h2 align="center">Inventory Information</h2>
</body><center>
<display:table cellpadding="2" cellspacing="20" id="inventory" name="inventory" pagesize="10"
	export="false" requestURI="displayInventory.htm">
	<display:column property="inv_id" title="Inventory Id No." sortable="false" />
	<display:column property="description" title="Inventory Description"
		href="editInventoryData.htm" paramId="id" paramProperty="inv_id"
		sortable="false" />
	<display:column property="quantityStored" title="Quantity Stored" sortable="false" />
	<display:column property="quantityOrdered" title="Quantity Ordered" sortable="false" />
	<display:column value="Delete" href="deleteInventoryData.htm" paramId="id"
		paramProperty="inv_id" title="Delete" sortable="false" />
	<display:setProperty name="paging.banner.placement" value="bottom" />
	<display:setProperty name="paging.banner.all_items_found" value="Table 1 of " />
</display:table>
</center>
</body>
</html>