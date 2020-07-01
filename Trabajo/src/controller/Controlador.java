package controller;

import models.*;

import javax.swing.JOptionPane;

public class Controlador {
	private static Controlador instancia = null;
	private Jugador jugador;
	private boolean estaGirando = false;
	
	private Controlador(int saldoIngresado) {
		this.jugador = new Jugador(saldoIngresado);
	}
	
	public static Controlador miInstancia(int saldoIngresado) {
		if (instancia == null) {
			instancia = new Controlador(saldoIngresado);
		}
		return instancia;
	}

	public int getSaldo() {
		return this.jugador.getSaldo();
	}
	
	public void girar() {
		if(estaGirando == false) {
			estaGirando = true;
			this.jugador.setSaldo(-5);
		}	
	}
	
	public void frenar(int valSymbol1, int valSymbol2, int valSymbol3) {
		estaGirando = false;
	}
	
	public void chequear(int valSymbol1, int valSymbol2, int valSymbol3) {
		if ((valSymbol1 == valSymbol2) && (valSymbol1 == valSymbol3) ) {
			int total = (valSymbol1 + 1) * 10;
			saldo = 
		} else if (valSymbol1 == valSymbol2 || valSymbol1 == valSymbol3 || valSymbol2 == valSymbol3) {
			
		} else {
			
		}
	}
}
