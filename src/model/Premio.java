package model;

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
	
	public boolean isPrize() {
		
		return true;
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
