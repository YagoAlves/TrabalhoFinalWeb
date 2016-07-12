package br.ufc.jornal.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Comentario;
import br.ufc.jornal.model.Noticia;

public interface IComentarioDAO extends JpaRepository<Comentario, Long>{
	
	List<Comentario> findComentarioByNoticia(Noticia noticia);
	

}
