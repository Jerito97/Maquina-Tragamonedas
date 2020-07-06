package model;

public class Symbol {

	int value;
	String nombre;
	String imgPath;

	public Symbol(String nombre, int id, String path) {
		this.value = id;
		this.imgPath = path;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getImage() {
		return imgPath;
	}

	public void setValue(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}
}
