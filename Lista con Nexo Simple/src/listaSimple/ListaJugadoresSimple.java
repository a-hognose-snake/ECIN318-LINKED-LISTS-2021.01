package listaSimple;

public class ListaJugadoresSimple {
	
	private NodoJugador first;

	public ListaJugadoresSimple() {
		first = null;
	}
	
	public void ingresarPrincipio(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if (first == null) {
			first = n;
			
		}
		else {
			n.setNext(first);
			first = n;
			
		}
	}
	
	public void ingresarUltimo(Jugador j) {
		
		NodoJugador n = new NodoJugador(j);
		
		if (first == null) {
			first = n;	
		} 
		else {
			NodoJugador current = first;
			while (current.getNext() != null) {
				current = current.getNext();	
			}
			current.setNext(n);
		}
		
	}
	
	public void ingresarOrdenadoMenorMayor(Jugador j) {
		
		NodoJugador n = new NodoJugador(j);
		
		if (first == null) {
			first = n;
		} 
		else {
			int dato = j.getEdad();
			NodoJugador current = first;
			NodoJugador previo = current;
			while (current.getJugador().getEdad() < dato && current.getNext() != null) {
				previo = current;
				current = current.getNext();	
			}
			if (current == first) {
				if (current.getJugador().getEdad() > dato) {
					n.setNext(first);
					first = n;	
				} 
				else {
					n.setNext(first.getNext());
					first.setNext(n);
				}
			} 
			else {
				if (current.getNext() != null) {
					previo.setNext(n);
					n.setNext(current);
				} 
				else {
					if (current.getJugador().getEdad() > dato) {
						previo.setNext(n);
						n.setNext(current);
					} 
					else {
						current.setNext(n);
					}
				}
			}
		}
	}
	
public void ingresarOrdenadoMayorMenor(Jugador j) {
		
		NodoJugador n = new NodoJugador(j);
		
		if (first == null) {
			first = n;
		} 
		else {
			int dato = j.getEdad();
			NodoJugador current = first;
			NodoJugador previo = current;
			while (current.getJugador().getEdad() > dato && current.getNext() != null) {
				previo = current;
				current = current.getNext();	
			}
			if (current == first) {
				if (current.getJugador().getEdad() < dato) {
					n.setNext(first);
					first = n;	
				} 
				else {
					n.setNext(first.getNext());
					first.setNext(n);
				}
			} 
			else {
				if (current.getNext() != null) {
					previo.setNext(n);
					n.setNext(current);
				} 
				else {
					if (current.getJugador().getEdad() < dato) {
						previo.setNext(n);
						n.setNext(current);
					} 
					else {
						current.setNext(n);
					}
				}
			}
		}
	}
	
	public Jugador buscarJugadorPorRut(String rut) {
		String dato = rut;
		NodoJugador current = first;
		while (!current.getJugador().getRut().equals(dato) && current.getNext() != null) {
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
		NodoJugador prev = first;
		while (!current.getJugador().getRut().equals(dato) && current.getNext() != null) {
			prev = current;
			current = current.getNext();
		}
		if (current.getJugador().getRut().equals(dato)) {
			if (first == current) {
				first = first.getNext();
				return true;	
			} 
			else {
				prev.setNext(current.getNext());
				return true;
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

}
