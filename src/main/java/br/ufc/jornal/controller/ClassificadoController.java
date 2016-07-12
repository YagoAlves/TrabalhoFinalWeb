package br.ufc.jornal.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.jornal.interfaces.IClassificadoDAO;
import br.ufc.jornal.interfaces.IUsuarioDAO;
import br.ufc.jornal.model.Classificado;
import br.ufc.jornal.model.Usuario;

@Controller
public class ClassificadoController {
	
	@Autowired
	private IClassificadoDAO classificadoDAO; 
	
	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(Long id, Model model){
		Usuario usuario = usuarioDao.findOne(id);
		model.addAttribute("usuario",usuario);
		return "classificado/inserir_classificado_formulario";
	}
	
	@RequestMapping("/inserirClassificado")
	public String inserirClassificado( Long id, Classificado classificado){
		
		System.out.println(id);
		Usuario usuario = usuarioDao.findOne(id);
		classificado.setUsuario(usuario);
		
		List<Classificado> classificados = new ArrayList<>();
		usuario.setClassificados(classificados);
		
		Date d = new Date();
		Calendar ca = Calendar.getInstance();
		ca.set(d.getYear(), d.getMonth(), d.getDate());
		
		classificado.setData_oferta(ca);
		classificadoDAO.save(classificado);
		return "classificado/classificado_inserido_ok";
	}
	
	@RequestMapping("/listarClassificado")
	public String listarClassificado(Model model){
		List<Classificado> classificados = classificadoDAO.findAll();
		model.addAttribute("classificados", classificados);
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
