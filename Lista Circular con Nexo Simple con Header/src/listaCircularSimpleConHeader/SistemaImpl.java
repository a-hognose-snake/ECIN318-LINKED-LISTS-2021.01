package listaCircularSimpleConHeader;


public class SistemaImpl implements Sistema{
	
	private ListaJugadorCircularSimpleConHeader lista;
	
	public SistemaImpl() {
		lista = new ListaJugadorCircularSimpleConHeader();
	}
	
	@Override
	public void ingresarJugador(String rut, int edad, int sueldo) {
		Jugador j = new Jugador(rut, edad, sueldo);
		lista.ingresar(j);	
	}

	public String obtenerInfo() {
		return lista.toString();	
	}

	@Override
	public String encontrarString(String x) {
		
		Jugador j = lista.buscar(x);
		
		if (j == null) {
			throw new NullPointerException("No se encontro un jugador con ese rut.");	
		} 
		else {
			return j.toString();
		}
	}

	@Override
	public boolean eliminarPorRut(String rut) {
		if (lista.eliminar(rut)) {
			return true;
		} 
		else {
			throw new NullPointerException("No se encontro un jugador con ese rut. No se pudo elimina \n");	
		}
	}
	
	


	
	
	
	
	
	
}
