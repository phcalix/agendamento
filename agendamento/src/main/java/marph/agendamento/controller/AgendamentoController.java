package marph.agendamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import marph.agendamento.entity.Empresa;

@RestController
public class AgendamentoController {

	@GetMapping("/empresas")
	public List<Empresa> listarEmpresas() {
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas.add(new Empresa(1L, "nome 01", "descr 01"));
		empresas.add(new Empresa(2L, "nome 02", "descr 02"));
		empresas.add(new Empresa(3L, "nome 03", "descr 03"));
		
		return empresas;
	}
}
