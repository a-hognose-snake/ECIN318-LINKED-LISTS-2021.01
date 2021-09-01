package listaDoble;

public interface Sistema {
	
	public void ingresarJugador(String rut, int edad, int sueldo);
	public String obtenerInfo();
	public String obtenerInfoAlRevez();
	public String encontrarString(String x);
	public boolean eliminarPorRut(String rut);
}