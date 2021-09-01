package listaDoble;


public class SistemaImpl implements Sistema{
	private ListaJugadoresDoble lista;
	
	public SistemaImpl() {
		lista = new ListaJugadoresDoble();
	}

	@Override
	public void ingresarJugador(String rut, int edad, int sueldo) {
		Jugador j = new Jugador(rut, edad, sueldo);
		lista.ingresarPrincipio(j);
		//lista.ingresarUltimo(j);
		//lista.ingresarOrdenadoMenorMayor(j);
	}
	
	public String obtenerInfo() {
		return lista.toString();	
	}
	
	public String obtenerInfoAlRevez() {
		return lista.toString2();	
	}

	public String encontrarString(String x) {
		String text = "";
		Jugador j = lista.buscarPorRut(x);
		if ( j == null) {
			throw new NullPointerException("No existe jugador con ese rut.\n");
		} 
		else {
			text = "Jugador: "+j.toString()+"\n";
		}
		return text;
	}

	@Override
	public boolean eliminarPorRut(String rut) {
		if (lista.eliminarPorRut(rut)) {
			return true;
		} 
		else {
			throw new NullPointerException("No existe jugador con ese rut. No se pudo eliminar.\n");
		}
	}
	
	
	
	
	
	
}
