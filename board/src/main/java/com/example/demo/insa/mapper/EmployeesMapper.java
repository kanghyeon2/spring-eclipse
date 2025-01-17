package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmployeesDTO;

public interface EmployeesMapper {
	//전체 조회
	List<EmployeesDTO> getList();
	
	//등록
	int insert(EmployeesDTO employeesDTO);
}
