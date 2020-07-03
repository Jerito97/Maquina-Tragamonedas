package controller;

import model.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Jugador;
import model.Symbol;

public class Controlador {
	private static Controlador instancia = null;
	
	private Jugador jugador;
	private boolean estaGirando = false;

	private int pozoAcumulado = 10000;


	private Symbol bell;
	private Symbol cherry;
	private Symbol lemon;
	private Symbol plum;
	private Symbol redSeven;
	private Symbol watermelon;
	
	ArrayList<Symbol> simbolosArray = new ArrayList<Symbol>();

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

		this.bell = new Symbol(0, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\bell.png");
		this.cherry = new Symbol(1, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\cherry.png");
		this.lemon = new Symbol(2, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\lemon.png");
		this.plum = new Symbol(3, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\plum.png");
		this.redSeven = new Symbol(4, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\redseven.png");
		this.watermelon = new Symbol(5, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\watermelon.png");
		
		this.simbolosArray.add(this.bell);
		this.simbolosArray.add(this.cherry);
		this.simbolosArray.add(this.lemon);
		this.simbolosArray.add(this.plum);
		this.simbolosArray.add(this.redSeven);
		this.simbolosArray.add(this.watermelon);
	}

	public int getSaldo() {
		return this.jugador.getSaldo();
	}

	public void girar() {
		if(estaGirando == false) {
			estaGirando = true;
			this.jugador.setSaldo(-5);
			this.pozoAcumulado = this.pozoAcumulado + 5;
		}
	}

	public int[] frenar() {
		estaGirando = false;

		int valSymbol1 = numeroAzar();
		int valSymbol2 = numeroAzar();
		int valSymbol3 = numeroAzar();
		int[] arr = {valSymbol1, valSymbol2, valSymbol3};

		//Despues verificamos si hay que hacer algo mas con esta funcion o no
//		chequear(valSymbol1, valSymbol2, valSymbol3);

		return arr;
	}

	public void chequear(int valSymbol1, int valSymbol2, int valSymbol3) {

		//GANAR CON LOS 3 IGUALES
		if ((valSymbol1 == valSymbol2) && (valSymbol1 == valSymbol3) ) {
			int reply = JOptionPane.showConfirmDialog(null, "GANASTE!\n Queres aceptarlo?", "", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				int wonAmnt = (valSymbol1 + 1) * 50;

				if (pozoAcumulado>=wonAmnt) {
					//HAY RECAUDACION DISPONIBLE
					pozoAcumulado = pozoAcumulado - wonAmnt;
					this.jugador.setSaldo(wonAmnt);  			
				} else {
					//NO HAY RECAUDACION DISPONIBLE
					this.jugador.setSaldo(pozoAcumulado);
					pozoAcumulado = 0;
					System.exit(0);
				}

			}
			//GANAR CON 2 IGUALES
		} else if (valSymbol1 == valSymbol2 || valSymbol1 == valSymbol3 || valSymbol2 == valSymbol3) {
			int reply2 = JOptionPane.showConfirmDialog(null, "GANASTE EL PREMIO CHICO!\n Queres aceptarlo?", "", JOptionPane.YES_NO_OPTION);
			if (reply2 == JOptionPane.YES_OPTION) {
				int wonAmnt;
				if (valSymbol1 == valSymbol2 || valSymbol1 == valSymbol3) {
					wonAmnt = (valSymbol1 + 1) * 5;
				}else {
					wonAmnt = (valSymbol2 + 1) * 5;
				}
				
				if (pozoAcumulado >= wonAmnt) {
					//HAY RECAUDACION DISPONIBLE
					pozoAcumulado = pozoAcumulado - wonAmnt;
					this.jugador.setSaldo(wonAmnt);       		
				} else {
					//NO HAY RECAUDACION DISPONIBLE
					this.jugador.setSaldo(pozoAcumulado);
					pozoAcumulado = 0;
					System.exit(0);
				}
			} 		
		}
	}

	public int getPozoAcumulado() {
		return pozoAcumulado;
	}

	public String obtenerImagen(int id) {
		String path = new String();
		for (int i = 0; i < this.simbolosArray.size(); ++i) {
			if (id == this.simbolosArray.get(i).getValue()) {
				path = this.simbolosArray.get(i).getImage();
			}
		}
		return path;
	}
	
	public void agregarCreditos(int saldoAgregado) {
		jugador.setSaldo(saldoAgregado);
	}

	private int numeroAzar() {
		Random rand = new Random();
		return rand.nextInt(5);
	}
}
