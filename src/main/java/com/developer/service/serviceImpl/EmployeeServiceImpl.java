package com.developer.service.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.developer.dto.responseDto.EmployeeResponse;
import com.developer.exception.EmployeeNotFoundException;
import com.developer.model.Employee;
import com.developer.repository.EmployeeRepository;
import com.developer.service.Iservice.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	final static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee saveEmployee = employeeRepository.save(employee);
		return saveEmployee;
	}

	@Override
	public EmployeeResponse findEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).map(t -> new EmployeeResponse(t.getId(), t.getName()))
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with this id" + employeeId));
	}

	@Override
	public List<EmployeeResponse> getAllEmployee() {
		return employeeRepository.findAll().stream().map(emp -> new EmployeeResponse(emp.getId(), emp.getName()))
				.toList();
	}

}
