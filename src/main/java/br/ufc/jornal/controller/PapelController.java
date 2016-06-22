package br.ufc.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.interfaces.IPapelDAO;
import br.ufc.jornal.model.Papel;

@Controller
public class PapelController {

	@Autowired
	private IPapelDAO papelDAO; 
	
	@RequestMapping("/inserirPapelFormulario")
	public String inserirPapelFormulario(){
		return "papel/inserir_papel_formulario";
	}
	
	@RequestMapping("/inserirPapel")
	public String inserirPapel(Papel papel){
		papelDAO.save(papel);
		return "redirect:listarPapel";
	}
	
	@RequestMapping("/listarPapel")
	public String listarPapel(Model model){
		List<Papel> papeis = papelDAO.findAll();
		model.addAttribute("papel", papeis);
		return "papel/listar_papel";
	}
	
	@RequestMapping("/apagarPapel")
	public String apagarPapel(Long id){
		papelDAO.delete(id);
		return "redirect:listarPapel";
	}
	
	@RequestMapping("/alterarPapelFormulario")
	public String alterarPapelFormulario(Long id, Model model){
		Papel papel = papelDAO.findOne(id);
		model.addAttribute("papel", papel);
		return "papel/alterar_papel_formulario";
	}
	
	@RequestMapping("/alterarPapel")
	public String alterarPapel(Papel papel){
		papelDAO.save(papel);
		return "redirect:listarPapel";
	}
}
