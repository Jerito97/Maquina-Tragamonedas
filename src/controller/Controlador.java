package controller;

import model.*;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Jugador;
import model.Symbol;
import modelView.PremioView;

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
	private Symbol noAplica;

	ArrayList<Symbol> simbolosArray = new ArrayList<Symbol>();
	ArrayList<Premio> premiosArray = new ArrayList<Premio>();

	private Controlador(int saldoIngresado) {
		inicializarObjetos(saldoIngresado);
		agregarPremiosDefault();
	}

	public static Controlador miInstancia(int saldoIngresado) {
		if (instancia == null) {
			instancia = new Controlador(saldoIngresado);
		}else {
			instancia.jugador.setSaldoInicial(saldoIngresado);
		}
		return instancia;
	}

	private void inicializarObjetos(int saldoIngresado) {
		this.jugador = new Jugador(saldoIngresado);

		this.bell = new Symbol("Campana", 0, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\bell.png");
		this.cherry = new Symbol("Cherry", 1, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\cherry.png");
		this.lemon = new Symbol("Limon", 2, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\lemon.png");
		this.plum = new Symbol("Ciruela", 3, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\plum.png");
		this.redSeven = new Symbol("Siete Rojo", 4, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\redseven.png");
		this.watermelon = new Symbol("Melon", 5, "C:\\Users\\Jero\\Desktop\\UADE\\IOO\\GitHub\\Maquina-Tragamonedas\\src\\images\\watermelon.png");
		this.noAplica = new Symbol("N/A", -1, "N/A");
		
		this.simbolosArray.add(this.bell);
		this.simbolosArray.add(this.cherry);
		this.simbolosArray.add(this.lemon);
		this.simbolosArray.add(this.plum);
		this.simbolosArray.add(this.redSeven);
		this.simbolosArray.add(this.watermelon);
	}

	public void agregarPremiosDefault() {
		premiosArray.add(new Premio(bell, noAplica, noAplica, 50));
		premiosArray.add(new Premio(plum, plum, plum, 100));
		premiosArray.add(new Premio(bell, bell, noAplica, 150));
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
		return arr;
	}

	public int chequear(int valSymbol1, int valSymbol2, int valSymbol3) {
		int montoPremio = 0;
		
		for (int i = 0; i < this.premiosArray.size(); ++i) {
			boolean status = this.premiosArray.get(i).isPrize(valSymbol1, valSymbol2, valSymbol3);
			if (status) {
				montoPremio = this.premiosArray.get(i).getMonto();
			}
		}
		return montoPremio;
		/*
		if (montoPremio > 0) {
			int reply = JOptionPane.showConfirmDialog(null, "GANASTE!\n Queres aceptarlo?", "", JOptionPane.YES_NO_OPTION);
			
			if (reply == JOptionPane.YES_OPTION) {
				if (pozoAcumulado >= montoPremio) {
					//Se paga todo el premio
					pozoAcumulado = pozoAcumulado - montoPremio;
					this.jugador.setSaldo(montoPremio);
				} else {
					//El pozo acumulado no es suficiente para pagar toda la ganancia
					this.jugador.setSaldo(pozoAcumulado);
					JOptionPane.showConfirmDialog(null, "La maquina se quedo sin dinero! Solamente ganaras: " + pozoAcumulado, "Sin Dinero!", JOptionPane.YES_NO_OPTION);
					pozoAcumulado = 0;
				}
			}
		}
		*/
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
		return rand.nextInt(6);
	}
	
	public void addPremio(int monto, int valor1, int valor2, int valor3) {
		Premio premio = new Premio(getSymbol(valor1), getSymbol(valor2), getSymbol(valor3), monto);
		premiosArray.add(premio);
	}
	
	private Symbol getSymbol(int id) {
		Symbol simbolo = null;
		for (int i = 0; i < this.simbolosArray.size(); ++i) {
			if (id == this.simbolosArray.get(i).getValue()) {
				simbolo = this.simbolosArray.get(i);
			}
		}
		
		if (simbolo == null) {
			simbolo = this.noAplica;
		}
		return simbolo;
	}
	
	public void eliminarPremio(int posicion) {
		premiosArray.remove(posicion);
	}
	
	public ArrayList<PremioView> getPremios() {
		ArrayList<PremioView> viewArray = new ArrayList<PremioView>();
		for (int i = 0; i < this.premiosArray.size(); ++i) {
			String uno = this.premiosArray.get(i).nombre1();
			String dos = this.premiosArray.get(i).nombre2();
			String tres = this.premiosArray.get(i).nombre3();
			int monto = this.premiosArray.get(i).getMonto();
			PremioView view = new PremioView(monto, uno, dos, tres);
			viewArray.add(view);
		}
		return viewArray;
	}
	
	public void aceptarPremio(int monto) {
		if (pozoAcumulado >= monto) {
			//Se paga todo el premio
			pozoAcumulado = pozoAcumulado - monto;
			this.jugador.setSaldo(monto);
		} else {
			//El pozo acumulado no es suficiente para pagar toda la ganancia
			this.jugador.setSaldo(pozoAcumulado);
			pozoAcumulado = 0;
		}
	}
}
