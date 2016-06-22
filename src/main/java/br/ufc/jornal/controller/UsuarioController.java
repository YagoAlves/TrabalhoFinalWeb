package br.ufc.jornal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.interfaces.IUsuarioDAO;
import br.ufc.jornal.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioDAO usuarioDAO; 
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){
		return "usuario/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usuario){
		usuarioDAO.save(usuario);
		return "redirect:listarClassificado";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = usuarioDAO.findAll();
		model.addAttribute("usuario", usuarios);
		return "usuario/listar_usuario";
	}
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id){
		usuarioDAO.delete(id);
		return "redirect:listarUsuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		Usuario usuario = usuarioDAO.findOne(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usuario){
		usuarioDAO.save(usuario);
		return "redirect:listarUsuario";
	}
}
