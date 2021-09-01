package listaSimpleConHeader;


public class SistemaImpl implements Sistema{
	private ListaJugadorSimpleConHeader lista;
	
	public SistemaImpl() {
		lista = new ListaJugadorSimpleConHeader();
	}

	@Override
	public void ingresarJugador(String rut, int edad, int sueldo) {
		Jugador j = new Jugador(rut, edad, sueldo);
		//lista.ingresarPrincipio(j);
		lista.ingresarUltimo(j);
	}
	
	public String obtenerInfo() {
		return lista.toString();	
	}
	
	public String encontrarString(String x) {
		Jugador j = lista.buscar(x);
		String text = "";
		if ( j == null) {
			throw new NullPointerException("No existe un jugador con ese rut\n");	
		} 
		else {
			text = "Jugador: "+j.toString()+"\n";
		}
		return text;
	}
	
	public boolean eliminarPorRut(String rut) {
		if (lista.eliminar(rut)) {
			return true;
		} 
		else {
			throw new NullPointerException("No se pudo eliminar la huea.\n");
		}
	}
	
}
