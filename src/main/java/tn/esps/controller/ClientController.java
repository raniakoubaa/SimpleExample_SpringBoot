package tn.esps.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tn.esps.entity.Client;
import tn.esps.entity.Compte;
import tn.esps.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	
	@PostMapping("/save")
	public String save(@ModelAttribute Client client) {
		clientService.save(client);
		return "redirect:/client/all";
	}

	@GetMapping("/all")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("clients", clientService.findAll());
		modelAndView.setViewName("clients");
		return modelAndView;
	}

	/*
	 * @GetMapping("/all") public List<Compte> findAll() { return
	 * compteService.findAll(); }
	 */
	@GetMapping("/all-json")
	@ResponseBody // -->JSON
	public List<Client> findAllAsJson() {
		return clientService.findAll();
	}
	@GetMapping("/delete/{cin}")
	public String delete(@PathVariable(name = "cin") Long cin) {
		clientService.delete(cin);
		return "redirect:/client/all";
	}
	
	@GetMapping("/delete-ajax")
	@ResponseBody /*ne retourne pas une page html, il retourne json*/
	public void deleteWithAjax(@RequestParam(name = "cin") Long cin) {
		clientService.delete(cin);
	}
	@PostMapping("/load")
	public ModelAndView load(@RequestParam(name = "cin") Long cin) {
		ModelAndView modelAndView = new ModelAndView();
		Client client=clientService.findByCin(cin);
		modelAndView.addObject("client",client);
		modelAndView.setViewName("edit-client");
		return modelAndView;
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Client client) {
		clientService.update(client);
		return "redirect:/client/all";
	}
}
