package listaCircularDobleConHeader;

public class ListaJugadorCircularDobleConHeader {
	
	private NodoJugador header;
	private int size = 0;
	
	public ListaJugadorCircularDobleConHeader() {
		header = new NodoJugador(null);
		header.setNext(header);
		header.setPrev(header);
	}
	
	public int getSize() {
		return size;
	}
	
	public void ingresar(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if (header.getNext() == header) {
			header.setNext(n);
			header.setPrev(n);
		} 
		else {
			n.setNext(header.getNext());
			n.setPrev(header);
			n.getNext().setPrev(n);
			header.setNext(n);
		}
	}
	
	public Jugador buscar(String rut){
		String dato = rut;
		NodoJugador current = header;
		do {
			current = current.getNext();
		} while (current != header.getPrev() && !current.getJugador().getRut().equals(dato));
		return current.getJugador();
      }
	
	public boolean eliminarPorRut(String rut) {
		String dato = rut;
		if (header.getNext() == header) {
			return false;
		} 
		else {
			NodoJugador current = header.getNext();
			while (current != header.getPrev() && !current.getJugador().getRut().equals(dato)) {
				current = current.getNext();
			}
			if (current == header) {
				return false;
			} 
			else {
				NodoJugador prevCurrent = current.getPrev();
				if (current == header.getPrev()) {
					prevCurrent.setNext(header);
					header.setPrev(prevCurrent);
					return true;
					
				} 
				else {
					prevCurrent.setNext(current.getNext());
					current.getNext().setPrev(prevCurrent);
					return true;
				}
				
			}
		}
	}
	
	
	@Override
	public String toString() {
		String text = "";
		NodoJugador current = header;
		// do while: ejecuta y despues pregunta
		do {
			current = current.getNext();
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
		} while (current != header.getPrev());
		return text;
	}	
	
}
