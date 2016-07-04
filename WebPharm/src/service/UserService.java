package service;

import java.util.List;

import dao.UserDAO;
import model.User;

public class UserService {

	public static void add(User user) {
		UserDAO.add(user);		
	}

	public static List<User> getAll() {
		return UserDAO.getAll();
	}

}
