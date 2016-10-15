package entidades;

public class Personaje {
	
	private static int counter;
	
	private int id;
	
	private String nombre;
	
	private int vida;
	
	private int energia;
	
	private int defensa;
	
	private int evasion;
	
	private int puntosDisponibles;
	
	private static int getCounter() {
		return ++Personaje.counter;
	}

	public Personaje(String nombre) {
		super();
		this.id = Personaje.getCounter();
		this.nombre = nombre;
		this.vida = 0;
		this.energia = 0;
		this.defensa = 0;
		this.evasion = 0;
		this.puntosDisponibles = 200;
	}
	
	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}
	
	public void agregarVida(int puntos) {
		if (this.validaPuntos(puntos, this.vida)) {
			this.vida = puntos;
		}
	}
	
	public int getEnergia() {
		return energia;
	}
	
	public void agregarEnergia(int puntos) {
		if (this.validaPuntos(puntos, this.energia)) {
			this.energia = puntos;
		}
	}
	public int getDefensa() {
		return defensa;
	}
	
	public void agregarDefensa(int puntos) {
		if (validaPuntos(puntos, this.defensa) && puntos <= 20) {
			this.defensa = puntos;
		}
	}

	public int getEvasion() {
		return evasion;
	}
	
	public void agregarEvasion(int puntos) {
		if (validaPuntos(puntos, this.evasion) && puntos <= 80) {
			this.evasion = puntos;
		}
	}

	public int getPuntosDisponibles() {
		return puntosDisponibles;
	}

	private boolean validaPuntos(int total, int atributo) {
		int puntos = total - atributo;
		if(puntos <= this.puntosDisponibles){
			this.puntosDisponibles -= puntos;
			return true;
		}
		return false ;
	}
}
