package entidades;

public class Partida {

	//Attributes
	private int turno;
	private static int puntos_en_disputa;
	//Jugador1
	private Personaje jugador1; 
	//Jugador2
	private Personaje jugador2;
		
	//Constructor	
	public Partida(Personaje jugador1, Personaje jugador2) {
		 this.jugador1 = jugador1;
		 this.jugador2 = jugador2;
		 turno = jugador1.getId();
	}

	//Getters
	public int getTurno() { return turno; }

	public static int getPuntos_en_disputa() { return puntos_en_disputa; }

	public Personaje getJugador1() { return jugador1; }

	public Personaje getJugador2() { return jugador2; }
	
	//Setters
	public void setTurno(int turno) { this.turno = turno; }

	public static void setPuntos_en_disputa(int puntos_en_disputa) {
		Partida.puntos_en_disputa = puntos_en_disputa;
	}

	public void setJugador1(Personaje jugador1) { this.jugador1 = jugador1; }

	public void setJugador2(Personaje jugador2) { this.jugador2 = jugador2; }
	
	
}