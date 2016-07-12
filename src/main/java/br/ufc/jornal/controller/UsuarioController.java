package br.ufc.jornal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.jornal.criptografia.Criptografia;
import br.ufc.jornal.imagem.Imagem;
import br.ufc.jornal.interfaces.IClassificadoDAO;
import br.ufc.jornal.interfaces.IComentarioDAO;
import br.ufc.jornal.interfaces.INoticiaDAO;
import br.ufc.jornal.interfaces.IPapelDAO;
import br.ufc.jornal.interfaces.IUsuarioDAO;
import br.ufc.jornal.model.Classificado;
import br.ufc.jornal.model.Papel;
import br.ufc.jornal.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private IPapelDAO papelDao;
		
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private IClassificadoDAO classificadoDAO;
	
		
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){
		return "usuario/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirEditorFormulario")
	public String inserirEditorFormulario(){
		return "editor/inserir_editor_formulario";
	}
	
	@RequestMapping("/inserirJornalistaFormulario")
	public String inserirJornalistaFormulario(){
		return "jornalista/inserir_jornalista_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usuario, @RequestParam(value="imagem",required=false) MultipartFile imagem ) throws IOException{
		
		Imagem.salvarImagem(servletContext.getRealPath("/") 
				+ "resources/imagens/usuarios/"+usuario.getLogin()+".png", imagem);
		usuario.setCaminho(usuario.getLogin()+".png");	
		
		usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
		
		List <Papel> papeis = new ArrayList<Papel>();
		Papel papel = papelDao.findOne((long) 2);
		papeis.add(papel);
		usuario.setPapeis(papeis);
		
		usuarioDAO.save(usuario);
		return "redirect:efetuarLogin";
	
	}
	
	@RequestMapping("/inserirUsuarioJornalista")
	public String inserirUsuarioJornalista(Usuario usuario, @RequestParam(value="imagem",required=false) MultipartFile imagem ) throws IOException{
		
		Imagem.salvarImagem(servletContext.getRealPath("/") 
				+ "resources/imagens/usuarios/"+usuario.getLogin()+".png", imagem);
		usuario.setCaminho(usuario.getLogin()+".png");	
		
		usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
		
		List <Papel> papeis = new ArrayList<Papel>();
		Papel papel = papelDao.findOne((long) 1);
		papeis.add(papel);
		usuario.setPapeis(papeis);
		
		usuarioDAO.save(usuario);
		return "usuario/usuario_inserido_ok";
	
	}
	
	@RequestMapping("/inserirUsuarioEditor")
	public String inserirUsuarioEditor(Usuario usuario, @RequestParam(value="imagem",required=false) MultipartFile imagem ) throws IOException{
		
		Imagem.salvarImagem(servletContext.getRealPath("/") 
				+ "resources/imagens/usuarios/"+usuario.getLogin()+".png", imagem);
		usuario.setCaminho(usuario.getLogin()+".png");	
		
		usuario.setSenha(Criptografia.criptografar(usuario.getSenha()));
		
		List <Papel> papeis = new ArrayList<Papel>();
		Papel papel = papelDao.findOne((long) 3);
		papeis.add(papel);
		usuario.setPapeis(papeis);
		
		usuarioDAO.save(usuario);
		return "usuario/usuario_inserido_ok";
	
	}
	
	@RequestMapping("/lerClassificadoCompleto")
	public String lerClassificadoCompleto (Long id, Model model, HttpSession session) {
		
		Classificado classificado = classificadoDAO.findOne(id);
		model.addAttribute("classificado",classificado);
		
		session.getAttribute("usuario_logado");
	
		return "classificado/ler_classificado_completo";
	
	}
	
	@RequestMapping("/inserirOferta")
	public String inserirOferta(Long id_usuario,Long id_classificado,
			String melhor_oferta , HttpSession session) {
		
		System.out.println(id_usuario + " " + id_classificado);
		float of = Float.parseFloat(melhor_oferta);
		
		Usuario usuario = usuarioDAO.findOne(id_usuario);
		Classificado classificado = classificadoDAO.findOne(id_classificado);
		List<Classificado> classificados = new ArrayList<>();
		classificados.add(classificado);
		usuario.setClassificados(classificados);
		
		
		if(of > classificado.getMelhor_oferta() && of > classificado.getPreco()) {
			classificado.setMelhor_oferta(of);
			classificado.setUsuario(usuario);
			classificadoDAO.save(classificado);
			return "classificado/oferta_inserido_ok";
		}	
		
		return "classificado/classificado_nao_inserido";
	}
	
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = usuarioDAO.findAll();
		model.addAttribute("usuarios", usuarios);
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
