package tn.esprit.cs.gl.mini_shop.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.cs.gl.mini_shop.persistence.Admin;
import tn.esprit.cs.gl.mini_shop.persistence.Customer;
import tn.esprit.cs.gl.mini_shop.persistence.User;
import tn.esprit.cs.gl.mini_shop.services.UserServiceLocal;

@ManagedBean
@SessionScoped
public class LoginBean {
	// models
	private User user = new User();
	private Boolean loggedInAsAdmin = false;
	// injection of the proxy
	@EJB
	private UserServiceLocal userServiceLocal;

	// methods

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServiceLocal.authenticate(user.getLogin(),
				user.getPassword());
		user = userLoggedIn;
		if (userLoggedIn instanceof Admin) {
			loggedInAsAdmin = true;
			navigateTo = "/pages/adminHome/adminHome";
		} else if (userLoggedIn instanceof Customer) {
			navigateTo = "/pages/customerHome/customerHome";
		} else {
			navigateTo = "error";
		}

		return navigateTo;
	}

	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		user = new User();
		return "/loginPage?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsAdmin() {
		return loggedInAsAdmin;
	}

	public void setLoggedInAsAdmin(Boolean loggedInAsAdmin) {
		this.loggedInAsAdmin = loggedInAsAdmin;
	}

}
