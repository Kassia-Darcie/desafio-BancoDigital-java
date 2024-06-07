package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaPoupanca extends Conta{
	private static int SEQUENTIAL = 1;	
	private int diasParaResgate = 1;
	private double taxaDeJuros = 0.05;

	public ContaPoupanca() {
		super(2, SEQUENTIAL++);		
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
	
	

}
