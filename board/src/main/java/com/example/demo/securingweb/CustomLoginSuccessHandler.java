package com.example.demo.securingweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.securing.service.CustomerUser;
import com.example.demo.securing.service.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										HttpServletResponse response,
										Authentication auth) throws IOException, ServletException {
		//단건조회 auth에서 꺼내쓰기
		UserDTO dto = ((CustomerUser)auth.getPrincipal()).getUserDTO();
		
		//session
		request.getSession().setAttribute("userId", dto.getId());
		request.getSession().setAttribute("deptName", dto.getDeptName());
		
		//username, role
		List<String> roleNames = new ArrayList<String>();
		
		auth.getAuthorities().forEach(authority->{
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println("roleNames => "+roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/emp/list");
			return;
		}else if(roleNames.contains("ROLE_USER")){
			response.sendRedirect("/board/list");
			return;
		}else {
			response.sendRedirect("/");
		}
	}

}
