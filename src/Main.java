

import java.time.LocalDate;

import entities.Banco;
import entities.ContaCorrente;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco("Banco do Brasil", 1);
		banco.abrirConta("Kassia", 1, LocalDate.parse("1988-08-08"));
		banco.abrirConta("Fulano", 2, LocalDate.parse("1991-05-18"));
		banco.abrirConta("Cicrano", 3, LocalDate.parse("2002-03-22"));
		banco.abrirConta("Beltrano", 4, LocalDate.parse("1975-09-28"));
		
		banco.abrirContaPoupança(1);
		banco.getContas().forEach(c -> System.out.println(c));
		
		banco.obterListadeClientes().forEach(c -> {
			System.out.println("Client: " + c.getNome() + ", CPF: " + c.getCpf());
			System.out.println("Conta corrente: " + c.getContaCorrente());
			System.out.println("Conta poupança: " + c.getContaPoupanca());
			System.out.println("----------------------------\n");
		});
		
		

	}

}
