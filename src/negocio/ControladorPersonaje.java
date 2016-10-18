package negocio;

import java.util.ArrayList;

import data.DataPersonaje;
import entidades.Personaje;

import utils.ApplicationException;

public class ControladorPersonaje {
	
	private ArrayList<Personaje> personajes;
	
	private data.DataPersonaje dataPersonaje;

	public ControladorPersonaje() {
		personajes = new ArrayList<Personaje>();
		dataPersonaje = new DataPersonaje();
	}
	
	public void add(String nombre){
		Personaje personaje = new Personaje(nombre);
		this.dataPersonaje.add(personaje);
		
	}
	
	public ArrayList<Personaje> getAll(){
		return personajes;
	}

}
