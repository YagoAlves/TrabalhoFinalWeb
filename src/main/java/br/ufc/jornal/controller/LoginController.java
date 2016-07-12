package br.ufc.jornal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.criptografia.Criptografia;
import br.ufc.jornal.interfaces.IClassificadoDAO;
import br.ufc.jornal.interfaces.INoticiaDAO;
import br.ufc.jornal.interfaces.IPapelDAO;
import br.ufc.jornal.interfaces.ISecaoDAO;
import br.ufc.jornal.interfaces.IUsuarioDAO;
import br.ufc.jornal.model.Classificado;
import br.ufc.jornal.model.Noticia;
import br.ufc.jornal.model.Papel;
import br.ufc.jornal.model.Secao;
import br.ufc.jornal.model.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	private ISecaoDAO secaoDAO;
	
	@Autowired
	private IPapelDAO papelDao;
	
	
	@Autowired
	private INoticiaDAO noticiaDAO;
	
	@Autowired
	private IClassificadoDAO classificadoDAO;
	
	
	@RequestMapping("/efetuarLogin")
	public String inserirLoginFormulario(Model model){
		List<Papel> papeis = papelDao.findAll();
		model.addAttribute("papeis", papeis);
		return "usuario/login_formulario";

	}
	
	@RequestMapping("/autenticarLogin")
	public String autenticarLogin (Usuario usuario, Long id, HttpSession session, Model model) {
		
		List<Noticia> noticias = noticiaDAO.findNoticiaByAtivoTrue();
		session.setAttribute("noticias",noticias);
		
		List<Classificado> classificados = classificadoDAO.findAll();
		session.setAttribute("classificados", classificados);
		
		List<Secao> secoes = secaoDAO.findByAtivoTrue();
		session.setAttribute("secoes", secoes);
		
		if (usuario.getLogin().equals("admin") && usuario.getSenha().equals("admin")) {
			return "admin";
		}
		
		Papel papel = papelDao.findOne(id);
		String senha = Criptografia.criptografar(usuario.getSenha());
		Usuario u = usuarioDAO.findByLoginAndSenha(usuario.getLogin(), senha);
		if (u == null) return "usuario/login_formulario";
		
		for (int i=0; i< u.getPapeis().size(); i++) {
			if (papel.getPapel().equals(u.getPapeis().get(i).getPapel())) {
				session.setAttribute("usuario_logado", u);
				session.setAttribute("papel", papel);
				if(papel.getPapel().equals("Usuario")) return "usuario/usuario_logado";
				if(papel.getPapel().equals("Editor")) return "editor/visao_editor";
				if(papel.getPapel().equals("Jornalista")) return "jornalista/visao_jornalista";
			}
		}
		
		return "redirect:efetuarLogin";
	}
	
	@RequestMapping("/efetuarLogout")
	public String efetuarLogout(HttpSession session){
		session.getAttribute("usuario_logado");
		session.invalidate();
		return "redirect:efetuarLogin";
	}

}
