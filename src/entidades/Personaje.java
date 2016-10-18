package entidades;

public class Personaje {
	
	//Attributes
	private static int counter;
	private int id;
	private String nombre;
	private int vida;
	private int energia;
	private int defensa;
	private int evasion;
	private int puntosDisponibles;
	
	//Constructores
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
	
	//Getters
	private static int getCounter() { return ++Personaje.counter; }
	
	public int getId() { return this.id; }
	
	public String getNombre() { return nombre; }

	public int getVida() { return vida; }
	
	public int getEnergia() { return energia; }
	
	public int getDefensa() { return defensa; }

	public int getEvasion() { return evasion; }
	
	public int getPuntosDisponibles() { return puntosDisponibles; }

	//Setters
	public void setId(int id) { this.id = id; }
	
	public void setVida(int vida) { this.vida = vida; }
	
	public void setEnergia(int energia) { this.energia = energia; }
	
	public void setDefensa(int defensa) { this.defensa = defensa; }

	public void setEvasion(int evasion) { this.evasion = evasion; }

	public void setPuntosDisponibles(int puntosDisponibles) { this.puntosDisponibles = puntosDisponibles; }

	//Methods to add available points to players
	public void agregarVida(int puntos) {
		if (this.validaPuntos(puntos, this.vida)) 
			this.vida = puntos;	
	}

	public void agregarEnergia(int puntos) {
		if (this.validaPuntos(puntos, this.energia))
			this.energia = puntos;
	}
	
	public void agregarDefensa(int puntos) {
		if (validaPuntos(puntos, this.defensa) && puntos <= 20) 
			this.defensa = puntos;	
	}

	public void agregarEvasion(int puntos) {
		if (validaPuntos(puntos, this.evasion) && puntos <= 80) 
			this.evasion = puntos;
	}

	//Validations
	private boolean validaPuntos(int total, int atributo) {
		int puntos = total - atributo;
		if(puntos <= this.puntosDisponibles){
			this.puntosDisponibles -= puntos;
			return true;
		}
		return false ;
	}
}
