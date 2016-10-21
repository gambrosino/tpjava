package negocio;

import java.util.ArrayList;

import entidades.Personaje;

public class ControladorPartida {
	
	ArrayList<Personaje> personajes;
	
	int turno;
	
	public ControladorPartida(Personaje pj1, Personaje pj2) {
		personajes.add(pj1);
		personajes.add(pj2);
		
		turno = Math.random() < 0.5 ? 0 : 1;
	}
	
	public int getTurno() {
		return ++turno % 2;		
	}
	
	public void atacar(Personaje pjActivo, Personaje pjPasivo, int puntosAtaque) {
	  pjActivo.atacar(puntosAtaque);
	  pjPasivo.intentarEvadir(puntosAtaque);
	}
	
	public void defender(Personaje pjActivo){
	  pjActivo.defender();
	}

}
