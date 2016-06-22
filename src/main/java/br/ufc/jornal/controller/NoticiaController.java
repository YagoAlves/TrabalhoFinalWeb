package br.ufc.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.interfaces.INoticiaDAO;
import br.ufc.jornal.interfaces.ISecaoDAO;
import br.ufc.jornal.model.Noticia;
import br.ufc.jornal.model.Secao;

@Controller
public class NoticiaController {
	
	@Autowired
	private INoticiaDAO noticiaDAO;
	
	@Autowired
	private ISecaoDAO secaoDAO; 
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(){
		return "noticia/inserir_noticia_formulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(Noticia noticia){
		
		Secao secao;
		secao = secaoDAO.findOne(noticia.getId_secao());
		noticia.setSecao(secao);
		noticiaDAO.save(noticia);
		return "redirect:listarNoticia";
	
	}
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model){
		List<Noticia> noticias = noticiaDAO.findAll();
		model.addAttribute("noticia", noticias);
		return "noticia/listar_noticia";
	}	
	
	@RequestMapping("/apagarNoticia")
	public String apagarSecao(Long id){
		noticiaDAO.delete(id);
		return "redirect:listarNoticia";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long id, Model model){
		Noticia noticia = noticiaDAO.findOne(id);
		model.addAttribute("noticia", noticia);
		return "noticia/alterar_noticia_formulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia noticia){
		noticiaDAO.save(noticia);
		return "redirect:listarNoticia";
	}
}
