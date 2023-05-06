package carritodecompras.java;

public class cliente {
	private int codigo ;
	private int dni;
	private String nombre;
	private String dire;


	//Metedo contructor
	public cliente(int codigo, int dni, String nom, String dire) {
		this.codigo = codigo;
		this.dni= dni;
		nombre = nom;
		this.dire=dire;
	}
	public int damecodigo() {
		return codigo;
	}
	public int dameDni() {
		return dni;
	}
	public String dameNombre() {
		return nombre;
	}

	public String dameDire() {
		return dire;
	
	}

	


}

