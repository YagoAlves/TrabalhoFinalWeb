package br.ufc.jornal.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Comentario;;

public interface IComentarioDAO extends JpaRepository<Comentario, Long>{

}
