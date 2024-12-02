package principal;

import java.util.Scanner;

import clases.Tren;

public class Principal {

	public static void main(String[] args) {
		// Scanner
		Scanner teclado = new Scanner(System.in);
		// Objeto
		Tren[] trenes = new Tren[5];

		// Declaraciones
		int opc, indice = 0;
		// Proceso
		do {
			mostarOpcionesMenu();
			opc = teclado.nextInt();

			if (indice == 0 && (opc > 1 && opc < 6)) {
				System.out.println("No hay trenes registrados");
			} else {
				switch (opc) {
				case 1:
					indice = ingresarTrenes(indice, trenes, teclado);
					break;
				case 2:
					mostrarVelocidadSuperada(indice, teclado, trenes);
					break;
				case 3:
					ordenarMayordistanciaAMenor(indice, teclado, trenes); ///
					break;
				case 4:
					reservaAsientos(indice, teclado, trenes);
					break;
				case 5:
					mostrarDatos(indice, trenes);
					break;
				case 6:
					System.out.println("Saliendo....");
					break;
				default:
					System.out.println("Opción no valida");
					break;
				}
			}
		} while (opc != 6);
		teclado.close();
	}

	private static void reservaAsientos(int indice, Scanner teclado, Tren[] trenes) {
		int refNum, numAsientos;
		boolean refCom=false;

		System.out.println("Introduce la referencia del tren");
		refNum = teclado.nextInt();
		for (int i = 0; i < indice; i++) {
			refCom = refNum == trenes[i].getReferencia();
		}
		if (refCom == true) {
			for (int i = 0; i < indice; i++) {
				if (refNum == trenes[i].getReferencia()) {
					System.out.println("¿Cuantos asientos queres reservar?");
					numAsientos = teclado.nextInt();
					if (numAsientos + trenes[i].getAsientoOcupado() >= 400) {
						System.out.println(
								"No se han podido guardar los asientos ya hay mas de 400 plazas, y has pedido reservar "
										+ numAsientos + " pero ya hay " + trenes[i].getAsientoOcupado()+" plazas reservadas");
					} else {
						trenes[i].setAsientoOcupado(numAsientos + trenes[i].getAsientoOcupado());
						System.out.println("Se han registrado tus asientos, la nueva cantidad de asientos ocupados es de: "+trenes[i].getAsientoOcupado());
					}
				}
			}
		}else {
			System.out.println("No hay trenes con esa referencia");
		}
	}

	private static void ordenarMayordistanciaAMenor(int indice, Scanner teclado, Tren[] trenes) {
		Tren intercambio;
		
		for (int i = 0; i < indice; i++) {
			
				for (int j = i + 1; j < indice; j++) {
					if (trenes[j].getDuracion() > trenes[i].getDuracion()) {
						intercambio = trenes[i];
						trenes[i] = trenes[j];
						trenes[j] = intercambio;
					
				}
				if (trenes[i].getTipo().equalsIgnoreCase("Cercanias")) {
			   System.out.println(trenes[i]);}
			}
			
		}
	}

	private static void mostrarVelocidadSuperada(int indice, Scanner teclado, Tren[] trenes) {
		Scanner sc = new Scanner (System.in);
		float velocidad,vel;
		boolean encontrado=false;
		
		System.out.println("Introduce la velocidad");
		velocidad = teclado.nextInt();
		for (int i = 0; i < indice; i++) {
			vel=trenes[i].obtenerVelocidadTotal();
			if (vel>velocidad) {
				trenes[i].getDatos();
			}
		}
	}

	private static int ingresarTrenes(int indice, Tren[] trenes, Scanner teclado) {
		String res = "si";
		Tren tren;
		int ref;
		boolean existeTren;

		for (; indice < trenes.length && res.equalsIgnoreCase("si");indice++) {
			existeTren = false;
			System.out.println("Introduce la referencia ");
			ref = teclado.nextInt();
			tren = new Tren();
			existeTren = exiteTren(trenes, ref, indice);
			if (existeTren == true) {
				System.out.println("El tren ya  ha sido introducido");
			} else {
				tren.setDatos(ref);
				for (int i = 0; i < indice; i++) {
					if (ref == trenes[i].getReferencia()) {
						System.out.println("El tren ya existe");
					}

				}
				trenes[indice] = tren;
				System.out.println("Se ha registrado con exito");
			}
			System.out.println("¿Quieres seguir introduciendo?");
			res = teclado.next();
		}
		if (indice >= trenes.length) {
			System.out.println("Has alcanzado el limite permitido.");
		}
		return indice;
	}

	private static boolean exiteTren(Tren[] trenes, int ref, int indice) {
		boolean existe = false;

		for (int i = 0; i < indice && existe == false; i++) {
			existe = ref == trenes[i].getReferencia();
		}

		return existe;
	}

	private static void mostrarDatos(int indice, Tren[] trenes) {
		for (int i = 0; i < indice; i++) {
			System.out.println(trenes[i].toString());
		}
	}

	private static void mostarOpcionesMenu() {
		System.out.println("***Menu***");
		System.out.println("1. Introducir los trenes");
		System.out.println("2. Mostrar los trenes que superen una velocidad dada");
		System.out.println("3. Ordenar los trenes de cercanías por duración del viaje.");
		System.out.println("4. Reserva de asientos.");
		System.out.println("5. Mostrar todos los trenes que se han introducido.");
		System.out.println("6. Salir");
		System.out.println("¿Que Quieres Hacer?");
	}
}
