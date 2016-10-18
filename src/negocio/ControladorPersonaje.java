package negocio;

import java.util.ArrayList;
import java.util.Hashtable;

import entidades.Personaje;

public class ControladorPersonaje {
	
	private static ArrayList<Personaje> pjs = new ArrayList<Personaje>();
	Personaje pj1;
	Personaje pj2;

	public ControladorPersonaje() {
		// TODO Auto-generated constructor stub
	}
	
	public Personaje crearPersonaje(String nombre){
		
		Personaje personaje = new Personaje(nombre);
		//pjs.add(personaje);
		
		return personaje;
		
	}
	
	public void guardarPersonaje(Personaje pj, Hashtable<String, String> atributos) {
		// TODO validar datos, manejar excepciones
		pj.setVida(Integer.parseInt(atributos.get("vida")));
		pj.setEnergia(Integer.parseInt(atributos.get("energia")));
		pj.setDefensa(Integer.parseInt(atributos.get("defensa")));
		pj.setEvasion(Integer.parseInt(atributos.get("evasion")));
		
		agregar(pj);
	}
	
	private void agregar(Personaje pj) {
		//TODO guardar pj en la bd
		
	}

	public ArrayList<Personaje> obtenerPersonajes(){
		
		// select desde la base
		// Crear los objetos y agregarlos al array list.
		//TODO
		return pjs;
		
	}

}
