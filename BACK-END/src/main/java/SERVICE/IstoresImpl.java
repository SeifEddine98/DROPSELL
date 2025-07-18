package SERVICE;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ENTITIES.User;
import ENTITIES.categories;
import ENTITIES.partners;
import ENTITIES.stores;
import ENTITIES.stores_categories;
import DAO.StoresRepository;
import DAO.CategorieRepository;
import DAO.PartnersRepository;
import DAO.Stores_CategoriesRepository;
import DAO.UserRepository;
import METIER.Istores;

@Service
@Transactional
public class IstoresImpl implements Istores {
	Integer a;
	Integer b;
	ArrayList<Integer> s1;
	ArrayList<Integer> s2;
	Collection<partners> c;
	Collection<stores> c1;
	@Autowired
	private StoresRepository StoresRepository;
	@Autowired
	private CategorieRepository CategorieRepository;
	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private PartnersRepository PartnersRepository;
	@Autowired
	private Stores_CategoriesRepository Stores_CategoriesRepository;


	@Override
	public ResponseEntity<stores> addStore(@RequestPart("logo_path") MultipartFile logo,
											@RequestPart("couverture_path") MultipartFile couverture,
											@RequestParam("partner_id") Integer partner_id ,
											@ModelAttribute stores store) throws URISyntaxException, IOException {
	    partners p= PartnersRepository.findById(partner_id).get();
	    store.setPartner(p);
	    stores s = StoresRepository.save(store);
	    return ResponseEntity.created(new URI("/addStore" + s.getId())).body(s);

	}


	@Override
	public ResponseEntity<partners> addPartner(@RequestParam ("user_id") Integer user_id) throws URISyntaxException {
	    User u= UserRepository.findById(user_id).get();
	    partners p= new partners(u);
	    partners p2 = PartnersRepository.save(p);
	    return ResponseEntity.created(new URI("/addPartner" + p2.getId())).body(p2);
	}
	@Override
	public Integer getPartnerIdByUserId(@RequestParam Integer user_id) {
	    s1=new ArrayList<Integer>();
		c= PartnersRepository.findAll();
	    if(c == null || c.isEmpty()) {
	    	return null;
	    }
	    for(partners x : c) {
	        if(x.getUser() != null && x.getUser().getId() == user_id) {
	            s1.add(x.getUser().getId());
	            a=x.getId();
	        }
	    }
	    return a;
	}
	@Override
	public Integer getStoreIdByPartnerId(@RequestParam("partner_id") Integer partner_id) {
	    s2=new ArrayList<Integer>();
		c1= StoresRepository.findAll();
	    if(c1 == null || c1.isEmpty()) {
	    	return null;
	    }
	    for(stores x : c1) {
	        if(x.getPartner() != null && x.getPartner().getId() == partner_id) {
	            s2.add(x.getPartner().getId());
	            b=x.getId();
	        }
	    }
	    return b;
	}

	@Override
	public ResponseEntity<stores_categories> addStores_Categories(@RequestParam("store_id") Integer store_id,
			@RequestParam("categorie_id") Integer categorie_id) throws URISyntaxException {
	    stores s= StoresRepository.findById(store_id).get();
	    categories c= CategorieRepository.findById(categorie_id).get();
	    stores_categories sc= new stores_categories(s,c);
	    stores_categories sc2 = Stores_CategoriesRepository.save(sc);
	    return ResponseEntity.created(new URI("/addStores_Categories" + sc2.getId())).body(sc);
	}


	




}
