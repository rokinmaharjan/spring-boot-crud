package com.rokin.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rokin.spring.model.User;

@Service
public class UserService implements CrudManager<User, String> {
	List<User> users = new ArrayList<>(Arrays.asList(new User("asd123", "Sushant Siwakoti", "Lagan Tole"),
			new User("qwe123", "Nitesh Poudel", "Imadol"), 
			new User("zxc123", "Sujan Dhungana", "Babarmahal")));

	@Override
	public User addNew(User t) {
		this.users.add(t);
		return t;
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}

	@Override
	public User getById(String id) {
		for (User user : this.users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}

		return null;
	}

	@Override
	public User update(User t) {
		for (User user : this.users) {
			if (user.getId().equals(t.getId())) {
				user.setName(t.getName());
				user.setAddress(t.getAddress());
			}
		}
		
		return t;
	}

	@Override
	public void delete(User t) {
		this.users.remove(t);
	}

	@Override
	public void deleteById(String id) {
		User user = getById(id);
		this.users.remove(user);
	}
	
}
