package com.jsp.userspringbootm8.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userspringbootm8.dto.User;
import com.jsp.userspringbootm8.repo.UserRepo;

import jakarta.persistence.EntityManagerFactory;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;
	public User saveUser(User user) {
		return repo.save(user);
	}
	public User findUser(int id) {
	Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			that id is present
			User user=optional.get();
			return user;
		}else {
//			id is not present
			return null;
		}
	}
	public User deleteUser(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			id is present then  i can delete the data
			repo.deleteById(id);
//			repo.delete(optional.get());
			return optional.get();
		}else {
			return null;
		}
	}
	public User updateUser(int id, User user) {
		Optional<User>  optional=repo.findById(id);
		if(optional.isPresent()) {
//			id is present so i can update the data
			user.setId(id);
			return repo.save(user);
			
		}
		return null;
	}
	public User findByName(String name) {
		Optional<User> optional=repo.findByName(name);
		if(optional.isPresent()) {
//			name ois present
			return optional.get();
		}
		return null;
	}

}
