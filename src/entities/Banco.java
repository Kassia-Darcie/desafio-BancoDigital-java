package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Banco {
	private String nome;
	private long agencia;
	private Set<Conta> contas = new HashSet<>();
	
	
	
	public Banco(String nome, long agencia) {
		this.nome = nome;
		this.agencia = agencia;
	}
	



	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public Set<Conta> getContas() {
		return contas;
	}




	// todo
	public void abrirConta(String nome, long cpf, LocalDate dataDeNascimento) {
		Client client = new Client(nome, cpf, dataDeNascimento);
		Conta conta = new ContaCorrente(1, client);
		client.setContaCorrente(conta);
		contas.add(conta);
	}
}
