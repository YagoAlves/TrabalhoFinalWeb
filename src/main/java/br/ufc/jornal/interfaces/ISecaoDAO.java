package br.ufc.jornal.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Secao;

public interface ISecaoDAO extends JpaRepository<Secao, Long>{

}
