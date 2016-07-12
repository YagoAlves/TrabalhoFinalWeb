package br.ufc.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.interfaces.ISecaoDAO;
import br.ufc.jornal.model.Secao;

@Controller
public class SecaoController {
	
	@Autowired
	private ISecaoDAO secaoDAO; 
	
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(){
		return "secao/inserir_secao_formulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(Secao secao){
		secao.setAtivo(true);
		secaoDAO.save(secao);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("/listarSecao")
	public String listarSecao(Model model){
		List<Secao> secoes = secaoDAO.findByAtivoTrue();
		model.addAttribute("secoes", secoes);
		return "secao/listar_secao";
	}
	
	@RequestMapping("/apagarSecao")
	public String apagarSecao(Long id){
		secaoDAO.delete(id);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("/alterarSecaoFormulario")
	public String alterarSecaoFormulario(Long id, Model model){
		Secao secao = secaoDAO.findOne(id);
		model.addAttribute("secao", secao);
		return "secao/alterar_secao_formulario";
	}
	
	@RequestMapping("/alterarSecao")
	public String alterarSecao(Secao secao){
		secaoDAO.save(secao);
		return "redirect:listarSecao";
	}
}
