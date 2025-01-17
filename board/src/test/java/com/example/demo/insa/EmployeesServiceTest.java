package com.example.demo.insa;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeesServiceTest {
	
	  @Autowired EmployeesService employeesService;
	  
	  //@Test
	  @DisplayName("사원 전체조회") 
	  void getList() { 
	  List<EmployeesDTO> list = employeesService.getList(); 
	  log.debug(list.toString()); }
	 
}
