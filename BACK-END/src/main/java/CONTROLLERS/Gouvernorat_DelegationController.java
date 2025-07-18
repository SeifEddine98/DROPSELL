package CONTROLLERS;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import METIER.Igouvernorat_delegation;

@RestController
@RequestMapping("/Gouvernorat_Delegation")
@CrossOrigin(origins ="http://localhost:8100")
public class Gouvernorat_DelegationController {
	@Autowired
	private final Igouvernorat_delegation Ic;

	public Gouvernorat_DelegationController(Igouvernorat_delegation ic) {
		super();
		Ic = ic;
	}
	@GetMapping("/GetAllGouvernorats")
	public ArrayList<String> GetAllGouvernorats()
	{
		return Ic.GetAllGouvernorats();
	}
	@GetMapping("/GetDelegationsByGouvernorat")
	public ArrayList<String> GetDelegationsByGouvernorat(@RequestParam("gouvernorat") String gouvernorat)
	{
		return Ic.GetDelegationsByGouvernorat(gouvernorat);
	}
	
}
