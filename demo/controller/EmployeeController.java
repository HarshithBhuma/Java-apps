package demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import demo.domain.EmployeeEntity;
import demo.models.Employee;
import demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("")
	public ResponseEntity getEmployees() {
		List<Employee> empList = service.getEmployees();
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/{id}")
	public ResponseEntity getEmployee(@PathVariable int id) {
		Employee e = service.getEmployee(id);
		return ResponseEntity.ok(e);
	}

	@PostMapping("")
	public ResponseEntity addEmployee(@RequestBody EmployeeEntity e) {
		service.addEmployee(e);
		return ResponseEntity.ok(null);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateEmployee(@PathVariable int id, @RequestBody EmployeeEntity e) {
		service.updateEmployee(id, e);
		return ResponseEntity.ok(null);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}")
	public ResponseEntity updateEmployeeValue(@PathVariable int id, @RequestBody Map<String, Object> values) {
		service.partialUpdate(id, values);
		return ResponseEntity.ok(null);
	}

}
