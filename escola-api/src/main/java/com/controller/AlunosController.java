package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Alunos;
import com.repository.AlunosRepository;

@RestController
@RequestMapping("/api")
public class AlunosController {

	@Autowired
	private AlunosRepository alunosRep;
	
	@GetMapping("/lista")
	public List<Alunos> listaAlunos(){
		return alunosRep.findAll();
	}

	@PostMapping("/salvar")
	public Alunos salvAlunos(@Valid @RequestBody Alunos aluno) {
		return alunosRep.save(aluno);
	}

	@DeleteMapping("/exclui/{id}")
	public void excluiAluno(@PathVariable Long id) {
		alunosRep.deleteById(id);;
	}	
}
