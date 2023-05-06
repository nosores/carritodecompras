package carritodecompras.java;

public class DescuentoProp extends Descuento {

	public double montoFinal(double montoInicial) {
		return montoInicial-(montoInicial * this.dameMonto());
	}

}


