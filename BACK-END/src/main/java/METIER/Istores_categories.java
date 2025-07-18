package METIER;

import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import ENTITIES.stores_categories;

public interface Istores_categories {
	public ResponseEntity<stores_categories> addStores_Categories(@RequestBody stores_categories stores_categories) throws URISyntaxException;
}
