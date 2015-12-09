package tn.esprit.cs.gl.mini_shop.rest;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.cs.gl.mini_shop.persistence.Category;
import tn.esprit.cs.gl.mini_shop.services.CatalogServiceLocal;

@Path("/cats")
@RequestScoped
public class CategoryResource {
	@Inject
	private CatalogServiceLocal catalogServiceLocal;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> doFindAllCatalogue() {
		return catalogServiceLocal.findAllCategories();
	}
}
