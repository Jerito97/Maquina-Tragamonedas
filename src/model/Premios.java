package model;

import java.util.ArrayList;
import java.util.Random;

public class Premios {
	private String nombre;
	private int montoPremio;
	
	private Symbol bell;
	private Symbol cherry;
	private Symbol lemon;
	private Symbol plum;
	private Symbol redSeven;
	private Symbol watermelon;
	
	private ArrayList<Integer> listaPremios;
	
	
	public Premios() {
		listaPremios = new ArrayList<Integer>();
		ArrayList<Integer> frutas = new ArrayList<Integer>();
		frutas.add(0);
		frutas.add(1);
		frutas.add(2);
		frutas.add(3);
		frutas.add(4);
		frutas.add(5);
		
		Random numero = new Random();
		
		int iguales = numero.nextInt(frutas.size());
		for (int i = 0; i < 3; i++) {
			this.listaPremios.add(iguales);
		}
	}
	
	public Premios(int montoPremio, ArrayList<Integer>listaPremios) {
		this.listaPremios = listaPremios;
		this.montoPremio = montoPremio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre() {
		
	}
	
	public int getMonto() {
		return montoPremio;
	}
	
	public void setMonto() {
		
	}
	
}
