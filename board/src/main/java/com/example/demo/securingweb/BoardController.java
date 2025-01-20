package com.example.demo.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	HttpServletRequest session;
	
	@GetMapping("/home")
	public void home( ) {

		log.info("session: " + session.getAttribute("deptName"));
		log.info("userDetail: " + SecuUtil.getUser().getDeptName());
	}
	
}
