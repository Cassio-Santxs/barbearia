package app.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Horario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHorario;

	@NotNull(message = "Informe qual será o Horário!")
	private LocalDateTime dtHorario;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idFuncionario")
	@JsonIgnoreProperties("horarios")
	@NotNull(message = "Informe um barbeiro para o horário")
	private Funcionario funcionario;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCliente")
	@JsonIgnoreProperties("horarios")
	private Cliente cliente;

	@NotNull(message = "Informe o valor do horário!")
	private double vlHorario;

	@OneToOne(mappedBy = "horario", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	public long getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(long idHorario) {
		this.idHorario = idHorario;
	}
	public LocalDateTime getDtHorario() {
		return dtHorario;
	}
	public void setDtHorario(LocalDateTime dtHorario) {
		this.dtHorario = dtHorario;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getVlHorario() {
		return vlHorario;
	}
	public void setVlHorario(double vlHorario) {
		this.vlHorario = vlHorario;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
}
