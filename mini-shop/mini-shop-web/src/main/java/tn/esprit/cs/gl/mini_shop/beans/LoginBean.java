package tn.esprit.cs.gl.mini_shop.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
	// models
	private String login;
	private String password;

	// methods

	public String doLogin() {
		String navigateTo = null;
		if (login.equalsIgnoreCase("admin")
				&& password.equalsIgnoreCase("admin")) {
			navigateTo = "OK";
		} else {
			navigateTo = "KO";
		}
		System.out.println(navigateTo);
		return navigateTo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
