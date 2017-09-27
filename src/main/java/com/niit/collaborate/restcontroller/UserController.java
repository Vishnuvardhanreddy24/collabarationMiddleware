package com.niit.collaborate.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
private UserService userService;
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user){
		if(!userService.isUsernameValid(user.getUsername()))
		{
			Error error=new Error("username already exists,, please enter different username");
	 		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	    }
		if(!userService.isEmailValid(user.getEmail()))
		{
			Error error=new Error("Email address already exists,, please enter different email");
	 		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
			
			boolean result=userService.registerUser((com.collaborate.Model.User) user);
		if(result)
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else{
			Error error=new Error("unable to register user details");
			return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}