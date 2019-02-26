package marph.agendamento.repository;

import org.springframework.data.repository.CrudRepository;
import marph.agendamento.entity.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {}