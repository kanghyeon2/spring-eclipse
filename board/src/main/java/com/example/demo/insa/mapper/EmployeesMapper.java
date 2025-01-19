package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.JobsDTO;

public interface EmployeesMapper {
	//전체 조회
	List<EmployeesDTO> getList();
	
	//등록
	int insert(EmployeesDTO employeesDTO);
	
	// jobs 조회
	public List<JobsDTO> getJobList();
	
	//삭제
	public int delete(Long employeeId);
}
