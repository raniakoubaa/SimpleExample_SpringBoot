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

	}

}
