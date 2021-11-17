package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class EmployeServiceImplTest {
	
		
@Autowired
IEmployeService es;
		
		@Test
		@Order(1)
		public void testRetrieveAllEmployees(){
			List<Employe> listEmployees=es.retrieveAllEmployees();
			Assertions.assertEquals(0,listEmployees.size());
		}
		
		@Test
		@Order(2)
		public void testAddEmploye() throws ParseException{
			Employe e = new Employe("Hajkacem10","moadh10","moadh10.hajkacem@esprit.tn","password10",true,Role.TECHNICIEN);
			Employe employeAdded=es.addEmploye(e);
			Assertions.assertEquals(e.getNom(), employeAdded.getNom());
		}
		
		
		@Test
		@Order(3)
		public void testModifyEmploye() throws ParseException{
			Employe e = new Employe(1,"hajkacem6","moadh6","moadh6.hajkacem@esprit.tn","password6",true,Role.INGENIEUR);
			Employe employeUpdated=es.updateEmploye(e);
			Assertions.assertEquals(e.getNom(), employeUpdated.getNom());
		}
		@Test
		@Order(4)
		public void testRetrieveEmploye() throws ParseException{
			Employe employeRetrieved = es.retrieveEmploye(1);
			Assertions.assertEquals(1,employeRetrieved.getId());
		}

		@Test
		@Order(5)
		public void testDeleteEmploye() throws ParseException{
			es.deleteEmploye(1);
			Assertions.assertNull(es.retrieveEmploye(1));
		}

}
