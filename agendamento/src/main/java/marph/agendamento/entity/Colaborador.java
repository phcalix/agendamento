package marph.agendamento.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "colaborador")
public class Colaborador extends Pessoa {
	
	@ManyToMany
	private List<Servico> servicos;
	
	public Colaborador() {
		// TODO Auto-generated constructor stub
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
}
