package METIER;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ENTITIES.articles;

public interface Iarticles {
	public ResponseEntity<articles> addArticle(@RequestPart("picture_path") MultipartFile picture,
			@RequestParam("category_id") Integer category_id,
			@RequestParam("store_id") Integer store_id,
			@RequestParam("status") String status,
			@ModelAttribute articles article) throws URISyntaxException, IOException, SQLException;
	public ArrayList<String> GetPointures();
	public ArrayList<String> GetTailles();
}
