package demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import demo.app.ResourceNotFoundException;
import demo.domain.EmployeeEntity;
import demo.models.Employee;
import demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo repo;

	EmployeeEntity ee = null;

	public List<Employee> getEmployees() {
		List<EmployeeEntity> entityEmp = repo.findAll();

		List<Employee> employeeList = new ArrayList<Employee>();

		for (EmployeeEntity entity : entityEmp) {
			Employee emp = new Employee();
			emp.setEmp_id(entity.getEmp_id());
			emp.setEmp_name(entity.getEmp_name());
			emp.setEmp_age(entity.getEmp_age());
			emp.setSalary(entity.getSalary());

			employeeList.add(emp);
		}
		return employeeList;
	}

	public void addEmployee(EmployeeEntity e) {
		repo.save(e);
	}

	public void updateEmployee(int id, EmployeeEntity e) {
		ee = repo.findById(id).get().builder().emp_id(id).emp_name(e.getEmp_name()).emp_age(e.getEmp_age())
				.salary(e.getSalary()).build();
		repo.save(ee);

	}

	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}

	public void partialUpdate(int id, Map<String, Object> values) {
		ee = repo.findById(id).get();
		if (values.containsKey("emp_name"))
			ee.setEmp_name((String) values.get("emp_name"));
		if (values.containsKey("emp_age"))
			ee.setEmp_age((Integer) values.get("emp_age"));
		if (values.containsKey("salary"))
			ee.setSalary((Integer) values.get("salary"));
		repo.save(ee);
	}

	@Cacheable(value = "Employees", key = "#empid")
	public Employee getEmployee(int empid) {
		EmployeeEntity e = repo.findById(empid).orElseThrow(() -> new ResourceNotFoundException("no record found"));
		return Employee.builder().emp_id(e.getEmp_id()).emp_name(e.getEmp_name()).emp_age(e.getEmp_age())
				.salary(e.getSalary()).build();
	}
}
