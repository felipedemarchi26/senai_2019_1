package br.senai.sc.exemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.exemplo.domain.Usuario;
import br.senai.sc.exemplo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
}
