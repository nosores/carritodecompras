package carritodecompras.java;

import carritodecompras.java.cliente;

public class carrito {
		private int num;
		private cliente cliente;
		private double montoTotal;
	
		
		public carrito(cliente cli, int num) {
			this.num = num;
			cliente = cli;
			montoTotal=0.0;
		}
		public int dameNum() {
			return num;
		}
		public double dameMontoTotal() {
			return montoTotal;
		}
		public void sumarMonto(ItemCarrito montoItem) {
			montoTotal = montoTotal + montoItem.dameMontoItem();
		}
		public String dameDatosCarro() {
			return "Carro Num: "+num + "Cliente: "+cliente.dameNombre();
		}
		public void mostrarMontoCarrito(double monto) {
			// TODO Auto-generated method stub
			
		}


	}


		


