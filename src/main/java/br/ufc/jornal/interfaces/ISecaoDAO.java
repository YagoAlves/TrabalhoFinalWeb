package br.ufc.jornal.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Secao;

public interface ISecaoDAO extends JpaRepository<Secao, Long>{
	
	public List<Secao> findByAtivoTrue ();

}
