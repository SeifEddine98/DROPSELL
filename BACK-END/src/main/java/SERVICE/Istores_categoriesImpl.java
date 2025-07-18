package SERVICE;

import java.net.URI;
import java.net.URISyntaxException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import DAO.Stores_CategoriesRepository;
import ENTITIES.stores_categories;
import METIER.Istores_categories;

@Service
@Transactional
public class Istores_categoriesImpl implements Istores_categories {
	@Autowired
	private Stores_CategoriesRepository Stores_CategoriesRepository;
	
	@Override
	public ResponseEntity<stores_categories> addStores_Categories(@RequestBody stores_categories stores_categories) throws URISyntaxException {
		stores_categories sc = Stores_CategoriesRepository.save(stores_categories);
        return ResponseEntity.created(new URI("/addStores_Categories")).body(sc);
	}

}
