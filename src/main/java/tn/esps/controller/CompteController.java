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
import tn.esps.service.CompteService;

@Controller
@RequestMapping("/compte")
public class CompteController {
	private final CompteService compteService;

	@Autowired
	public CompteController(CompteService compteService) {
		super();
		this.compteService = compteService;
	}

	@PostMapping("/save1")
	public String save1(@RequestParam(name = "solde") float solde, @RequestParam(name = "client") Client client) {
		Compte compte = new Compte(solde, client);
		compteService.save(compte);
		return "redirect:/compte/all";
	}
	
	@PostMapping("/save2")
	public String save2(@ModelAttribute Compte compte) {
		compteService.save(compte);
		return "redirect:/compte/all";
	}

	@GetMapping("/all")
	public ModelAndView findAll() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("comptes", compteService.findAll());
		modelAndView.setViewName("comptes");
		return modelAndView;
	}

	/*
	 * @GetMapping("/all") public List<Compte> findAll() { return
	 * compteService.findAll(); }
	 */
	@GetMapping("/all-json")
	@ResponseBody // -->JSON
	public List<Compte> findAllAsJson() {
		return compteService.findAll();
	}
	@GetMapping("/delete/{rib}")
	public String delete(@PathVariable(name = "rib") Long rib) {
		compteService.delete(rib);
		return "redirect:/compte/all";
	}
	
	@GetMapping("/delete-ajax")
	@ResponseBody /*ne retourne pas une page html, il retourne json*/
	public void deleteWithAjax(@RequestParam(name = "rib") Long rib) {
		compteService.delete(rib);
	}
	@PostMapping("/load")
	public ModelAndView load(@RequestParam(name = "rib") Long rib) {
		ModelAndView modelAndView = new ModelAndView();
		Compte compte=compteService.findByRib(rib);
		modelAndView.addObject("compte",compte);
		modelAndView.setViewName("edit-compte");
		return modelAndView;
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Compte compte) {
		compteService.update(compte);
		return "redirect:/compte/all";
	}
}
