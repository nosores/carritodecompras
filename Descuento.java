package carritodecompras.java;

public abstract class Descuento {
		private double montoDesc;
		
		public double dameMonto() {
			return montoDesc;
		}
		public void asignaMonto(double montoFijo) {
			montoDesc = montoFijo;
		}
	
	public abstract double montoFinal(double montoInicial);
	public void setValorDesc(double d) {
		// TODO Auto-generated method stub
	}
	protected abstract double valorFinal(double monto);

}
