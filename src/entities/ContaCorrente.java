package entities;

public class ContaCorrente extends Conta {
			

	public ContaCorrente(int agencia, Client client) {
		super(agencia, SEQUENTIAL++);
		this.client = client;
	}
	
	public void tranferir(double valor, Conta contaDestino) {
		sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("==== Extrato Conta Corrente ====");
		super.imprimirExtrato();
	}
	
	

}
