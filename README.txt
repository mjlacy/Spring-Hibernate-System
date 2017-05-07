This systems allows a user to read/edit data from employee and inventory database tables from various web pages.

Installation Requirements:
MYSQL installed on port 3306 with the username 'root' and password 'password'. This must containing a schema named 
'spring_hibernate' with contains a table named 'employee' with the fields: 'emp_id' of type 'int(11)' as the 
auto incrementing primary key, 'name' of type 'varchar(45)', 'address' of type 'varchar(45)', and 'salary' of type 
'int(11)', and a table named 'inventory' with the fields: 'inv_id' of type 'int(11)' as the auto incrementing primary key,
'description' of type 'varchar(45)', 'quantityStored' of type 'int(11)', and 'quantityOrdered' of type 'int(11)'.

Recommended IDE:
Eclipse or Spring Tool Suite with the Apache Tomcat server installed on whichever one is chosen.

Notes:
If when adding a something to the system a non-integer is put in an integer-only 
column(Employee.Salary, Inventory.QuantityOrdered, Inventory.QuantityStored), that value will be ignored and a null
will be inserted into the database in its place, which will appear as a blank on the display page.

If when searching the system a non-integer is put in an integer-only 
column(Employee.Salary, Inventory.QuantityOrdered, Inventory.QuantityStored), that value will not be found and will
cause the system to display no columns, even if the other columns did match other search criteria.