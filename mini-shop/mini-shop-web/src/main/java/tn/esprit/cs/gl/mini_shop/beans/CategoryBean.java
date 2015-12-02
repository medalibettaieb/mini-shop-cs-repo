package tn.esprit.cs.gl.mini_shop.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cs.gl.mini_shop.persistence.Category;
import tn.esprit.cs.gl.mini_shop.services.CatalogServiceLocal;

@ManagedBean
@ViewScoped
public class CategoryBean {
	private Category category = new Category();
	private List<Category> categories = new ArrayList<>();
	private Category categoryChosen = new Category();
	private Boolean displayForm = false;

	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public String doCreateCategory() {
		catalogServiceLocal.saveCategory(categoryChosen);
		displayForm = false;
		categoryChosen = new Category();
		return "";
	}

	public String dodeleteCategory() {
		catalogServiceLocal.removeCategory(categoryChosen);
		displayForm = false;
		return "";
	}
	public Category doFindCategoryByNameBis(String name) {
		return catalogServiceLocal.findCategoryByName(name);
	}
	public void changeDisplayForm() {
		displayForm = true;
	}

	public void cancel() {
		displayForm = false;
		categoryChosen = new Category();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		categories = catalogServiceLocal.findAllCategories();
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category getCategoryChosen() {
		return categoryChosen;
	}

	public void setCategoryChosen(Category categoryChosen) {
		this.categoryChosen = categoryChosen;
	}

	public Boolean getDisplayForm() {
		return displayForm;
	}

	public void setDisplayForm(Boolean displayForm) {
		this.displayForm = displayForm;
	}

	

}
