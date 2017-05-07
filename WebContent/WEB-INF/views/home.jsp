<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<h2>Welcome To The Home Page</h2>

<br>
<img src="http://www.smallbusinessdoctors.com/wp-content/uploads/2015/09/business-consulting2.jpg" style="width:304px;height:228px;">

</body>
</html>