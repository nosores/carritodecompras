package carritodecompras.java;

public class Carrito_Compras {	
private int numCarrito;
private producto producto;
private int cantidad;
private double monto;
private persona persona;

public Carrito_Compras(persona per1, int numero) {
	numCarrito=numero;
	persona = per1;
	monto = 0.0;
}
public int dameNumero() {
	return numCarrito;
}
public double montoCarrito() {
	return monto;
}
public int dameCantidad() {
	return cantidad;
}
public double dameMonto() {
	return monto;
}
public producto dameProducto() {
	return producto;
}
public void verCompras() {
	System.out.println(cantidad+ "     "+producto.un_nombre()+"       "+producto.un_precio()+"         "+monto );
}


}



