package listaCircularDoble;


public class SistemaImpl implements Sistema{
	private ListaJugadorCircularDoble lista;
	
	public SistemaImpl() {
		lista = new ListaJugadorCircularDoble();
	}

	@Override
	public void ingresarJugador(String rut, int edad, int sueldo) {
		Jugador j = new Jugador(rut, edad, sueldo);
		lista.ingresarMenorMayor(j);
	}
	
	public String obtenerInfo() {
		return lista.toString();	
	}


	@Override
	public String encontrarString(String x) {
		Jugador j = lista.buscar(x);
		if (j == null) {
			throw new NullPointerException("No hay un jugador con ese rut.");	
		} 
		else {
			return j.toString();
		}
	}

	@Override
	public boolean eliminarPorRut(String rut) {
		if (lista.eliminarPorRut(rut)) {
			return true;
		} 
		else {
			throw new NullPointerException("No se pudo eliminar.");
		}
	}

	

	
	
	
	
	
	
}
