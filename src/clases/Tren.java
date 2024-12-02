package clases;

import java.util.Scanner;

public class Tren {
	// Scanner
	Scanner sc = new Scanner(System.in);
	// Atributos
	String tipo;
	int referencia;
	int asientoOcupado;
	int kmRecorridos;
	// En minutos
	int duracion;

	//constante
	final private int CAPACIDAD_MAXIMA=400;
	
	public Tren() {
	}

	// Constructor
	
	
	public Tren(String tipo) {
		this.tipo = tipo;
		
	}

	public Tren(String tipo, int referencia, int asientoOcupado, int kmRecorridos, int duracion) {
		this.tipo = tipo;
		this.referencia = referencia;
		this.asientoOcupado = asientoOcupado;
		this.kmRecorridos = kmRecorridos;
		this.duracion = duracion;
	}

	// Getters & Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public int getAsientoOcupado() {
		return asientoOcupado;
	}

	public void setAsientoOcupado(int asientoOcupado) {
		this.asientoOcupado = asientoOcupado;
	}

	public int getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(int kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	// toString
	@Override
	public String toString() {
		return "Tren [tipo=" + tipo + ", referencia=" + referencia + ", asientoOcupado=" + asientoOcupado
				+ ", kmRecorridos=" + kmRecorridos + ", duracion=" + duracion + "]";
	}

	// Metodos
	public String validarTipo() {
		tipo=sc.next();
		if (tipo.equalsIgnoreCase("Cercanias") || tipo.equalsIgnoreCase("Ave") || tipo.equalsIgnoreCase("Mercancias")) {
			return tipo;
		} else {
			return "Indefinido";
		}
	}

	public boolean trenLleno() {
		return asientoOcupado>=CAPACIDAD_MAXIMA;
	}

	public float obtenerVelocidadTotal() {
		return (float)kmRecorridos/duracion/60;

	}

	// setDatos
	public void setDatos (int ref) {
		System.out.println("Introduce el tipo del tren: ");
		tipo = validarTipo();
		referencia =ref;
		System.out.println("Introduce el numero de asientos ocupados: ");
		asientoOcupado = sc.nextInt();
		System.out.println("Introduce los km recorridos: ");
		kmRecorridos = sc.nextInt();
		System.out.println("Introduce la duración del viaje ");
		duracion = sc.nextInt();
	}
	
	// getDatos
	public void getDatos () {
		System.out.println("La referencia es: " + referencia+ " y su velocidad es de:" +obtenerVelocidadTotal()+" km/h" );
	}
}
