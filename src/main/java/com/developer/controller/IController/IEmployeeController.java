package com.developer.controller.IController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.developer.dto.responseDto.EmployeeResponse;
import com.developer.model.Employee;

public interface IEmployeeController {

	@PostMapping(path = "/save")
	ResponseEntity<?> saveEmployee(@RequestBody @Validated Employee employee);

	@GetMapping(path = "/get/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable("id") Long empId);

	@GetMapping(path = "/getAllEmployee-Without-Mobile")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee();
}
