package carritodecompras.java;

public class DescuentoFijo extends Descuento{
	

	public double montoFinal(double montoInicial){
		return montoInicial - this.getValoresDesc();
		
	}

	private double getValoresDesc() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected double valorFinal(double monto) {
		// TODO Auto-generated method stub
		return 0;
	}

}