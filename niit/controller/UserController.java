package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@RestController
public class UserController {
@Autowired
private UserDAO userDAO;

@Autowired
private User user;

public ResponseEntity<List<User>> getAllUsers()
		{
List<User> userList=userDAO.getAllUsers();
if(userList.isEmpty()){
user.setErrorCode("404");
user.setErrorMessage("Users are not available");
userList.add(user);

}
return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
}
		
		
		
		
public ResponseEntity<User> getUser(@PathVariable(value="userId") String userId)
{
	user=userDAO.get(userId);
	
	if(user==null)
	{
		user=new User();
		user.setErrorCode("404");
		user.setErrorMessage("User doesnot exists with this id:" + userId);
	}
	
	return new ResponseEntity<User>(user,HttpStatus.OK);
}

public ResponseEntity<User> validation(@RequestBody User user)
{
	user=userDAO.validate(user.getUserId(), user.getPassword());
	if(user==null)
	{
		user=new User();//to avoid null pointer exception
		user.setErrorCode("404");
		user.setErrorMessage("invalid Credentials Please Try Again..........");
		
	}
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
}
	

public ResponseEntity<User> acceptRegister(@PathVariable(value="userId") String userId)
{
	user=userDAO.get(userId);
	user.setStatus('A');
	
	if(userDAO.update(user)==true)
	{
		
		user.setErrorCode("200");
		user.setErrorMessage("Sucessfully Updated");
	}else
	{
		user.setErrorCode("404");
		user.setErrorMessage("NOT Updated");
		user.setReason("Your registration is not accepted");
	}
	return new ResponseEntity<User>(user,HttpStatus.OK);
}

}