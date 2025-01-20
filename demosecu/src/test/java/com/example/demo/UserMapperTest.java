package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.securing.mapper.UserMapper;
import com.example.demo.securing.service.RoleDTO;
import com.example.demo.securing.service.UserDTO;

@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void test() {
		UserDTO user = userMapper.getUser("user");
		//List<RoleDTO> role = userMapper.getRole(user.getId());
		
		System.out.println("user : "+user.toString());
		//System.out.println("role : "+role.toString());

	}
}
