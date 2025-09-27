package com.example.ecommerce_final_backEnd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce_final_backEnd.entity.User;
import com.example.ecommerce_final_backEnd.exception.OurRuntimeException;
import com.example.ecommerce_final_backEnd.repository.UserRepository;
import com.example.ecommerce_final_backEnd.requestDto.UserRequestDto;
import com.example.ecommerce_final_backEnd.util.JwtUtil;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public void create(UserRequestDto dto) {
		Optional<User> byUsername =  userRepository.findByUsername(dto.getUsername());
		if (byUsername.isPresent()) {
			throw new OurRuntimeException(null,"user exists...");
		}
		User user = new User();
		user.setId(null);
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		String encode = passwordEncoder.encode(dto.getPassword());
		user.setPassword(encode);
		userRepository.save(user);
		
	}
	
	public String login(UserRequestDto d) {
		Optional<User> user = userRepository.findByUsername(d.getUsername());
		if (!user.isPresent() || !passwordEncoder.matches(d.getPassword(), user.get().getPassword())) {
			throw new OurRuntimeException(null, "username or password incorrect");
		}
		return jwtUtil.generateToken(
				user.get().getUsername(),
				user.get().getName(),
				user.get().getSurname(),
				user.get().getEmail());
	}
}
