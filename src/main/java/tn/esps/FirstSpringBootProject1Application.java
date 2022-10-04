package tn.esps;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import tn.esps.entity.Client;
import tn.esps.entity.Compte;

@Transactional
@Repository
@SpringBootApplication
public class FirstSpringBootProject1Application implements CommandLineRunner {

	@PersistenceContext /* injection de dépendance */
	private EntityManager em; // em sera initialisé automatiquement par le serveur
	@Autowired // injection d'un bean de spring
	private CompteDao compteDao;
	private ClientDao clientDao;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring ******************");

		

		/*  Compte c4 = em.find(Compte.class, 5L); System.out.println(c4); Compte c5 =
		  em.find(Compte.class, 4L); System.out.println(c5);
		  c4.setSolde(c4.getSolde()+50); em.merge(c4); System.out.println(c4);
		 */

		/* DAO */

		//Compte c9 = new Compte(100, "karim");
		// compteDao.save(c9); 
		//c9.setSolde(250);
		// compteDao.update(c9);
		// compteDao.delete(11L);
		// find all
		/*List<Compte> list = new ArrayList<>();
		list = compteDao.findAll();
		for (Compte compte : list) { 
			System.out.println(compte);
		}
		System.out.println("**************************");
		// Find by Rib
		System.out.println("le compte du rib 7 est = " + compteDao.findByRib(7L));*/
		
		
		//client
		
		//clientDao.save(c);
		
		/*List<Client> l = new ArrayList<>();
		l = clientDao.findAll();
		for (Client client : l) { 
			System.out.println(client);
		}*/
		System.out.println("**************************");
		
		// Find by cin
		//System.out.println("le client du rib 1 est = " + clientDao.findByCin(1L));
	}

}
