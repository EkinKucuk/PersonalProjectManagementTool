package com.example.PPMT.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PPMT.domain.User;
import com.example.PPMT.services.MapValidationError;
import com.example.PPMT.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private MapValidationError mapValidationError;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationError.mapValidationService(result);
        if(errorMap != null)return errorMap;

        User newUser = userService.saveUser(user);

        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
		
	}
	
	
	

