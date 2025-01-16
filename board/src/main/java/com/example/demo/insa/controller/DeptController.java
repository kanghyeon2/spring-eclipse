package com.example.demo.insa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController //제이슨형태로 << resposnebody쓸필요 x
@RequiredArgsConstructor
@RequestMapping("/dept/")
public class DeptController {
	
	private final DeptService deptService;
	
	//전체조회
	@GetMapping("list")
	public List<DeptDTO> list() {
		return deptService.getList(null);
	}
	//단건조회
	@GetMapping("get")
	public DeptDTO get(@RequestParam(name="deptId") long deptId){
		return deptService.get(deptId);
		}
}
