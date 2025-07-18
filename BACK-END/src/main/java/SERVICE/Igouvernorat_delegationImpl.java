package SERVICE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.Gouvernorat_DelegationRepository;
import ENTITIES.gouvernorat_delegation;
import METIER.Igouvernorat_delegation;;

@Service
@Transactional
public class Igouvernorat_delegationImpl implements Igouvernorat_delegation {
	@Autowired
	private Gouvernorat_DelegationRepository Gouvernorat_DelegationRepository;
	Collection<gouvernorat_delegation> c;
	ArrayList<String> gouvernorats;
	ArrayList<String> delegations;
	@Override
	public ArrayList<String> GetDelegationsByGouvernorat(@RequestParam("gouvernorat") String gouvernorat) {
		c= Gouvernorat_DelegationRepository.findAll().stream().
                filter(x -> x.getGouvernorat().equals(gouvernorat))
                .collect(Collectors.toList());
		delegations=new ArrayList<String>();
		for(gouvernorat_delegation x : c)
		{
			delegations.add(x.getDelegation());
		}
		return delegations;
	}

	@Override
	public ArrayList<String> GetAllGouvernorats() {
		c= Gouvernorat_DelegationRepository.findAll().stream()
                .collect(Collectors.toList());
		gouvernorats=new ArrayList<String>();
		for(gouvernorat_delegation x : c){
			String a=x.getGouvernorat();
			if(!gouvernorats.contains(a))
			{
			gouvernorats.add(a);
			}
	}
		return gouvernorats;
	}
	
}
