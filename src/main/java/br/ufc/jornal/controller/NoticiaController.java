package br.ufc.jornal.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.jornal.imagem.Imagem;
import br.ufc.jornal.interfaces.IComentarioDAO;
import br.ufc.jornal.interfaces.INoticiaDAO;
import br.ufc.jornal.interfaces.ISecaoDAO;
import br.ufc.jornal.interfaces.IUsuarioDAO;
import br.ufc.jornal.model.Comentario;
import br.ufc.jornal.model.Noticia;
import br.ufc.jornal.model.Secao;
import br.ufc.jornal.model.Usuario;

@Controller
public class NoticiaController {
	
	@Autowired
	private INoticiaDAO noticiaDAO;
	
	@Autowired
	private ISecaoDAO secaoDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private IComentarioDAO comentarioDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model, HttpSession session){
		List<Secao> secoes = secaoDAO.findByAtivoTrue();
		model.addAttribute("secoes", secoes);
		session.getAttribute("usuario_logado");
		return "noticia/inserir_noticia_formulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(Noticia noticia,
			@RequestParam(value="imagem",required=false) MultipartFile imagem,
			Long id_secao, Long id_usuario){
		
		Imagem.salvarImagem(servletContext.getRealPath("/") 
				+ "resources/imagens/noticias/"+noticia.getTitulo()+".png", imagem);
		noticia.setCaminho(noticia.getTitulo()+".png");	
		
		Date d = new Date();
		Calendar ca = Calendar.getInstance();
		ca.set(d.getYear(), d.getMonth(), d.getDate());
		
		noticia.setData_noticia(ca);
		Secao secao;
		secao = secaoDAO.findOne(id_secao);
		Usuario usuario = usuarioDAO.findOne(id_usuario);
		
		List <Noticia> noticias = new ArrayList<>();
		noticias.add(noticia);
		usuario.setNoticias(noticias);
		
		noticia.setUsuario(usuario);
		noticia.setSecao(secao);
		noticia.setAtivo(true);
		noticiaDAO.save(noticia);
		
		return "noticia/listar_noticia_jornalista";
	
	}
	
	@RequestMapping("/listarNoticiaJornalista")
	public String listarNoticia(Model model , HttpSession session){
		List<Noticia> noticias = noticiaDAO.findNoticiaByAtivoTrue();
		
		session.getAttribute("usuario_logado");
		
		model.addAttribute("noticias", noticias);
		return "noticia/listar_noticia_jornalista";
	}
	
	@RequestMapping("/listarNoticiaEditor")
	public String listarNoticia(Model model){
		
		List<Noticia> noticias = noticiaDAO.findNoticiaByAtivoTrue();	
		model.addAttribute("noticias", noticias);
		return "noticia/listar_noticia_editor";
	
	}
	
	@RequestMapping("/apagarNoticia")
	public String apagarSecao(Long id){
		
		Noticia noticia = noticiaDAO.findOne(id);
		noticia.setAtivo(false);
		noticiaDAO.save(noticia);
		return "noticia/listar_noticia_jornalista";
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
	
	@RequestMapping("/listarNoticiasPorSecao")
	public String listarPorSecao (Model model,Long id, HttpSession session) {
		Secao secao = secaoDAO.findOne(id);
		List<Noticia> noticias = noticiaDAO.findNoticiaBySecao(secao);
		session.getAttribute("usuario_logado");
		model.addAttribute("noticias", noticias);
		return "noticia/listar_notica_secao";
	}
	
	@RequestMapping("/lerNoticiaCompleta")
	public String lerNoticiaCompleta (HttpSession session, Long id, Model model) {
		
		Noticia noticia = noticiaDAO.findOne(id);
		model.addAttribute("noticia",noticia);
		
		session.getAttribute("usuario_logado");
		
		List<Comentario> comentarios = comentarioDAO.findComentarioByNoticia(noticia);
		model.addAttribute("comentarios", comentarios);
		
		return "noticia/ler_noticia_completa";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario (Long id_noticia, Long id_usuario , String comentario, HttpSession session) {
		
		Comentario c = new Comentario();
		c.setTexto(comentario);
		
		Noticia noticia = noticiaDAO.findOne(id_noticia);
		Usuario usuario = usuarioDAO.findOne(id_usuario);
		
		List<Comentario> comentarios = new ArrayList<>();
		comentarios.add(c);
		noticia.setComentarios(comentarios);
		
		usuario.setComentarios(comentarios);
		
		c.setUsuario(usuario);
		c.setNoticia(noticia);
		
		c.setAtivo(true);
		comentarioDAO.save(c);
		
		return "comentario/comentario_inserido_ok";
		
	}
	
	@RequestMapping("/apagarComentario")
	public String ApagarComentario(Long id, HttpSession session, Model model){
		
		Comentario comentario = comentarioDAO.findOne(id);
		comentario.setAtivo(false);
		
		Noticia noticia = noticiaDAO.findOne(comentario.getId_noticia());
		model.addAttribute("noticia",noticia);
		
		session.getAttribute("usuario_logado");
		
		List<Comentario> comentarios = comentarioDAO.findComentarioByNoticia(noticia);
		model.addAttribute("comentarios", comentarios);
		
		session.getAttribute("usuario_logado");
		
		
		comentarioDAO.save(comentario);
		
		return "noticia/ler_noticia_completa";
	}
	
}
