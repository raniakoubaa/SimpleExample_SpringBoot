package tn.esps;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import tn.esps.entity.Compte;
//Entity manager
// Repository
@Repository
public class CompteDao {
	@PersistenceContext /* injection de dépendance */
	private EntityManager em; // em sera initialisé automatiquement par le serveur

	@Transactional
	public void save(Compte compte) {
		em.persist(compte);
	}

	@Transactional
	public void update(Compte compte) {
		em.merge(compte);
	}

	@Transactional
	public void delete(Compte compte) {
		em.remove(compte);
	}

	@Transactional
	public void delete(Long rib) {
		em.remove(findByRib(rib));
	}

	public Compte findByRib(Long rib) {
		return em.find(Compte.class, rib);
	}

	public List<Compte> findAll() {
		return em.createQuery("from Compte", Compte.class).getResultList();
	}

	public List<Compte> findAllBySoldeGreaterThan(float solde) {
		return em.createQuery("select c from Compte c where c.solde > :solde", Compte.class)
				.setParameter("solde", solde).getResultList();
	}
}
