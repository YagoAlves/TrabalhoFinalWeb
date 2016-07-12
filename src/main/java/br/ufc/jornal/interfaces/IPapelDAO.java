package br.ufc.jornal.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Papel;

public interface IPapelDAO extends JpaRepository<Papel, Long>{
	
}
