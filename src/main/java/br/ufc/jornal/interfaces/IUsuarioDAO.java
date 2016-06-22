package br.ufc.jornal.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{

}
