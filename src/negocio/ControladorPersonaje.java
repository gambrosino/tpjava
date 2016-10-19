package negocio;

import java.util.ArrayList;
import java.util.Hashtable;

import data.DataPersonaje;
import entidades.Personaje;

import utils.ApplicationException;

public class ControladorPersonaje {
	
	private ArrayList<Personaje> personajes;
	
	private Personaje personaje;
	
	private data.DataPersonaje dataPersonaje;

	public ControladorPersonaje() {
		personajes = new ArrayList<Personaje>();
		dataPersonaje = new DataPersonaje();
	}
	
	public Personaje getActual() {
		return this.personaje;
	}
	
	public void add(String nombre){
		this.personaje = new Personaje(nombre);
		
		personaje.setId(this.dataPersonaje.add(personaje));
	}
	
	public void update(Personaje personaje, Hashtable<String, String> atributos) {
		// TODO validar datos, manejar excepciones
		personaje.setVida(Integer.parseInt(atributos.get("vida")));
		personaje.setEnergia(Integer.parseInt(atributos.get("energia")));
		personaje.setDefensa(Integer.parseInt(atributos.get("defensa")));
		personaje.setEvasion(Integer.parseInt(atributos.get("evasion")));
		personaje.setPuntosDisponibles(Integer.parseInt(atributos.get("puntosDisponibles")));
		
		this.dataPersonaje.update(personaje);
	}
	
	public Personaje getBy(int id) {
		return this.dataPersonaje.getBy(id);
	}
	
	public ArrayList<Personaje> getAll(){
		personajes = this.dataPersonaje.getAll();
		return personajes;
	}

}
