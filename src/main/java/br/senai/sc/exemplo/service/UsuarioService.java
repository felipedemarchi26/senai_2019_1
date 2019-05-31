package br.senai.sc.exemplo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.exemplo.domain.Usuario;
import br.senai.sc.exemplo.exceptions.CustomRuntimeException;
import br.senai.sc.exemplo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findByCpf(usuario.getCpf());
		if (usuarioOptional.isPresent()) {
			throw new CustomRuntimeException("cpf", "CPF já cadastrado!");
		}
		usuarioOptional = this.usuarioRepository.buscarPorEmail(usuario.getEmail());
		if (usuarioOptional.isPresent()) {
			throw new CustomRuntimeException("email", "E-mail já cadastrado!");
		}
		return this.usuarioRepository.save(usuario);
	}
	
	public Usuario buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("id", "Não foi informado um ID para consulta!");
		}
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}
	
	public Iterable<Usuario> buscarTodos() {
		return this.usuarioRepository.findAll();
	}
	
}
