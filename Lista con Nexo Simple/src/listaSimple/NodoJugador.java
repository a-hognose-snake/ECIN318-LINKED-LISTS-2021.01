package listaSimple;

public class NodoJugador {
	private NodoJugador next;
	private Jugador jugador;
	
	public NodoJugador(Jugador j) {
		this.jugador = j;
		setNext(null);
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
