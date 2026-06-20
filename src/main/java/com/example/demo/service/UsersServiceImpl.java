package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.dto.UsersRegistrationDto;
import com.example.demo.entity.Users;
import com.example.demo.exception.UsersServiceException;
import com.example.demo.interfaces.UsersServiceInt;
import com.example.demo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersServiceInt {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public void userRegisteration(UsersRegistrationDto usersRegistrationDto) {

		checksEmptyFields(usersRegistrationDto);

		Users users = new Users();
		users.setUsername(usersRegistrationDto.getUsername());
		users.setEmail(usersRegistrationDto.getEmail());
		users.setMobileNo(usersRegistrationDto.getMobileNo());
		users.setPassword(passwordEncoder.encode(usersRegistrationDto.getPassword()));
		users.setDate(LocalDate.now());
		users.setRole("ROLE_USER");
		usersRepository.save(users);
	}

	private void checksEmptyFields(UsersRegistrationDto usersRegistrationDto) {
		if (usersRegistrationDto.getUsername() == null || usersRegistrationDto.getEmail() == null
				|| usersRegistrationDto.getMobileNo() <= 10 || usersRegistrationDto.getPassword() == null) {
			throw new UsersServiceException("Empty Fields", HttpStatus.BAD_GATEWAY);
		}
	}

	

}
