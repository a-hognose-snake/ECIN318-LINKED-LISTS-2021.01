package listaCircularSimpleConHeader;


public class ListaJugadorCircularSimpleConHeader {
	
	private NodoJugador header;
	private int size = 0;
	
	public ListaJugadorCircularSimpleConHeader() {
		header = new NodoJugador(null);
		header.setNext(header);
	}
	
	public int getSize() {
		return size;
	}	
	
	public void ingresar(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		n.setNext(header.getNext());
		header.setNext(n);
		
		size ++;
	}
	
	public Jugador buscar(String rut){
        NodoJugador aux = header;
        do {
        	aux=aux.getNext();
		} while ((aux != header) && (!(aux.getJugador().getRut().equals(rut))));       
        return aux.getJugador();
      }
	
	public boolean eliminar(String rut) {
		String dato = rut;
		if (header.getNext() == header) {
			return false;
		}
		else {
			NodoJugador prev = header;
			NodoJugador current = header;
			do {
				prev = current;
				current = current.getNext();
			} while (current != header && !current.getJugador().getRut().equals(dato));
			if (current == header) {
				return false;
			} 
			else {
				prev.setNext(current.getNext());
				return true;
			}
		}
	}
	
	

	
	@Override
	public String toString() {
		String text = "";
		NodoJugador current = header.getNext();
		// do while: ejecuta y despues pregunta
		do {
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
			current = current.getNext();
			
		} while (current != header);
		
		return text;
	}

	
	
}
