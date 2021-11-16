package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {
	List<Employe> retrieveAllEmployees(); 
	Employe addEmploye(Employe u);
	void deleteEmploye(int id);
	Employe updateEmploye(Employe u);
	Employe retrieveEmploye(int id);

}
