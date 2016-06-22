package br.ufc.jornal.teste;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufc.jornal.interfaces.INoticiaDAO;
import br.ufc.jornal.model.Noticia;

public class teste {

	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Noticia teste");
		noticia.setSubtitulo("Subtitulo teste ");
		noticia.setTexto("Subtitulo teste");
		//noticia.setId_secao(1);
	
	}

}
