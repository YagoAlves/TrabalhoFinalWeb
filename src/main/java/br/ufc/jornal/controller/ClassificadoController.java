package br.ufc.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.interfaces.IClassificadoDAO;
import br.ufc.jornal.model.Classificado;

@Controller
public class ClassificadoController {
	
	@Autowired
	private IClassificadoDAO classificadoDAO; 
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(){
		return "classificado/inserir_classificado_formulario";
	}
	
	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(Classificado classificado){
		classificadoDAO.save(classificado);
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/listarClassificado")
	public String listarClassificado(Model model){
		List<Classificado> secoes = classificadoDAO.findAll();
		model.addAttribute("secao", secoes);
		return "classificado/listar_classificado";
	}
	
	@RequestMapping("/apagarClassificado")
	public String apagarClassificado(Long id){
		classificadoDAO.delete(id);
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long id, Model model){
		Classificado classificado = classificadoDAO.findOne(id);
		model.addAttribute("classificado", classificado);
		return "classificado/alterar_classificado_formulario";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificado classificado){
		classificadoDAO.save(classificado);
		return "redirect:listarClassificado";
	}
}
