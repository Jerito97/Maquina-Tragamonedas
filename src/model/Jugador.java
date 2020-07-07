package model;

public class Jugador {
	private int saldo;
    
    public Jugador(int saldoInicial) {
		this.saldo = saldoInicial;
	}
	
	public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldoAgregado) {
        this.saldo =  this.saldo + saldoAgregado;
    }
    
    public void setSaldoInicial(int saldoInicial){
    	this.saldo = saldoInicial;
    }
}
