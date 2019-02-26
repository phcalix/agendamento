package marph.agendamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import marph.agendamento.entity.Empresa;
import marph.agendamento.repository.EmpresaRepository;

@RestController
public class AgendamentoController {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping("/empresas")
	public Iterable<Empresa> listarEmpresas() {
		return empresaRepository.findAll();
	}
	
	@GetMapping("/empresa/{idEmpresa}")
	public Optional<Empresa> obterEmpresa(@PathVariable Long idEmpresa) {
		return empresaRepository.findById(idEmpresa);
	}
}
