package entities;

public class ContaCorrente extends Conta {
	private static int SEQUENTIAL = 1;		

	public ContaCorrente(int agencia, Client client) {
		super(agencia, SEQUENTIAL++);
		this.client = client;
	}

}
