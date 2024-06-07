package entities;

import java.time.LocalDate;

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

	public long getCpf() {
		return cpf;
	}
	
	
	public Conta getContaPoupanca() {
		return contaPoupanca;
	}

	public void abrirContaPoupança() {
		if (contaPoupanca == null) {
			this.contaPoupanca = new ContaPoupanca();
		} else {
			throw new RuntimeException("Já existe uma conta poupança");
		}
	}

	@Override
	public String toString() {
		return "Client [nome=" + nome + ", cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento.toString() + "]";
	}
	
	
}
