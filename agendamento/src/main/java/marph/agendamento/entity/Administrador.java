package marph.agendamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends Pessoa {
	
	@Column(name = "altera_empresa")
	private boolean alteraEmpresa;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAlteraEmpresa() {
		return alteraEmpresa;
	}

	public void setAlteraEmpresa(boolean alteraEmpresa) {
		this.alteraEmpresa = alteraEmpresa;
	}
}
