package listaSimpleConHeader;

public class ListaJugadorSimpleConHeader {
	
	private NodoJugador header;
	private int size = 0;
	
	public ListaJugadorSimpleConHeader() {
		header = new NodoJugador(null);
	}
	
	public int getSize() {
		return size;
	}
	
	public void ingresarPrincipio(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if (header.getNext() == null) {
			header.setNext(n);
			n.setNext(null);
		} 
		else {
			n.setNext(header.getNext());
			header.setNext(n);
		}
		size ++;
	}
	public void ingresarUltimo(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if (header.getNext() == null) {
			header.setNext(n);
			n.setNext(null);
		} 
		else {
			NodoJugador current = header.getNext();
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
			n.setNext(null);
		}
		size ++;
	}
	
	public Jugador buscar(String rut) {
		String dato = rut;
		if (header.getNext() == null) {
			return null;
		}
		NodoJugador current = header.getNext();
		while (current.getNext() != null && !current.getJugador().getRut().equals(dato)) {
			current = current.getNext();
		}
		if (current.getJugador().getRut().equals(dato)) {
			return current.getJugador();
		} else {
			return null;
		}
	}
	
	public boolean eliminar(String rut) {
		String dato = rut;
		if (header.getNext() == null) {
			return false;
		}
		NodoJugador current = header.getNext();
		NodoJugador prevCurrent = header;
		while (current.getNext() != null && !current.getJugador().getRut().equals(dato)) {
			prevCurrent = current;
			current = current.getNext();
		}
		if (current.getJugador().getRut().equals(dato)) {
			prevCurrent.setNext(current.getNext());
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		String text = "";
		NodoJugador current = header.getNext();
		while (current != null) {
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
			current = current.getNext();
		}
		return text;
	}

}
