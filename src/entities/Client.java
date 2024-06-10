package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Client {
	private String nome;
	private long cpf;
	private LocalDate dataDeNascimento;
	private Conta contaCorrente;
	private Conta contaPoupanca = null;
	
	public Client(String nome, long cpf, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Conta getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Conta contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	

	public void setContaPoupanca(Conta contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	public long getCpf() {
		return cpf;
	}
	
	
	public Conta getContaPoupanca() {
		return contaPoupanca;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return cpf == other.cpf;
	}

	@Override
	public String toString() {
		return "Client [nome=" + nome + ", cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento.toString() + "]";
	}
	
	
}
