package entidades;

public class Partida {

	//Attributes
	private int turno;
	private static int puntos_en_disputa;
	//Player a
	private Personaje jugador_a; 
	//Player b
	private Personaje jugador_b;
		
	//Constructor	
	public Partida(Personaje jugador_a, Personaje jugador_b) {
		 this.jugador_a = jugador_a;
		 this.jugador_b = jugador_b;
		 turno = jugador_a.getId();
	}

	//Getters
	public int getTurno() { return turno; }

	public static int getPuntos_en_disputa() { return puntos_en_disputa; }

	public Personaje getJugador_a() { return jugador_a; }

	public Personaje getJugador_b() { return jugador_b; }
	
	//Setters
	public void setTurno(int turno) { this.turno = turno; }

	public static void setPuntos_en_disputa(int puntos_en_disputa) {
		Partida.puntos_en_disputa = puntos_en_disputa;
	}

	public void setJugador_a(Personaje jugador_a) { this.jugador_a = jugador_a; }

	public void setJugador_b(Personaje jugador_b) { this.jugador_b = jugador_b; }
}