package METIER;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestParam;

public interface Igouvernorat_delegation {
	public ArrayList<String> GetDelegationsByGouvernorat(@RequestParam("gouvernorat") String gouvernorat);
	public ArrayList<String> GetAllGouvernorats();
}
