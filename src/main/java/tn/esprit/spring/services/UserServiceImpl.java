package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	// TODO Logger à ajouter  
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			
			l.info("in retrieve all users():");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs 
				
			} 
		
			l.info("out of methode retrieve all users");
		}catch (Exception e) {
			
			l.error("erreur dans retrieve all users " + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		
		l.info("In methode addUser");
		User u_saved = userRepository.save(u); 
		
		l.info("Out methode addUser");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		
		l.info("In methode updateUser");
		User u_saved = userRepository.save(u); 
		
		l.info("Out methode updateUser");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		
		l.info("In methode deleteUser");
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("Out methode deleteUser");
		
	}

	@Override
	public User retrieveUser(String id) {
		User u = null;
		 try{
			 l.info("In methode retrieveUser");
				//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
				 u =  userRepository.findById(Long.parseLong(id)).get(); 
				
				l.info("Out methode retrieveUser");
		 }catch(Exception e){
			 l.error("error in retrieveUser() : "+ e);
		 }
		
		return u; 
	}

}
