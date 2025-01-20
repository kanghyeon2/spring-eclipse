package com.example.demo.securing.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerUser implements UserDetails{

	
	UserDTO userDTO;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userDTO.getRoles()
					  .stream()
					  .map(r->new SimpleGrantedAuthority(r.getRoleName()))
					  .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userDTO.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() { //enable 컬럼 만들어서 특정 계정에 넣어주면 => 로그인 못함
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userDTO.getLoginId();
	}

}
