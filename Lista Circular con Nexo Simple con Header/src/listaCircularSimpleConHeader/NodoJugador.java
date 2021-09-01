package listaCircularSimpleConHeader;

public class NodoJugador {
	
	private Jugador jugador;
	private NodoJugador next;
	
	public NodoJugador(Jugador j) {
		this.jugador = j;
		this.next = null;
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
