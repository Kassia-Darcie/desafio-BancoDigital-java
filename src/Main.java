

import java.time.LocalDate;

import entities.Banco;
import entities.ContaCorrente;

public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco("Banco do Brasil", 1L);
		banco.abrirConta("Kassia", 1, LocalDate.parse("1988-08-08"));
		banco.abrirConta("Fulano", 1, LocalDate.parse("1991-05-18"));
		banco.abrirConta("Cicrano", 1, LocalDate.parse("2002-03-22"));
		banco.abrirConta("Beltrano", 1, LocalDate.parse("1975-09-28"));
		
		banco.getContas().forEach(c -> {
			System.out.println(c.getClient());
			System.out.println(c.getClient().getContaCorrente());
			if (c.getClient().getContaPoupanca() != null) {
				System.out.println("Poupança:");
				System.out.println(c.getClient().getContaPoupanca());
			}
			
		});
		
		

	}

}
