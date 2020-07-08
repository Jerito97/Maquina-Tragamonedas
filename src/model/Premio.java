package model;

import java.util.ArrayList;

public class Premio {
	private String nombre;
	private int montoPremio;
	
	private Symbol tres;
	private Symbol dos;
	private Symbol uno;
	
	
	public Premio(Symbol simbolo1, Symbol simbolo2, Symbol simbolo3, int monto) {
		this.uno = simbolo1;
		this.dos = simbolo2;
		this.tres = simbolo3;
		this.montoPremio = monto; 
	}
	
	public boolean isPrize(int valor1, int valor2, int valor3) {
		int[] valuesArray = new int[] {valor1, valor2, valor3};
		ArrayList<Symbol> simbolosArrayValidos = new ArrayList<Symbol>();
		ArrayList<Symbol> simbolosArrayAux = new ArrayList<Symbol>();
		
		simbolosArrayValidos.add(uno);
		simbolosArrayValidos.add(dos);
		simbolosArrayValidos.add(tres);
		
		
		for (int i = 0; i < simbolosArrayValidos.size(); ++i) {
			if (simbolosArrayValidos.get(i).getValue() != -1) {
				simbolosArrayAux.add(simbolosArrayValidos.get(i));
			}
		}
		
		for (int i = 0; i < valuesArray.length; ++i) {
			int j = 0;
			while (simbolosArrayAux.size() > j && simbolosArrayAux.get(j).getValue() != valuesArray[i]) {
				j++;
			}
			if (simbolosArrayAux.size() > j) {
				simbolosArrayAux.remove(j);
			}
		}
		if (simbolosArrayAux.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getMonto() {
		return montoPremio;
	}
	
	public String nombre1() {
		return uno.getNombre();
	}
	
	public String nombre2() {
		return dos.getNombre();
	}
	
	public String nombre3() {
		return tres.getNombre();
	}
}
