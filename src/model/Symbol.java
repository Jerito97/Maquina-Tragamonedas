package model;

public class Symbol {

	int value;
	String imgPath;

	public Symbol(int id, String path) {
		this.value = id;
		this.imgPath = path;
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
