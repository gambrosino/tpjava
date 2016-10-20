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
	
	public Personaje nuevoPersonaje(String nombre) {
		personaje = new Personaje(nombre);
		// validar que no exista el nombre
		return personaje;
	}
	
	public void guardar(Personaje personaje, Hashtable<String, String> atributos) {
		// TODO validar datos, manejar excepciones
		personaje.setVida(Integer.parseInt(atributos.get("vida")));
		personaje.setEnergia(Integer.parseInt(atributos.get("energia")));
		personaje.setDefensa(Integer.parseInt(atributos.get("defensa")));
		personaje.setEvasion(Integer.parseInt(atributos.get("evasion")));
		personaje.setPuntosDisponibles(Integer.parseInt(atributos.get("puntosDisponibles")));
		
		if (personaje.getId() == 0) {
			dataPersonaje.add(personaje);
		} else {
			dataPersonaje.update(personaje);
		}	
	}
	public void borrar(Personaje personaje){
		dataPersonaje.delete(personaje);
	}
	
	public Personaje getBy(int id) {
		return this.dataPersonaje.getBy(id);
	}
	
	public ArrayList<Personaje> getAll(){
		personajes = this.dataPersonaje.getAll();
		return personajes;
	}

}
