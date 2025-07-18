package SERVICE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.CategorieRepository;
import ENTITIES.categories;
import METIER.Icategories;

@Service
@Transactional
public class IcategoriesImpl implements Icategories {
	@Autowired
	private CategorieRepository repository;
	Collection<categories> c1,c2,c3,c4,c5;
	ArrayList<String> s1,s2;
	ArrayList<categories> s4,s5;
	ArrayList<Integer> s3;
	Integer a;
	int i;
	boolean test;
	categories v;

	@Override
	public ArrayList<String> GetCategoriesByParent_id(@PathVariable("parent_id") Integer parent_id) {
		s1=new ArrayList<String>();
		c1= repository.findAll().stream().
                filter(x -> x.getParent_id()==(parent_id))
                .collect(Collectors.toList());
		for(categories x : c1){ 	
			s1.add(x.getName());
	}
		return s1;
	}
	@Override
	public ArrayList<categories> GetCategoriesOByParent_id(@PathVariable("parent_id") Integer parent_id) {
		s4=new ArrayList<categories>();
		c4= repository.findAll().stream().
                filter(x -> x.getParent_id()==(parent_id))
                .collect(Collectors.toList());
		for(categories x : c4){ 	
			s4.add(x);
	}
		return s4;
	}
	public static boolean check(int[] tab, int val) {
        boolean b = false;
    
        for(int i : tab){
            if(i == val){
                b = true;
                break;
            }
        }
        return b;
    }
	@Override
	public ArrayList<String> GetCategoriesBy_id() {
		s2=new ArrayList<String>();
		int[] tab = {1, 2, 3, 4, 5, 108};
		c2= repository.findAll().stream().
                filter(x -> check(tab, x.getId()))
                .collect(Collectors.toList());
		for(categories x : c2){ 	
			s2.add(x.getName());
	}
		return s2;
	}
	@Override
	public ArrayList<categories> GetCategoriesOBy_id() {
		s5=new ArrayList<categories>();
		int[] tab = {1, 2, 3, 4, 5, 108};
		c5= repository.findAll().stream().
                filter(x -> check(tab, x.getId()))
                .collect(Collectors.toList());
		for(categories x : c5){ 	
			s5.add(x);
	}
		return s5;
	}
	@Override
	public Integer GetCategoriesIdByName(@RequestParam("name") String name) {
		s3=new ArrayList<Integer>();
		c3= repository.findAll();
		i=0;
		test=false;
		while ((i<c3.size())&&(test==false))
		{
			 v = (categories) c3.toArray()[i];
		        if (v.getName().equals(name)) {
		            s3.add(v.getId());
		            test = true;
		        }
		        else
		        	i++;
		}
		return v.getId();
	}
}
