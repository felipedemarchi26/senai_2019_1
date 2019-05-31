package br.senai.sc.exemplo.repositories;

import org.springframework.data.repository.CrudRepository;

import br.senai.sc.exemplo.domain.Matricula;

public interface MatriculaRepository extends 
	CrudRepository<Matricula, Long>{

}
