package METIER;

import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import ENTITIES.partners;

public interface Ipartners {
	public ResponseEntity<partners> addPartner(@RequestBody partners partner) throws URISyntaxException;
}
