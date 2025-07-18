package METIER;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ENTITIES.categories;


public interface Icategories {
	public ArrayList<String> GetCategoriesByParent_id(@PathVariable("parent_id") Integer parent_id);
	public ArrayList<categories> GetCategoriesOByParent_id(@PathVariable("parent_id") Integer parent_id);
	public Integer GetCategoriesIdByName(@RequestParam("name") String name);
	public ArrayList<String> GetCategoriesBy_id();
	public ArrayList<categories> GetCategoriesOBy_id();
}
