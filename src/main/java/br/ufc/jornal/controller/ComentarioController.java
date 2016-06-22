package br.ufc.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.interfaces.IComentarioDAO;
import br.ufc.jornal.model.Comentario;

@Controller
public class ComentarioController {

	@Autowired
	private IComentarioDAO comentarioDAO; 
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(){
		return "comentario/inserir_comentario_formulario";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(Comentario comentario){
		comentarioDAO.save(comentario);
		return "redirect:listarComentario";
	}
	
	@RequestMapping("/listarComentario")
	public String listarComentario(Model model){
		List<Comentario> comentarios = comentarioDAO.findAll();
		model.addAttribute("comentario", comentarios);
		return "comentario/listar_comentario";
	}
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long id){
		comentarioDAO.delete(id);
		return "redirect:listarComentario";
	}
	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long id, Model model){
		Comentario comentario = comentarioDAO.findOne(id);
		model.addAttribute("Comentario", comentario);
		return "comentario/alterar_comentario_formulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentario comentario){
		comentarioDAO.save(comentario);
		return "redirect:listarComentario";
	}
}
