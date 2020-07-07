package modelView;

public class PremioView {
	int monto;
	String nombreElemento1;
	String nombreElemento2;
	String nombreElemento3;
	
	public PremioView(int monto, String nombre1, String nombre2, String nombre3) {
		this.nombreElemento1 = nombre1;
		this.nombreElemento2 = nombre2;
		this.nombreElemento3 = nombre3;
		this.monto = monto;
	}
	
	public int getMonto() {
		return this.monto;
	}
	
	public String getNombre1() {
		return this.nombreElemento1;
	}
	
	public String getNombre2() {
		return this.nombreElemento2;
	}
	
	public String getNombre3() {
		return this.nombreElemento3;
	}
}
