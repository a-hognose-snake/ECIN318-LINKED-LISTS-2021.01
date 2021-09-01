package listaSimple;


public class SistemaImpl implements Sistema{
	private ListaJugadoresSimple lista;
	
	public SistemaImpl() {
		lista = new ListaJugadoresSimple();
	}

	@Override
	public void ingresarJugador(String rut, int edad, int sueldo) {
		Jugador j = new Jugador(rut, edad, sueldo);
		//lista.ingresarPrincipio(j);
		//lista.ingresarUltimo(j);
		//lista.ingresarOrdenadoMenorMayor(j);
		lista.ingresarOrdenadoMayorMenor(j);
	}
	
	public String obtenerInfo() {
		return lista.toString();	
	}
	
	public String encontrarString(String x) {
		String text = "";
		if (lista.buscarJugadorPorRut(x) == null) {
			throw new NullPointerException("No existe un jugador con ese rut\n");	
		} 
		else {
			text = "Jugador: "+lista.buscarJugadorPorRut(x).toString()+"\n";
		}
		return text;
	}
	
	public boolean eliminarPorRut(String rut) {
		if (lista.eliminarPorRut(rut)) {
			return true;
		} 
		else {
			throw new NullPointerException("No se pudo eliminar la huea.\n");
		}
	}
	
}
