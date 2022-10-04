package tn.esps;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tn.esps.entity.Client;
import tn.esps.entity.Compte;

//Entity manager
//Repository
@Repository
public class ClientDao {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Client client) {
		em.persist(client);
	}

	public void delete(Client client) {
		em.remove(client);		
	}

	public List<Client> findAll() {
		return em.createQuery("from Client", Client.class).getResultList();
	}

	public Client findByCin(Long cin) {
		return em.find(Client.class, cin);
	}

	@Transactional
	public void delete(Long cin) {
		em.remove(findByCin(cin));
	}

	@Transactional
	public void update(Client client) {
		em.merge(client);	
	}
}
