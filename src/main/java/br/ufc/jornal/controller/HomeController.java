package br.ufc.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.jornal.interfaces.IClassificadoDAO;
import br.ufc.jornal.interfaces.INoticiaDAO;
import br.ufc.jornal.interfaces.ISecaoDAO;
import br.ufc.jornal.model.Classificado;
import br.ufc.jornal.model.Noticia;
import br.ufc.jornal.model.Secao;

@Controller
public class HomeController {
	
	@Autowired
	private INoticiaDAO noticiaDAO;
	
	@Autowired
	private IClassificadoDAO classificadoDAO;
	
	@Autowired
	private ISecaoDAO secaoDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
			
		List<Noticia> noticias = noticiaDAO.findNoticiaByAtivoTrue();
		model.addAttribute("noticias", noticias);
		
		List<Classificado> classifados = classificadoDAO.findAll();
		model.addAttribute("classificados",classifados);
		
		List<Secao> secoes = secaoDAO.findByAtivoTrue();
		model.addAttribute("secoes",secoes);
		
		return "home";
	}
}
