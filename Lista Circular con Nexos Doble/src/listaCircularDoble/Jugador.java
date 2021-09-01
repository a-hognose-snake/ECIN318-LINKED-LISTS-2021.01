package listaCircularDoble;

public class Jugador {
	
	private String rut;
	private int edad;
	private int sueldo;
	
	public Jugador(String rut, int edad, int sueldo) {
		this.rut = rut;
		this.edad = edad;
		this.sueldo = sueldo;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public String toString() {
		String text = "";
		
		text += this.getRut()+"\n";
		text += "Sueldo: "+this.getSueldo()+"\n";
		text += "Edad: "+this.getEdad()+"\n\n";

		return text;
	}
	
	
	
	
	

}
