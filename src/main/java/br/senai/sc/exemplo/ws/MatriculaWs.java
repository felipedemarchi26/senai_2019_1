package br.senai.sc.exemplo.ws;

import javax.validation.constraints.NotNull;

public class MatriculaWs {

	private Long idMatricula;
	
	private Double valorMatricula;
	
	@NotNull(message="É obrigatório informar o usuário que está se matriculando!")
	private Long idUsuario;

	public Long getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Double getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(Double valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
