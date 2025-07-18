package METIER;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ENTITIES.partners;
import ENTITIES.stores;
import ENTITIES.stores_categories;

public interface Istores {
	public ResponseEntity<stores> addStore(@RequestPart("logo_path") MultipartFile logo,
											@RequestPart("couverture_path") MultipartFile couverture,
											@RequestParam("partner_id") Integer partner_id,
											@ModelAttribute stores store) throws URISyntaxException, IOException;
	public ResponseEntity<partners> addPartner(@RequestParam ("user_id") Integer user_id) throws URISyntaxException;
	public ResponseEntity<stores_categories> addStores_Categories(@RequestParam("store_id") Integer store_id,
			@RequestParam("categorie_id") Integer categorie_id) throws URISyntaxException;
	public Integer getPartnerIdByUserId(@RequestParam("user_id") Integer user_id);
	public Integer getStoreIdByPartnerId(@RequestParam("partner_id") Integer partner_id);
}
