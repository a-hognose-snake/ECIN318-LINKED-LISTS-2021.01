package listaCircularDoble;


public class ListaJugadorCircularDoble {
	
	private NodoJugador first;
	
	public ListaJugadorCircularDoble() {
		first = null;
	}
	
	public void ingresar(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		if (first == null) {
			first = n;
			first.setNext(n);
		} 
		else {
			NodoJugador aux = first;
			while (aux.getNext() != first) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setPrev(aux);
			n.setNext(first);
			first.setPrev(n);
		}	
	}
	
	public void ingresarMenorMayor(Jugador j) {
		NodoJugador n = new NodoJugador(j);
		int dato = n.getJugador().getEdad();
		if (first == null) {
			first = n;
			first.setNext(n);
			first.setPrev(n);
		} 
		else {
			NodoJugador aux = first;
			while (aux.getNext() != first && aux.getJugador().getEdad() < dato) {
				aux = aux.getNext();
			}
			//si es el primero y el primero es menor que el dato del nuevo
			if (aux.getNext() == first && aux.getJugador().getEdad() < dato) {
				aux.setNext(n);
				n.setPrev(aux);
				n.setNext(first);
				first.setPrev(n);
			} 
			else {
				n.setPrev(aux.getPrev());
				aux.getPrev().setNext(n);
				n.setNext(aux);
				aux.setPrev(n);
				if (aux == first && first.getJugador().getEdad() > dato) {
					first = n;
				} 	
			}
		}	
	}
	
	public Jugador buscar(String rut){
        NodoJugador aux = first;
        do {
        	aux=aux.getNext();
		} while ((aux != first) && (!(aux.getJugador().getRut().equals(rut))));       
        return aux.getJugador();
      }
	
	public boolean eliminarPorRut(String rut) {
		
		if (first == null) {
			return false;
		} 
		else {
			String dato = rut;
			NodoJugador aux = first;
			while (aux.getNext() != first && !aux.getJugador().getRut().equals(dato)) {
				aux = aux.getNext();
			}
			if (aux.getJugador().getRut().equals(dato)) {
				if (aux.getNext() == first) {
					aux.getPrev().setNext(first);
					first.setPrev(aux.getPrev());
					return true;
				} 
				else {
					if (aux == first) {
						first.getPrev().setNext(first.getNext());
						first.getNext().setPrev(first.getPrev());
						first = first.getNext();	
					} 
					else {
						aux.getPrev().setNext(aux.getNext());
						aux.getNext().setPrev(aux.getPrev());
					}
					return true;

				}
				
			} 
			else {
				return false;
			}
		}
	}
	
	
	@Override
	public String toString() {
		String text = "";
		NodoJugador current = first;
		// do while: ejecuta y despues pregunta
		do {
			text += "Rut: "+current.getJugador().getRut()+"\n";
			text += "Edad: "+current.getJugador().getEdad()+"\n\n";
			current = current.getNext();
			
		} while (current != first);
		
		return text;
	}	
	
}
