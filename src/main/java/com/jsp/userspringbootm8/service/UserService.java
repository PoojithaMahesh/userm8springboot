package com.jsp.userspringbootm8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userspringbootm8.dao.UserDao;
import com.jsp.userspringbootm8.dto.User;
import com.jsp.userspringbootm8.exception.UserIdNotFoundException;
import com.jsp.userspringbootm8.exception.UserNameNotFoundException;
import com.jsp.userspringbootm8.util.ResponseStructure;
@Service
public class UserService {

	@Autowired
	private UserDao  dao;
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User Data Saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser=dao.findUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
//			id is not oresent
			throw new UserIdNotFoundException("Sorry failed to find the data");
		}
	}
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User dbUser=dao.deleteUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Data deleted successfully");
			structure.setHttpStatus(HttpStatus.FORBIDDEN.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FORBIDDEN);
		}else {
			throw new UserIdNotFoundException("Sorry failed to delete the data");
		}
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id,user);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Data updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}else {
			throw new UserIdNotFoundException("Sorry failed to update the data");
		}
	}
	public ResponseEntity<ResponseStructure<User>> findByName(String name) {
		User dbUser=dao.findByName(name);
		if(dbUser!=null) {
//			that name is present and data fetched successfully
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}else {
			throw new UserNameNotFoundException("Sorry failed to fetch the data by name");
		}
	}

}
