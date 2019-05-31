package br.senai.sc.exemplo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sc.exemplo.domain.Usuario;

public interface UsuarioRepository extends 
	CrudRepository<Usuario, Long> {
	
	Optional<Usuario> findByCpf(String cpf);
	
	@Query(value="SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> buscarPorEmail(@Param("email") String email);

}
