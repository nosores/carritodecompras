package carritodecompras.java;

import carritodecompras.java.carrito;

public class ItemCarrito {
	private carrito carro;
	private producto prod;
	private int cant;
	private double montoItem;

	
	
	public ItemCarrito(carrito num,producto p, int cant ) {
		carro = num;
		prod = p;
		this.cant = cant;
		montoItem = prod.un_precio() * cant;

	}
	public ItemCarrito(Carrito_Compras carr1, producto[] cargaProducto, int i, int j) {
		// TODO Auto-generated constructor stub
	}
	public int dameCant() {
		return cant;
	}
	public double dameMontoItem() {
		return montoItem;
	}
	public int dameproducto() {
		return prod.un_codigo();
	}
	public void mostrarItems() {
		System.out.println(cant+"\t"+prod.un_precio()+"\t"+montoItem);
		
	}
	public void mostrarItemTitulo() {
		System.out.println("Carro num : "+carro.dameNum());
		System.out.println("Cant:\tPrecio:\tSub total:\tProd:");
	}

}