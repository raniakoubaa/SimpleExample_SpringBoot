package tn.esps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esps.CompteDao;
import tn.esps.entity.Compte;

//controller -> service -> repository
@Service
public class CompteService {
	private final CompteDao compteDao;

	// injection via constructeur
	@Autowired
	public CompteService(CompteDao compteDao) {
		super();
		this.compteDao = compteDao;
	}

	public void save(Compte compte) {
		compteDao.save(compte);
	}

	public List<Compte> findAll() {
		return compteDao.findAll();
	}

	public void delete(Long rib) {
		compteDao.delete(rib);
	}

	public Compte findByRib(Long rib) {
		return compteDao.findByRib(rib);
	}

	public void update(Compte compte) {
		compteDao.update(compte);
		
	}

	
}
