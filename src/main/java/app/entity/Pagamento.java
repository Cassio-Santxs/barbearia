package app.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pagamento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPagamento;
	
	@NotNull(message = "Informe a data do pagamento!")
	private LocalDateTime dtPagamento;
	
	@NotNull(message = "Informe o horário do pagamento!")
	@OneToOne
    @JoinColumn(name = "idHorario", referencedColumnName = "idHorario")
	private Horario horario;
	
	@ManyToOne()
	@JoinColumn(name = "idFormaPagto")
	@JsonIgnoreProperties("pagamentos")
	@NotNull(message = "Informe a forma de pagamento!")
	private FormaPagamento formaPagamento;
	
	public int getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public LocalDateTime getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(LocalDateTime dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getDsSituacao() {
		return dsSituacao;
	}

	public void setDsSituacao(String dsSituacao) {
		this.dsSituacao = dsSituacao;
	}

	@NotBlank(message = "Informe a situação do paganento!")
	private String dsSituacao;
}
