
public class Ingreso extends Dinero{
	
	public Ingreso (double ingreso, String description) {
		this.dinero=ingreso;
		this.description=description;
	}
	
	@Override
	public String toString() {
		return "Ingreso en concepto de " + this.description + ". Por un importe de: " + this.dinero;
		
	}

}
