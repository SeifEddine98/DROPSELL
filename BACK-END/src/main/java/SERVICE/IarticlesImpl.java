package SERVICE;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;

import static javax.persistence.criteria.Path.*;
import static javax.persistence.criteria.CriteriaBuilder.*;
import static javax.persistence.criteria.CriteriaUpdate.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import DAO.CategorieRepository;
import DAO.StoresRepository;
import DAO.ArticlesRepository;
import DAO.PointuresRepository;
import DAO.TaillesRepository;
import ENTITIES.article_status_ref;
import ENTITIES.articles;
import ENTITIES.pointures;
import ENTITIES.tailles;
import ENTITIES.categories;
import ENTITIES.partners;
import ENTITIES.stores;
import METIER.Iarticles;

@Service
@Transactional
public class IarticlesImpl implements Iarticles {
	Collection<pointures> c_pointures;
	Collection<tailles> c_tailles;
	ArrayList<String> pointures;
	ArrayList<String> tailles;
	@Autowired
	private StoresRepository StoresRepository;
	@Autowired
	private CategorieRepository CategorieRepository;
	@Autowired
	private ArticlesRepository ArticlesRepository;
	@Autowired
	private PointuresRepository PointuresRepository;
	@Autowired
	private TaillesRepository TaillesRepository;



	private article_status_ref convertStatus(String status) {
	    if (status.equals("new_with_tag")) {
	        return article_status_ref.new_with_tag;
	    } else if (status.equals("new_without_tag")) {
	        return article_status_ref.new_without_tag;
	    } else if (status.equals("very_good_condition")) {
	        return article_status_ref.very_good_condition;
	    } else if (status.equals("good_condition")) {
	        return article_status_ref.good_condition;
	    } else if (status.equals("satisfactory")) {
	        return article_status_ref.satisfactory;
	    } else {
	        throw new IllegalArgumentException("Invalid status value: " + status);
	    }
	}
	@Override
	public ResponseEntity<articles> addArticle(@RequestPart("picture_path") MultipartFile picture,
	        @RequestParam("category_id") Integer category_id,
	        @RequestParam("store_id") Integer store_id,
	        @RequestParam("status") String status,
	        @ModelAttribute articles article) throws URISyntaxException, IOException, SQLException {
	    categories c= CategorieRepository.findById(category_id).get();
	    article.setCategorie(c);
	    stores s= StoresRepository.findById(store_id).get();
	    article.setStore(s);
	    if (status.equals("new_with_tag")) {
	        article.setStatus(article_status_ref.new_with_tag);
	    } else if (status.equals("new_without_tag")) {
	    	article.setStatus(article_status_ref.new_without_tag);
	    } else if (status.equals("very_good_condition")) {
	    	article.setStatus(article_status_ref.very_good_condition);
	    } else if (status.equals("good_condition")) {
	    	article.setStatus(article_status_ref.good_condition);
	    } 
	    System.out.println(article.getStatus());
	    articles a = ArticlesRepository.save(article);
	    return ResponseEntity.created(new URI("/addArticle" + a.getId())).body(a);
	}
	@Override
	public ArrayList<String> GetPointures() {
		pointures=new ArrayList<String>();
		c_pointures= PointuresRepository.findAll().stream()
                .collect(Collectors.toList());
		for(pointures x : c_pointures){ 	
			pointures.add(x.getPointure());
	}
		return pointures;
	}
	@Override
	public ArrayList<String> GetTailles() {
		tailles=new ArrayList<String>();
		c_tailles= TaillesRepository.findAll().stream()
                .collect(Collectors.toList());
		for(tailles x : c_tailles){ 	
			tailles.add(x.getTaille());
	}
		return tailles;
	}


}
