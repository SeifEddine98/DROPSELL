package SERVICE;

import java.net.URI;
import java.net.URISyntaxException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import DAO.PartnersRepository;
import ENTITIES.partners;
import METIER.Ipartners;

@Service
@Transactional
public class IpartnersImpl implements Ipartners {
	@Autowired
	private PartnersRepository PartnersRepository;
	@Override
	public ResponseEntity<partners> addPartner(@RequestBody partners partner) throws URISyntaxException {
		partners p = PartnersRepository.save(partner);
        return ResponseEntity.created(new URI("/addPartner" + p.getId())).body(p);
	}

}
