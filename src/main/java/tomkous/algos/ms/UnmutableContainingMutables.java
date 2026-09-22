package tomkous.algos.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UnmutableContainingMutables {

	    // 2. Make all fields 'private' and 'final'
	    private final String companyName;
	    private final List<Employee> employees;

	    // 3. The constructor must make defensive copies of mutable arguments
	    public UnmutableContainingMutables(String companyName, List<Employee> employees) {
	        this.companyName = companyName;

	        // Create a deep copy of the list and its mutable objects
	        List<Employee> tempLines = new ArrayList<>();
	        if (employees != null) {
	            for (Employee emp : employees) {
	                // Deep copy each individual mutable object
	                tempLines.add(new Employee(emp.getName(), emp.getSalary(), emp.getPosition(), emp.getPhone()));
	            }
	        }
	        
	        // Wrap the copy in an unmodifiable list wrapper
	        this.employees = Collections.unmodifiableList(tempLines);
	    }

	    // 4. Expose read-only fields directly (Strings are already immutable)
	    public String getCompanyName() {
	        return companyName;
	    }

	    // 5. Getter must return either a defensive copy or an unmodifiable wrapper
	    public List<Employee> getEmployees() {
	        // Return defensive copy of the list with deep-copied mutable items
	        List<Employee> copyList = new ArrayList<>();
	        for (Employee emp : this.employees) {
	            copyList.add(new Employee(emp.getName(), emp.getSalary(), emp.getPosition(), emp.getPhone()));
	        }
	        //return copyList;
	        
	        // Or adding a wrapper to created defensive copy
	        return Collections.unmodifiableList(copyList);
	    }
	}

	// --- Mutable Helper Class Used Above ---
	class Employee {
	    private String name;
	    private double salary;
	    private String position;
	    private String phone;

	    public Employee(String name, double salary, String position, String phone) {
	        this.name = name;
	        this.salary = salary;
	        this.position = position;
	        this.phone = phone;
	    }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }
	    
	    public double getSalary() { return salary; }
	    public void setSalary(double salary) { this.salary = salary; }

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
	}