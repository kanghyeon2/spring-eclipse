package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.DeptMapper;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService{

	private final DeptMapper deptMapper;
	//전체조회
	@Override
	public List<DeptDTO> getList(DeptSearchDTO searchDTO) {
		return deptMapper.getList(searchDTO);//매퍼
	}
	//단건조회
	@Override
	public DeptDTO get(Long departmentID) {
		return deptMapper.read(departmentID);
	}

		
}
