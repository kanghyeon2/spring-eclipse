package com.example.demo.insa.service;

import java.util.List;

public interface EmployeesService {
	public List<EmployeesDTO> getList();
	
	public void register(EmployeesDTO employees);
}
