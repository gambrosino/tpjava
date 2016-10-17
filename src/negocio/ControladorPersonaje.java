package negocio;

import java.util.ArrayList;

import entidades.Personaje;

public class ControladorPersonaje {
	
	private static ArrayList<Personaje> pjs = new ArrayList<Personaje>();
	Personaje pj1;
	Personaje pj2;

	public ControladorPersonaje() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Personaje crearPersonaje(String nombre){
		
		pj1 = new Personaje(nombre);
		pjs.add(pj1);
		
		return pj1;
		
	}
	
	public ArrayList<Personaje> obtenerPersonajes(){
		
		// select desde la base
		// Crear los objetos y agregarlos al array list.
		//TODO
		return pjs;
		
	}

}
