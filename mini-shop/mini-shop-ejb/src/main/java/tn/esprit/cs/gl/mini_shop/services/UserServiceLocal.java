package tn.esprit.cs.gl.mini_shop.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.cs.gl.mini_shop.persistence.Customer;
import tn.esprit.cs.gl.mini_shop.persistence.User;
@Local
public interface UserServiceLocal {
	void createUser(User user);
	void saveCustomer(Customer customer);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	boolean loginExists(String login);
	User findUserByLogin(String login);
}
