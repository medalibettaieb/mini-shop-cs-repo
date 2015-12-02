package tn.esprit.cs.gl.mini_shop.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cs.gl.mini_shop.persistence.Category;
import tn.esprit.cs.gl.mini_shop.persistence.Product;
import tn.esprit.cs.gl.mini_shop.services.CatalogServiceLocal;

@ManagedBean
@ViewScoped
public class ProductBean {
	private Product product = new Product();
	private Category categoryInMenu = new Category();
	private List<Product> products = new ArrayList<>();
	private List<Category> categories = new ArrayList<Category>();
	private Boolean displayForm = false;
	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public String doCreateProduct() {
		product.setCategory(categoryInMenu);
		catalogServiceLocal.saveProduct(product);
		product = new Product();
		displayForm = false;
		return "";
	}

	public String doDeleteProduct() {
		catalogServiceLocal.removeProduct(product);
		product = new Product();
		displayForm = false;
		return "";
	}

	public void display() {
		displayForm = true;
	}

	public void cancel() {
		product = new Product();
		displayForm = false;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		products = catalogServiceLocal.findAllProducts();
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category getCategoryInMenu() {
		return categoryInMenu;
	}

	public void setCategoryInMenu(Category categoryInMenu) {
		this.categoryInMenu = categoryInMenu;
	}

	public Boolean getDisplayForm() {
		return displayForm;
	}

	public void setDisplayForm(Boolean displayForm) {
		this.displayForm = displayForm;
	}

	public List<Category> getCategories() {
		categories = catalogServiceLocal.findAllCategories();
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
