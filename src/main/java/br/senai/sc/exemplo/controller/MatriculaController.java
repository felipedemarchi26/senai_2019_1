package br.senai.sc.exemplo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.exemplo.components.MapValidationComponent;
import br.senai.sc.exemplo.domain.Matricula;
import br.senai.sc.exemplo.service.MatriculaService;
import br.senai.sc.exemplo.ws.MatriculaWs;

@RestController
@RequestMapping("/exemplo/matricula")
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private MapValidationComponent mapValidationComponent;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid MatriculaWs matriculaWs, BindingResult result) {
		ResponseEntity<?> error = this.mapValidationComponent.mapValidationError(result);
		if (error != null) {
			return error;
		}
		Matricula matricula = this.matriculaService.salvar(matriculaWs);
		return new ResponseEntity<Matricula>(matricula, HttpStatus.OK);
	}
	
}
