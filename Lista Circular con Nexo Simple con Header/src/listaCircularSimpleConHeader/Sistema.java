package listaCircularSimpleConHeader;

public interface Sistema {
	
	public void ingresarJugador(String rut, int edad, int sueldo);
	public String obtenerInfo();
	public String encontrarString(String x);
	public boolean eliminarPorRut(String rut);
}