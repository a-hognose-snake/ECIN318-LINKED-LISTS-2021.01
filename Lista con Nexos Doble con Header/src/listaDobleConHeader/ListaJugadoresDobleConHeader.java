package listaDobleConHeader;


public class ListaJugadoresDobleConHeader {
	
	private NodoJugador header;
	private int size = 0;
	
	public ListaJugadoresDobleConHeader() {
		header = new NodoJugador(null);
		header.setPrev(null);
		header.setNext(null);
	}
	
	public int getSize() {
		return size;
	}
	
	public void ingresarPrincipio(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if ( header.getPrev() == null && header.getNext() == null) {
			header.setPrev(n);
			header.setNext(n);
		} 
		else {
			n.setNext(header.getPrev());
			header.getPrev().setPrev(n);
			header.setPrev(n);
		}
	}
	
	public void ingresarUltimo(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if ( header.getPrev() == null && header.getNext() == null) {
			header.setPrev(n);
			header.setNext(n);
		} 
		else {
			n.setPrev(header.getNext());
			header.getNext().setNext(n);
			header.setNext(n);
		}
	}
	
	public Jugador buscar(String rut) {
		String dato = rut;
		NodoJugador current = header.getPrev();
		while (!current.getJugador().getRut().equals(dato) && current != header.getNext()) {
			current = current.getNext();	
		}
		if (current.getJugador().getRut().equals(dato)) {
			return current.getJugador();
		} 
		else {
			return null;
		}
	}
	
	public boolean eliminarPorRut(String rut) {
		String dato = rut;
		NodoJugador current = header.getPrev();
		
		while (current != header.getNext()  && !current.getJugador().getRut().equals(dato) ) {
			
			current = current.getNext();
			
			
		}
		if (current == header.getPrev() && current.getJugador().getRut().equals(dato)) {
			header.setPrev(current.getNext());
			current.getNext().setPrev(null);
			return true;	
		} 
		else {
			if (current == header.getNext() && current.getJugador().getRut().equals(dato)) {
				header.setNext(current.getPrev());
				current.getPrev().setNext(null);
				return true;
				
			} 
			else {
				if (current.getJugador().getRut().equals(dato)) {
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					return true;
				} 
				else {
					return false;
				}
			}
		}
	}
	
	
	
	@Override
	public String toString() {
		String text = "";
		NodoJugador current = header.getPrev();
		while (current != null) {
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
			current = current.getNext();
		}
		return text;
	}
	
	
	
	

}
