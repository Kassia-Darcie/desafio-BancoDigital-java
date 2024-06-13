package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaPoupanca extends Conta{
	private int diasParaResgate = 1;
	private double taxaDeJuros = 0.05;

	public ContaPoupanca(int agencia, Client client) {
		super(agencia, SEQUENTIAL++);
		this.client = client;
	}
	

	@Override
	public double getSaldo() {
		return super.getSaldo() + getSaldo() * taxaDeJuros;
	}


	@Override
	public void sacar(double valor) {
		LocalDateTime dataDeResgate = this.getDataDeCriacao().plusDays(diasParaResgate);
		LocalDateTime dataAtual = LocalDateTime.now();
		if (dataAtual.isAfter(dataDeResgate) || dataAtual.isEqual(dataDeResgate)) {
			super.sacar(valor);
		} else {
			System.out.println("Só é possivel sacar a partir de: " + dataDeResgate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
		}
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("==== Extrato Conta Poupança ====");
		super.imprimirExtrato();
	}
	
	

}
