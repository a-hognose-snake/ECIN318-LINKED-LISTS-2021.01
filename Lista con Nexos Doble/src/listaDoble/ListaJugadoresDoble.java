package listaDoble;


public class ListaJugadoresDoble {
	private NodoJugador first;
	private NodoJugador last;
	
	public ListaJugadoresDoble() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		if (first == null) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public void ingresarPrincipio(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if (isEmpty()) {
			first = n;
			last = n;
		} 
		else {
			n.setNext(first);
			first.setPrev(n);
			first = n;
		}
	}
	
	public void ingresarUltimo(Jugador j) {
		
		NodoJugador n = new NodoJugador(j);
		
		if (isEmpty()) {
			first = n;
			last = n;	
		} 
		else {
			last.setNext(n);
			n.setPrev(last);
			last = n;
		}
	}
	
	public void ingresarOrdenadoMenorMayor(Jugador j) {
			
		NodoJugador n = new NodoJugador(j);
		int dato = n.getJugador().getEdad();
		
		if (isEmpty()) {
			first = n;
			last = n;
		} 
		else {
			if (first == last) {
				if (first.getJugador().getEdad() > dato) {
					n.setNext(first);
					first.setPrev(n);
					last = first;
					first = n;
					
				} 
				else {
					n.setPrev(first);
					first.setNext(n);
					last = n;
				}	
			} 
			else {
				NodoJugador current = first;
				while (current.getJugador().getEdad() < dato && current != last) {
					current = current.getNext();
				}
				if (current == first) {
					first.setPrev(n);
					n.setNext(first);
					first = n;
				} 
				else {
					if (current == last) {
						if (current.getJugador().getEdad() > dato) {
							last.getPrev().setNext(n);
							n.setPrev(last.getPrev());
							n.setNext(last);
							last.setPrev(n);
						} 
						else {
							last.setNext(n);
							n.setPrev(last);
							last = n;
						}
					} 
					else {
						current.getPrev().setNext(n);
						n.setPrev(current.getPrev());
						current.setPrev(n);
						n.setNext(current);
					}
				}
			}	
		}
	}
	
	public Jugador buscarPorRut(String rut) {
		String dato = rut;
		NodoJugador current = first;
		while (!current.getJugador().getRut().equals(dato) && current != last) {
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
		NodoJugador current = first;
		while (!current.getJugador().getRut().equals(dato) && current != last) {
			current = current.getNext();	
		}
		if (current.getJugador().getRut().equals(dato)) {
			if (current == first) {
				first = first.getNext();
				first.setPrev(null);
				return true;
			} 
			else {
				if (current == last) {
					last = current.getPrev();
					last.setNext(null);
					return true;
				} 
				else {
					NodoJugador aux = current;
					current = aux.getPrev();
					current.setNext(aux.getNext());
					current.getNext().setPrev(current);
					aux = null;
					return true;
				}
			}
		} 
		else {
			return false;
		}
	}
		
	
	@Override
	public String toString() {
		String text = "";
		NodoJugador current = first;
		while (current != null) {
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
			current = current.getNext();
		}
		return text;
	}

	public String toString2() {
		String text = "";
		NodoJugador current = last;
		while (current != null) {
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
			current = current.getPrev();
		}
		return text;
	}
	
	

}
