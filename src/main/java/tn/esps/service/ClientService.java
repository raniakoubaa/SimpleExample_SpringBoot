package tn.esps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esps.ClientDao;
import tn.esps.entity.Client;

//controller -> service -> repository
@Service
public class ClientService {
	private final ClientDao clientDao;

	// injection via constructeur
	@Autowired
	public ClientService(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}

	public void save(Client client) {
		clientDao.save(client);
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

	public void delete(Long cin) {
		clientDao.delete(cin);
	}

	public Client findByCin(Long cin) {
		return clientDao.findByCin(cin);
	}

	public void update(Client client) {
		clientDao.update(client);

	}

}
