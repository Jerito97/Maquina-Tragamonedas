package model;

public class Jugador {
	int saldo;
    
    public Jugador(int saldoInicial) {
		this.saldo = saldoInicial;
	}
	
	public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldoAgregado) {
        this.saldo =  this.saldo + saldoAgregado;
    }
}
