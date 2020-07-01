package controller;

import models.*;

import javax.swing.JOptionPane;

public class Controlador {
	private static Controlador instancia = null;
	private Jugador jugador;
	private boolean estaGirando = false;

	private Symbol bell;
	private Symbol cherry;
	private Symbol lemon;
	private Symbol plum;
	private Symbol redSeven;
	private Symbol watermelon;

	private Controlador(int saldoIngresado) {
		inicializarObjetos(saldoIngresado);
	}

	public static Controlador miInstancia(int saldoIngresado) {
		if (instancia == null) {
			instancia = new Controlador(saldoIngresado);
		}
		return instancia;
	}

	private void inicializarObjetos(int saldoIngresado) {
		this.jugador = new Jugador(saldoIngresado);
		
		this.bell = new Symbol(0, "Trabajo/src/images/bell.png");
		this.cherry = new Symbol(1, "Trabajo/src/images/cherry.png");
		this.lemon = new Symbol(2, "Trabajo/src/images/lemon.png");
		this.plum = new Symbol(3, "Trabajo/src/images/plum.png");
		this.redSeven = new Symbol(4, "Trabajo/src/images/redseven.png");
		this.watermelon = new Symbol(5, "Trabajo/src/images/watermelon.png");
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
