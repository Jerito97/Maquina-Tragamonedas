package models;

public class Symbol implements ISymbol {

	int value;
	String imgPath;

//BUSCA LA IMAGEN
	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return imgPath;
	}

//PONE UN VALOR A LA FRUTA
	@Override
	public void setValue(int v) {
		// TODO Auto-generated method stub
		value = v;
	}

//DEVUELVE EL VALOR QUE SE LE DIO A LA FRUTA
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}
}
