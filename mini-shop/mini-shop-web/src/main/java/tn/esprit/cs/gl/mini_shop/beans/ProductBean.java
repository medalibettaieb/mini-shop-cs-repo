package tn.esprit.cs.gl.mini_shop.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.cs.gl.mini_shop.persistence.Product;
import tn.esprit.cs.gl.mini_shop.services.CatalogServiceLocal;

@ManagedBean
@ViewScoped
public class ProductBean {
	private Product product = new Product();
	private List<Product> products = new ArrayList<>();
	@EJB
	private CatalogServiceLocal catalogServiceLocal;

	public String doCreateProduct() {
		catalogServiceLocal.createProduct(product);
		return "";
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
}
