package carritodecompras.java;

public class producto {
	private int codigo;
	private String nombre;
	private String desc;
	private double precio;
	private int stock;

	
	
	//creo el metodo constructor
	public producto(int cod, String nom, String descripcion, double prec, int stc) {
		codigo = cod;
		nombre = nom;
		desc = descripcion;
		precio = prec;
		stock = stc;	
		
	}
	// metodos getters para acceder a los valores de los atributos
	public int un_codigo() {
		return codigo;
	}
	public String un_nombre() {
		return nombre;
	}
	public String un_desc() {
		return desc;
	}
	public double un_precio() {
		return precio;
	}
	public int un_stock() {
		return stock;
	}
	public String mostrarProducto() {
		return "cod: "+codigo+" Nombre: "+nombre+" Precio: "+precio;
	}

}



