package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Banco  {
	private String nome;
	private int agencia;
	private Set<Conta> contas = new HashSet<>();
	
	
	
	public Banco(String nome, int agencia) {
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
	
	private Client cadastrarCliente(String nome, long cpf, LocalDate dataDeNascimento) throws RuntimeException {
		Client client = new Client(nome, cpf, dataDeNascimento);
		List<Long> cpfsCadastradosList = obterListadeClientes().stream()
				.map(c -> c.getCpf())
				.toList();
		if (cpfsCadastradosList.contains(cpf)) {
			throw new RuntimeException("CPF já cadastrado");
		}
		return client;
	}


	public void abrirConta(String nome, long cpf, LocalDate dataDeNascimento) throws RuntimeException {
			Client client = cadastrarCliente(nome, cpf, dataDeNascimento);
			Conta conta = new ContaCorrente(agencia, client);
			client.setContaCorrente(conta);
			contas.add(conta);
	}
	
	public void abrirContaPoupanca(long cpf) {
		try {
			Client client = buscarClientePeloCpf(cpf);
			ContaPoupanca poupanca = new ContaPoupanca(agencia, client);
			client.setContaPoupanca(poupanca);
			contas.add(poupanca);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Client> obterListadeClientes() {
		List<Client> listaDeClientes = contas.stream()
				.map(c -> c.getClient())
				.distinct()
				.toList();
		return listaDeClientes;		
	}
	
	public Client buscarClientePeloCpf(long cpf) {
		Optional<Client> client = obterListadeClientes().stream()
				.filter(c -> c.getCpf() == cpf)
				.findFirst();
		return client.orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
	}
	
	public Conta buscarConta(int agencia, int numero) {
		Optional<Conta> conta = contas.stream().filter(c -> c.getAgencia() == agencia && c.getNumero() == numero)
				.findFirst();
		return conta.orElseThrow(() -> new RuntimeException("Conta não encontrada."));
	}
	
	public void transferirEntreContas(double valor, long cpf, int agenciaDestino, int numeroDestino) {
		ContaCorrente remetente = (ContaCorrente) buscarClientePeloCpf(cpf).getContaCorrente(); 
		Conta destino = buscarConta(agenciaDestino, numeroDestino);
		remetente.transferir(valor, destino);
		
	}
}
