package carritodecompras.java;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import carritodecompras.java.carrito;
import carritodecompras.java.cliente;
import carritodecompras.java.producto;

public class ComprasListaColecciones {
	public static void main(String[] args) {
		try {
		

	
			Connection cX = DriverManager.getConnection("jdbc:mysql://localhost:3306/comprascarritobasededatos","root","");
			Statement sT = cX.createStatement();
			String consultacliente = "select * from clientes";
			ResultSet sqlclientes = sT.executeQuery(consultacliente);
			
			System.out.println("CODIGO\tDNI\tNOMBRE Y APELLcodigoO\tDIRECCION");
			while (sqlclientes.next()) {
				System.out.println(sqlclientes.getInt(1)+"\t"+sqlclientes.getInt(2)+"\t"+sqlclientes.getString(3)+"\t"+sqlclientes.getString(4));		
			}
			
			Scanner codigo = new Scanner(System.in);
			System.out.println("SELECCIONE UN CODIGO DE cliente");
			int cod=codigo.nextInt();
			
			consultacliente = String.format("select * from clientes where codigoC = %s",cod);
			sqlclientes = sT.executeQuery(consultacliente);
			int codigoC=0,dniC=0;
			String nomC="",direC="";
			while(sqlclientes.next()) {
				codigoC = sqlclientes.getInt(1);
				dniC = sqlclientes.getInt(2);
				nomC = sqlclientes.getString(3);
				direC = sqlclientes.getString(4);
				
			}
					
			cliente c1 = new cliente(codigoC,dniC,nomC,direC);
			
			System.out.println("\n\t\t INGRESE EL NUMERO DELcarrito:  ");
			int numCA = codigo.nextInt();		
			carrito carro1 = new carrito(c1,numCA);

					
		
			producto p1 = new producto(cod, "Atum", direC, 150.3,001);
			producto p2 = new producto(cod, "Mermelada", direC, 215.3 ,002);
			producto p3 = new producto(cod, "Leche",direC, 190.8,003);
			producto p4 = new producto(cod, "Pan",direC, 200.5,004);
			producto p5 = new producto(cod, "Aceite",direC, 450.3,005);
			producto p6 = new producto(cod, "Manteca",direC, 315.3,006);
			producto p7 = new producto(cod, "Azucar",direC, 290.8,007);
			producto p8 = new producto(cod, "Pollo",direC, 800.5,010);
			
			ItemCarrito item1 = new ItemCarrito(carro1,p1,3);
			ItemCarrito item2 = new ItemCarrito(carro1,p3,2);
			ItemCarrito item3 = new ItemCarrito(carro1,p2,5);
			ItemCarrito item4 = new ItemCarrito(carro1,p4,3);
			ItemCarrito item5 = new ItemCarrito(carro1,p5,1);
			ItemCarrito item6 = new ItemCarrito(carro1,p6,1);
			ItemCarrito item7 = new ItemCarrito(carro1,p7,2);
			ItemCarrito item8 = new ItemCarrito(carro1,p8,2);
		
			List<ItemCarrito> item;
			item = new ArrayList<ItemCarrito>();
			item.add(item1);
			item.add(item2);
			item.add(item3);
			item.add(item4);
			item.add(item5);
			item.add(item6);
			item.add(item7);
			item.add(item8);
					
		
			System.out.println("cliente: "+c1.dameNombre());
			item4.mostrarItemTitulo();
			Iterator<ItemCarrito> iterador = item.iterator();										                                         	
					

			while (iterador.hasNext()) {
			ItemCarrito items = iterador.next();		
			items.mostrarItems();
			
			carro1.sumarMonto(items);
			
			}
			System.out.println("\nTotal: "+String.format("%.2f",carro1.dameMontoTotal()));

			Descuento dFijo = new DescuentoFijo();
			dFijo.asignaMonto(100);
			System.out.println("MontoTotal con descuento: "
			+ String.format("%.2f",dFijo.montoFinal(carro1.dameMontoTotal())));
			LocalDate fecha = LocalDate.now();
			
			//cargar la tablacarrito
			String insertCarrito = "insert intocarrito (codigoCA,numCA,codigoC,montoCA,descuCA,fechaCA) values(codigoCA,?,?,?,?,?)";
			PreparedStatement sqlPS = cX.prepareStatement(insertCarrito);
			
			sqlPS.setInt(1,carro1.dameNum());
			sqlPS.setInt(2,c1.damecodigo());
			sqlPS.setDouble(3,carro1.dameMontoTotal());
			sqlPS.setDouble(4,dFijo.montoFinal(carro1.dameMontoTotal()));
			sqlPS.setString(5, fecha.toString());
			
			
			sqlPS.executeUpdate();
		
			
			codigo.close();
			cX.close();
			
		}catch(Exception obj) {
			System.out.println("Error en la conexion");
			System.out.println(obj.fillInStackTrace());
		}			
		}
	}


	