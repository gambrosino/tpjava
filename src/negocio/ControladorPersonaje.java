package negocio;

import java.util.ArrayList;
import java.util.Hashtable;

import datos.DatosPersonaje;
import entidades.Personaje;

import utils.ApplicationException;

public class ControladorPersonaje {
	
	private ArrayList<Personaje> personajes;
	
	private Personaje personaje;
	
	private datos.DatosPersonaje datosPersonaje;

	public ControladorPersonaje() {
		this.personajes = new ArrayList<Personaje>();
		this.datosPersonaje = new DatosPersonaje();
	}

	public Personaje traerActual() {
		return this.personaje;
	}
	
	public Personaje crear(String nombre) {
		this.personaje = new Personaje(nombre);
		// validar que no exista el nombre
		return personaje;
	}
	
	public void actualizar(Personaje personaje, Hashtable<String, String> atributos) {
		// TODO validar datos, manejar excepciones
		personaje.setVida(Integer.parseInt(atributos.get("vida")));
		personaje.setEnergia(Integer.parseInt(atributos.get("energia")));
		personaje.setDefensa(Integer.parseInt(atributos.get("defensa")));
		personaje.setEvasion(Integer.parseInt(atributos.get("evasion")));
		personaje.setPuntosDisponibles(Integer.parseInt(atributos.get("puntosDisponibles")));
		
		if (personaje.getId() == 0) {
			datosPersonaje.crear(personaje);
		} else {
			datosPersonaje.actualizar(personaje);
		}	
	}
	public void eliminar(Personaje personaje){
		datosPersonaje.eliminar(personaje);
	}
	
	public Personaje traerPor(int id) {
		return this.datosPersonaje.traerPor(id);
	}
	
	public ArrayList<Personaje> traerTodos(){
		personajes = this.datosPersonaje.traerTodos();
		return personajes;
	}

}
