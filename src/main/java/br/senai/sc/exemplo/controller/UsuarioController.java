package br.senai.sc.exemplo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.exemplo.domain.Usuario;
import br.senai.sc.exemplo.service.UsuarioService;

@RestController
@RequestMapping("/exemplo/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Usuario usuario) {
		Usuario usuarioSalvo = this.usuarioService.salvar(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}
	
}
