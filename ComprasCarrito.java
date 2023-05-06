package carritodecompras.java;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import carritodecompras.java.Descuento;
import carritodecompras.java.DescuentoFijo;



public class ComprasCarrito {

	private static carrito carro1;

	public static void main(String[] args) {

		producto p1 = new producto(101,"Arroz","Largo fino 0000 x 500grs.", -250.35, 0);
		producto p2 = new producto(102,"Leche","Larga vida x 1l.", -180.35, 0);
		producto p3 = new producto(103,"Azucar","bolsa x 500grs.", -125.35, 0);
		producto p4 = new producto(104,"Fideo","Largo fino 0000 x 500grs.",- 250.35, 0);
		producto p5 = new producto(105,"Cafe","Larga vida x 1l.", -180.35, 0);
		producto p6 = new producto(106,"Te","bolsa x 500grs.", -125.35, 0);
				
		cliente c1 = new cliente(101, 26638449, "Ignacio Drege","Lamadrid 2000");
		cliente c2 = new cliente(102,6412136,"Nicolas Osores","luna 888");
		cliente c3 = new cliente(103,45669874,"Lucas Moya", "Yapeyu");
		
		carrito carro1 = new carrito(c1,40);
		
		ItemCarrito item1 = new ItemCarrito(carro1,p1,3);
		ItemCarrito item2 = new ItemCarrito(carro1,p2,2);
		ItemCarrito item3 = new ItemCarrito(carro1,p3,1);
		ItemCarrito item4 = new ItemCarrito(carro1,p4,3);
		ItemCarrito item5 = new ItemCarrito(carro1,p5,2);
		ItemCarrito item6 = new ItemCarrito(carro1,p6,1);
		
		List<ItemCarrito> listaI; //declaracion 
		listaI = new ArrayList<ItemCarrito>();
		
		listaI.add(item1);
		listaI.add(item2);
		listaI.add(item3);
		listaI.add(item4);
		listaI.add(item5);
		listaI.add(item6);
		
		mostrarCompras(listaI,carro1,c1);
	}//main		
		
 
		
	

	public static void aplicarDescuento(double monto) {
		
		 final double montoMinimo = 5000;
		
		LocalDate fecha = LocalDate.now();
		int dia = fecha.getDayOfMonth();
		
		if (dia%2!=0) {
			Descuento desc1 = new DescuentoFijo();
			desc1.setValorDesc(237.1);
			double montoF = desc1.valorFinal(monto);
			if (montoF > 0)
			System.out.println("Monto del Carrito con Descuento Fijo: "+String.format("%.2f",montoF));
			else
				System.out.println("El monto no se puede aplicar");
		}
		else {
			Descuento desc2 = new DescuentoFijo();
			if(monto < montoMinimo) {
				desc2.setValorDesc(0.10);	
			}
			else
			desc2.setValorDesc(0.15);
			double montoD =desc2.valorFinal(monto); 
			if (montoD > 0)
			System.out.println("Monto del Carrito con Descuento %: "+desc2.valorFinal(montoD));
			else
				System.out.println("El monto no se puede aplicar");
		}
	}

	public static void mostrarCompras(List listaI, carrito carro1, cliente c1) {
		ComprasCarrito.carro1 = carro1;
		
		Iterator<ItemCarrito> itI = listaI.iterator();
		boolean titulo=true;
 		double monto=0;
		
		while (	itI.hasNext()) {
			ItemCarrito datos = itI.next();
			if (titulo) {
				datos.mostrarItemTitulo();
				titulo=false;
			
			}
			datos.mostrarItems();	
			monto = monto + datos.dameMontoItem();
		
			}
		carro1.dameMontoTotal();
		carro1.mostrarMontoCarrito(monto);
		if (monto > 0 ) 
		aplicarDescuento(monto);
		else
			System.out.println("El monto del carro no permite descuentos");		
			}
		
		
	
		
	}

