package negocio;

import java.util.ArrayList;
import java.util.Hashtable;

import datos.DatosPersonaje;
import entidades.Personaje;

import utils.ApplicationException;

public class ControladorPersonaje {
	
	private ArrayList<Personaje> personajes;
	
	private Personaje personaje;
	
	private DatosPersonaje datosPersonaje;

	public ControladorPersonaje() {
		this.personajes = new ArrayList<Personaje>();
		this.datosPersonaje = new DatosPersonaje();
	}

	public Personaje traerActual() {
		return this.personaje;
	}
	
	public boolean crear(String nombre) {
		
		if(!existe(nombre)) {
			this.personaje = new Personaje(nombre.trim());
			
			this.datosPersonaje.crear(personaje);
			
			return true;
		}
		
		return false;
	}
	
	public void actualizar(Personaje personaje, Hashtable<String, String> atributos) {
		personaje.setVida(Integer.parseInt(atributos.get("vida")));
		personaje.setEnergia(Integer.parseInt(atributos.get("energia")));
		personaje.setDefensa(Integer.parseInt(atributos.get("defensa")));
		personaje.setEvasion(Integer.parseInt(atributos.get("evasion")));
		personaje.setPuntosDisponibles(Integer.parseInt(atributos.get("puntosDisponibles")));
		
		this.datosPersonaje.actualizar(personaje);
	}
	public void eliminar(Personaje personaje){
		this.datosPersonaje.eliminar(personaje);
	}
	
	public Personaje traerPor(int id) {
		return this.datosPersonaje.traerPor(id);
	}
	
	public ArrayList<Personaje> traerTodos(){
		personajes = this.datosPersonaje.traerTodos();
		return personajes;
	}
	
	public boolean existe(String nombre) {
	
		//for(Personaje personaje : traerTodos() ){
			//if (personaje.getNombre().toString() == nombre.toString())
			return this.datosPersonaje.existe(nombre.trim());
		//}
		
		//return false;
	}

}
