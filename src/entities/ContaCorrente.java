package entities;

public class ContaCorrente extends Conta {
			

	public ContaCorrente(int agencia, Client client) {
		super(agencia, SEQUENTIAL++);
		this.client = client;
	}

}
