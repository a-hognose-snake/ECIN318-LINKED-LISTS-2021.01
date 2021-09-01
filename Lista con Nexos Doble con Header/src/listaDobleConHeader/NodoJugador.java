package listaDobleConHeader;

public class NodoJugador {
	
	private NodoJugador prev;
	private Jugador jugador;
	private NodoJugador next;
	
	public NodoJugador(Jugador j) {
		this.jugador = j;
		this.next = null;
		this.prev =  null;
	}

	public NodoJugador getPrev() {
		return prev;
	}

	public void setPrev(NodoJugador prev) {
		this.prev = prev;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public NodoJugador getNext() {
		return next;
	}

	public void setNext(NodoJugador next) {
		this.next = next;
	}
	

}
