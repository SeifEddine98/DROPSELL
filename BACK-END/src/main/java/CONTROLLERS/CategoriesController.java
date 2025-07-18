package CONTROLLERS;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ENTITIES.categories;
import METIER.Icategories;

@RestController
@RequestMapping("/Categories")
@CrossOrigin(origins ="http://localhost:8100")

public class CategoriesController {
	@Autowired
	private final Icategories Ic;

	public CategoriesController(Icategories ic) {
		super();
		Ic = ic;
	}
	@GetMapping("/GetCategoriesByParent_id/{parent_id}")
	public ArrayList<String> GetCategoriesByParent_id(@PathVariable("parent_id") Integer parent_id)
	{
		return Ic.GetCategoriesByParent_id(parent_id);
	}
	@GetMapping("/GetCategoriesOByParent_id/{parent_id}")
	public ArrayList<categories> GetCategoriesOByParent_id(@PathVariable("parent_id") Integer parent_id)
	{
		return Ic.GetCategoriesOByParent_id(parent_id);
	}
	@GetMapping("/GetCategoriesBy_id")
	public ArrayList<String> GetCategoriesBy_id()
	{
		return Ic.GetCategoriesBy_id();
	}
	@GetMapping("/GetCategoriesOBy_id")
	public ArrayList<categories> GetCategoriesOBy_id()
	{
		return Ic.GetCategoriesOBy_id();
	}
	@GetMapping("/GetCategoriesIdByName")
	public Integer GetCategoriesIdByName(@RequestParam("name") String name) {
		return Ic.GetCategoriesIdByName(name);
	}

}
