package tn.esprit.cs.gl.mini_shop.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.cs.gl.mini_shop.persistence.Category;
import tn.esprit.cs.gl.mini_shop.services.CatalogServiceLocal;

@ManagedBean
@RequestScoped
public class CategoryBean {
	private Category category = new Category();

	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public String doCreateCategory() {
		catalogServiceLocal.createCategory(category);
		return "";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
