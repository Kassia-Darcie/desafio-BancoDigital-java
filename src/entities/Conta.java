package entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

public abstract class Conta {
	protected static int SEQUENTIAL = 1;
	private int agencia;
	private int numero;
	private double saldo = 0.0;
	protected Client client;
	private Instant dataDeCriacao;
	
	public Conta(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;		
		this.dataDeCriacao = Instant.now();
	}
	
	

	public double getSaldo() {
		return saldo;
	}



	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public Client getClient() {
		return client;
	}

	public LocalDateTime getDataDeCriacao() {
		return LocalDateTime.ofInstant(dataDeCriacao, ZoneId.systemDefault());
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void sacar(double valor) {
		if (valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	public void imprimirExtrato() {
		System.out.println("Titular: " + client.getNome());
		System.out.println("Agência: " + agencia);
		System.out.println("Número da conta: " + numero);
		System.out.printf("Saldo: R$ %.2f\n", saldo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return agencia == other.agencia && numero == other.numero;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conta [agencia=");
		builder.append(agencia);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append(", client=");
		builder.append(client.getNome());
		builder.append("]");
		return builder.toString();
	}

	

	
	
	
	
	
}
