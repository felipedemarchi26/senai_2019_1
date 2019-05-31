package br.senai.sc.exemplo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.exemplo.domain.Matricula;
import br.senai.sc.exemplo.domain.Usuario;
import br.senai.sc.exemplo.exceptions.CustomRuntimeException;
import br.senai.sc.exemplo.repositories.MatriculaRepository;
import br.senai.sc.exemplo.ws.MatriculaWs;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Matricula salvar(MatriculaWs matriculaWs) {
		Matricula matricula = this.parseMatriculaWsToMatricula(matriculaWs);			
		matricula = this.matriculaRepository.save(matricula);
		return matricula;
	}
	
	private Usuario obterUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarPorId(idUsuario);
		if (usuario == null) {
			throw new CustomRuntimeException("usuario", "Usuário não encontrado!");
		}
		return usuario;
	}
	
	private Matricula parseMatriculaWsToMatricula(MatriculaWs matriculaWs) {
		Usuario usuario = this.obterUsuario(matriculaWs.getIdUsuario());
		Matricula matricula = new Matricula();
		matricula.setDataMatricula(new Date());
		matricula.setIdMatricula(matriculaWs.getIdMatricula());
		matricula.setUsuario(usuario);
		matricula.setValorMatricula(matriculaWs.getValorMatricula());
		return matricula;
	}
	
}
