package CONTROLLERS;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ENTITIES.partners;
import ENTITIES.stores;
import ENTITIES.stores_categories;
import METIER.Istores;

@RestController
@RequestMapping("/Stores")
@CrossOrigin(origins ="http://localhost:8100")
public class StoresController {
	@Autowired
	private final Istores Ic;

	public StoresController(Istores ic) {
		super();
		Ic = ic;
	}
	
	@PostMapping(value = "/addStore", consumes = {"multipart/form-data"})
	public ResponseEntity<stores> addStore(@RequestPart("logo_path") MultipartFile logo,
											@RequestPart("couverture_path") MultipartFile couverture,
											@RequestParam("partner_id") Integer partner_id ,
											@ModelAttribute stores store) throws URISyntaxException, IOException {
		return Ic.addStore(logo, couverture, partner_id, store);
	}
	
	@PostMapping("/addPartner")
	public ResponseEntity<partners> addPartner(@RequestParam ("user_id") Integer user_id) throws URISyntaxException {
		return Ic.addPartner(user_id);
	}
	@PostMapping("/addStores_Categories")
	public ResponseEntity<stores_categories> addStores_Categories(@RequestParam("store_id") Integer store_id,
			@RequestParam("categorie_id") Integer categorie_id) throws URISyntaxException {
		return Ic.addStores_Categories(store_id,categorie_id);
	}
	@GetMapping("/getPartnerIdByUserId")
	public Integer getPartnerIdByUserId(@RequestParam("user_id") Integer user_id) {
		return Ic.getPartnerIdByUserId(user_id);
	}
	@GetMapping("/getStoreIdByPartnerId")
	public Integer getStoreIdByPartnerId(@RequestParam("partner_id") Integer partner_id) {
		return Ic.getStoreIdByPartnerId(partner_id);
	}
	
}


