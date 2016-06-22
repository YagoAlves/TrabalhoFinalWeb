package br.ufc.jornal.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Noticia;

public interface INoticiaDAO extends JpaRepository<Noticia, Long> {

}
