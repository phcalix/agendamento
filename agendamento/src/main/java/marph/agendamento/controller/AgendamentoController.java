package marph.agendamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import marph.agendamento.entity.Colaborador;
import marph.agendamento.entity.Empresa;
import marph.agendamento.entity.Filial;
import marph.agendamento.repository.ColaboradorRepository;
import marph.agendamento.repository.EmpresaRepository;
import marph.agendamento.repository.FilialRepository;

@RestController
public class AgendamentoController {
	
	@Autowired private EmpresaRepository empresaRepository;
	@Autowired private FilialRepository filialRepository;
	@Autowired private ColaboradorRepository colaboradorRepository;

	// EMPRESA
	@GetMapping("/empresas")
	public ResponseEntity<Iterable<Empresa>> listaEmpresas() {
		return new ResponseEntity<Iterable<Empresa>>(empresaRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/empresa/{codigoEmpresa}")
	public ResponseEntity<Empresa> obtemEmpresa(@PathVariable("codigoEmpresa") Long codigoEmpresa) {
		Optional<Empresa> empresa = empresaRepository.findById(codigoEmpresa);
		
		if(empresa == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Empresa>(empresa.get(), HttpStatus.OK);
	}
	
	@PostMapping("/empresa/nova")
	public ResponseEntity<HttpStatus> inserirEmpresa(@RequestBody Empresa empresa) {
		try {
			empresaRepository.save(empresa);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// FILIAL
	@GetMapping("/filiais")
	public Iterable<Filial> listaFiliais() {
		return filialRepository.findAll();
	}
	
	@GetMapping("/filial/{codigoFilial}")
	public ResponseEntity<Filial> obtemFilial(@PathVariable("codigoFilial") Long codigoFilial) {
		Optional<Filial> filial = filialRepository.findById(codigoFilial);
		
		if(filial == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Filial>(filial.get(), HttpStatus.OK);
	}
	
	@PostMapping("/filial/nova/para/empresa")
	public ResponseEntity<HttpStatus> inserirFilialPorEmpresa(@PathVariable("codigoEmpresa") Long codigoEmpresa, 
			@RequestBody Filial filial) {
		
		Optional<Empresa> empresa = empresaRepository.findById(codigoEmpresa);
		
		if(empresa == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			Empresa empr = empresa.get();
			empr.getFiliais().add(filial);
			empresaRepository.save(empr);
			
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	// COLABORADOR
	@GetMapping("/colaboradores")
	public Iterable<Colaborador> listaColaboradores() {
		return colaboradorRepository.findAll();
	}
	
	@GetMapping("/colaborador/{codigoColaborador}")
	public ResponseEntity<Colaborador> obtemColaborador(@PathVariable("codigoColaborador") Long codigoColaborador) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(codigoColaborador);
		
		if(colaborador == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Colaborador>(colaborador.get(), HttpStatus.OK);
	}
	
	@PostMapping("/colaborador/nova/para/filial")
	public ResponseEntity<HttpStatus> inserirFilialPorEmpresa(@PathVariable("codigoFilial") Long codigoFilial, 
			@RequestBody Colaborador colaborador) {
		
		Optional<Filial> filial = filialRepository.findById(codigoFilial);
		
		if(filial == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			Filial fll = filial.get();
			fll.getColaboradores().add(colaborador);
			filialRepository.save(fll);
			
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
}