package com.example.demo.securing.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.securing.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service //@bean 필요x (websecurityconfig)
@RequiredArgsConstructor
public class CumtomUserDatailsService implements UserDetailsService{
	
	private final UserMapper userMapper;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//단건조회
		UserDTO userDTO = userMapper.getUser(username);
		if(userDTO == null) {
			throw new UsernameNotFoundException("id check plz");
		}	
//		List<GrantedAuthority> role = new ArrayList<>();
//		userDTO.getRoles().forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName())));		
//		return new User(userDTO.getLoginId(), userDTO.getPassword(), role);
		return new CustomerUser(userDTO);
	}

}
