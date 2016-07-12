package br.ufc.jornal.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.jornal.model.Classificado;

public interface IClassificadoDAO extends JpaRepository<Classificado, Long>{

}
