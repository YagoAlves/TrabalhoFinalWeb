package br.ufc.jornal.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.jornal.model.Papel;
import br.ufc.jornal.model.Usuario;

public class Interceptador extends HandlerInterceptorAdapter{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,  HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_logado");
		Papel papel = null;
		
		if(request.getSession().getAttribute("papel") != null){
			papel = (Papel) request.getSession().getAttribute("papel");
		}
		
		if(usuario != null){
			
			if(uri.endsWith("/") ||  uri.endsWith("inserirUsuarioFormulario") 
			   || uri.endsWith("efetuarLogin") ||  uri.endsWith("logout") 
			   || uri.endsWith("adicionarOferta") || uri.endsWith("autenticarLogin") 
			   || uri.endsWith("listarPorSecao") || uri.endsWith("lerNoticiaCompleta")
			   || uri.endsWith("lerClassificadoCompleto")) {
				return true;
			}
			
			if(papel.getId() == 1){
				if(uri.endsWith("inserirNoticiaFormulario") || 
				   uri.endsWith("inserirNoticia") ||  
				   uri.endsWith("apagarNoticia")) {
					return true;
				}
			}else if(papel.getId() == 2){
				if(uri.endsWith("inserirUsuario") ||
				   uri.endsWith("lerClassificadoCompleto") ||
				   uri.endsWith("inserirOferta") ||
				   uri.endsWith("inserirComentario")){
					return true;
				}
				
				if(uri.endsWith("inserirSecaoFormulario") ||
				   uri.equals("inserirClassificadoFormulario")	||
				   uri.endsWith("inserirJornalistaFormulario") ||
				   uri.endsWith("listarSecao")){
					return true;
				}
			}else{
				if(uri.endsWith("gerenciarNoticias") || uri.endsWith("desabilitarNoticia") || uri.endsWith("inserirNovaNoticia")){
					return true;
				}
			}
			response.sendRedirect("/login_formulario");
			return false;
		}
		response.sendRedirect("/");
		return false;
	}
		

}
