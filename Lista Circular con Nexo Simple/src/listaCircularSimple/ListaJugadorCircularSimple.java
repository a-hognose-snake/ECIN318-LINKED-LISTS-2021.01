package listaCircularSimple;


public class ListaJugadorCircularSimple {
	
	private NodoJugador last;

	public ListaJugadorCircularSimple() {
		last = null;
	}
	
	public void ingresar(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if (last == null) {
			last = n;
			n.setNext(last);	
		}
		else {
			n.setNext(last.getNext());
			last.setNext(n);
			last = n;
		}	
	}
	
	public Jugador buscarRut(String rut) {
		String dato = rut;
		NodoJugador current = last;
		// do while: ejecuta y despues pregunta
		do {
			current = current.getNext();	
		} while (!current.getJugador().getRut().equals(dato) && last != current);
		
		if (current.getJugador().getRut().equals(dato)) {
			return current.getJugador();	
		} 
		else {
			return null;
		}
		
	}
	
	public boolean eliminarPorRut(String rut) {
		String dato = rut;
		if (last.getNext() == last) {
			if (last.getJugador().getRut().equals(dato)) {
				last = null;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			NodoJugador current = last;
			NodoJugador prev = last;
			while (current.getNext() != last && !current.getJugador().getRut().equals(dato)) {
				prev = current;
				current = current.getNext();
			}
			if (current == last && current.getJugador().getRut().equals(dato)) {
				NodoJugador aux = last;
				while (aux.getNext() != last) {
					aux = aux.getNext();
				}	
				aux.setNext(current.getNext());
				last = current.getNext();
				return true;
			} 
			else {
				if (current != last && current.getJugador().getRut().equals(dato)) {
					prev.setNext(current.getNext());
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
		NodoJugador current = last;
		// do while: ejecuta y despues pregunta
		do {
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
			current = current.getNext();
			
		} while (current != last);
		
		return text;
	}	

}
