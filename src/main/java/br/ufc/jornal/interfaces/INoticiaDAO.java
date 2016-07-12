package br.ufc.jornal.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufc.jornal.model.Noticia;
import br.ufc.jornal.model.Secao;

public interface INoticiaDAO extends JpaRepository<Noticia, Long> /*,INoticiaDAOPerso*/ {
	
	public List<Noticia> findNoticiaBySecao(Secao secao);
	
	public List<Noticia> findNoticiaByAtivoTrue ();
	
}
