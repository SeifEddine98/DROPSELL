package CONTROLLERS;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ENTITIES.articles;
import METIER.Iarticles;

@RestController
@RequestMapping("/Articles")
@CrossOrigin(origins ="http://localhost:8100")
public class ArticlesController {
	@Autowired
	private final Iarticles Ia;

	public ArticlesController(Iarticles ia) {
		super();
		Ia = ia;
	}
	@PostMapping(value = "/addArticle", consumes = {"multipart/form-data"})
	public ResponseEntity<articles> addArticle(@RequestPart("picture_path") MultipartFile picture,
			@RequestParam("category_id") Integer category_id,
			@RequestParam("store_id") Integer store_id,
			@RequestParam("status") String status,
			@ModelAttribute articles article) throws URISyntaxException, IOException, SQLException {
		return Ia.addArticle(picture, category_id, store_id, status, article);
	}
	@GetMapping("/GetPointures")
	public ArrayList<String> GetPointures()
	{
		return Ia.GetPointures();
	}
	@GetMapping("/GetTailles")
	public ArrayList<String> GetTailles()
	{
		return Ia.GetTailles();
	}

}
