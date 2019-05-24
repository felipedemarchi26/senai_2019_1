package br.senai.sc.exemplo.repositories;

import org.springframework.data.repository.CrudRepository;

import br.senai.sc.exemplo.domain.Usuario;

public interface UsuarioRepository extends 
	CrudRepository<Usuario, Long>{

}
