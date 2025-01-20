package com.example.demo.securing.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDTO{
	  private Long id;
	  private String loginId;
	  private String password;
	  private String fullName;  
	  private String deptName; 
	  
	  private List<RoleDTO> roles;

}
//@Data
//public class UserDTO implements UserDetails{
//	  private Long id;
//	  private String loginId;
//	  private String password;
//	  private String fullName;  
//	  private String deptName; 
//	  
//	  private List<RoleDTO> roles;
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> role = new ArrayList<>();
//		roles.forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName())));
//		return role;
//	}
//
//	@Override
//	public String getUsername() {
//		return loginId;
//	}
//}
