package tn.esprit.cs.gl.mini_shop;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MrBean {
	private String something;

	public String doSomething() {
		System.out.println("ahla : " + something);
		return "";
	}

	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}

}
