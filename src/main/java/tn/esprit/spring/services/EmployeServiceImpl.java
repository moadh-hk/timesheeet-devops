package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements IEmployeService {
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	
	@Autowired
	EmployeRepository employeRepository;

	public List<Employe> retrieveAllEmployees(){
	
		List<Employe> employees = null; 
		try {
	
			
			l.info("in retrieve all employees():");
			employees = (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employees) {
				// TODO Log à ajouter pour affiher chaque user dans les logs 
				
			} 
		
			l.info("out of methode retrieve all users");
		}catch (Exception e) {
			
			l.error("erreur dans retrieve all users " + e);
		}

		return employees;
	}

	@Override
	public Employe addEmploye(Employe e) {
		l.info("In methode addEmploye");
		Employe e_saved = employeRepository.save(e); 
		
		l.info("Out methode addEmploye");
		return e_saved; 
	}

	@Override
	public void deleteEmploye(int id) {
		l.info("In methode deleteEmploye");
		employeRepository.deleteById(id); 
		l.info("Out methode deleteEmploye");
		
	}

	@Override
	public Employe updateEmploye(Employe e) {
		l.info("In methode updateEmploye");
		Employe e_saved = employeRepository.save(e); 
		
		l.info("Out methode updateEmploye");
		return e_saved; 
	}

	@Override
	public Employe retrieveEmploye(int id) {
		Employe ee = null;
		 try{
			 l.info("In methode retrieveEmploye");
				//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
				 ee =  employeRepository.findById(id).get(); 
				
				l.info("Out methode retrieveEmploye");
		 }catch(Exception e){
			 l.error("error in retrieveEmploye() : "+ e);
		 }
		
		return ee; 
	}

	
}
