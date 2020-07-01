package models;

public class Symbol implements ISymbol {

	int value;
	String imgPath;

	@Override
	public String getImage() {
		return imgPath;
	}

	@Override
	public void setValue(int v) {
		value = v;
	}

	@Override
	public int getValue() {
		return value;
	}
}
