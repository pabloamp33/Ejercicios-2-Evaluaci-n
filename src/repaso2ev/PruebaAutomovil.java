package repaso2ev;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PruebaAutomovil {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		//leer nº de automoviles
		int numeroAutomoviles=0;
		while (numeroAutomoviles<1) {			
		  try {
			System.out.println("Introduzca el nº de automóviles (>0):");
		    numeroAutomoviles = Integer.parseInt(scan.nextLine());
		    if (numeroAutomoviles<1) {
		    	System.out.println("¡Cuidado! Solo puedes introducir un nº>0");
			}
		  } catch (Exception exception) {
		    System.out.println("¡Cuidado! Solo puedes introducir un nº>0");
		  }
		}
			
		//leer los automoviles, instanciarlos y añadirlos a mapa
		Map<String, Automovil> automoviles = new TreeMap<>();
		int itemsLinea=0;
		for (int i=0; i<numeroAutomoviles; i++) {
			do {
				System.out.println("Introduzca linea con datos del automovil Nº "+(i+1)+" en formato: Modelo(String) Capacidad(double) Cantidad(double) Consumo(double)");
				System.out.println("	ejemplo: BMW-X5 80 35 0.3");
				String datosAutomovil [] = scan.nextLine().split(" ");
				itemsLinea=datosAutomovil.length;
				if (datosAutomovil.length==4) {
					Automovil miAutomovil = new Automovil(datosAutomovil [0], Double.parseDouble(datosAutomovil [1]), Double.parseDouble(datosAutomovil [2]), Double.parseDouble(datosAutomovil [3]));
					automoviles.put(datosAutomovil [0], miAutomovil);
				}
			} while (itemsLinea != 4);
				
		}
		
		
		
		//leer las acciones y ejecutarlas
		boolean fin = false;
		while (!fin) {
			boolean accionCorrecta=false;
			do {
				System.out.println("Introduzca la accion a realizar con un automovil (fin para salir)");
				System.out.println("	Ejemplos acciones permitidas:");
				System.out.println("                        llenarDeposito BMW-X5   (Llena el deposito del BMW-X5 al tope");
				System.out.println("                        llenarDeposito BMW-X5 35 (Añade 35 l de combustible al deposito del ");
				System.out.println("                        desplazar BMW-X5 25      (mueve el automovil BMW-X5 25Km");
				String accion [] = scan.nextLine().split(" ");
				accionCorrecta=ejecutaAccion(accion, automoviles);
				if (accion[0].equals("fin")) fin=true; 
			} while (!accionCorrecta);
		}

		//Muestra resultado final por consola
		System.out.println("-------------------------------------");
		for (String e: automoviles.keySet()) {
			System.out.println(automoviles.get(e).toString());
		}
		
		
		
		scan.close();
	}
	
	
	//metodos auxiliares
	
	// comprueba y ejecuta acción
	static boolean ejecutaAccion(String accion[], Map<String, Automovil> automoviles) {
		boolean resultado=false;
		String mensajeError="Parametros incorrectos";
		double devuelveMetodo=0;
		switch (accion[0])
		{
		case "fin":
			resultado=true;
			break;
		case "desplazar":
			if (accion.length == 3) {
				if (automoviles.containsKey(accion[1])) {
					devuelveMetodo=automoviles.get(accion[1]).desplazar(Double.parseDouble(accion[2]));
					if (devuelveMetodo==-1) { 
						mensajeError="Combustible insuficiente para este desplazamiento.";
					}else {
						System.out.println(accion[1]+" "+automoviles.get(accion[1]).getCantidad()+" "+automoviles.get(accion[1]).combustibleNecesario(Double.parseDouble(accion[2])));
						resultado=true;
					}	
				}else {
					mensajeError="No existe ese modelo";
				}		
			}
			break;
		case "llenarDeposito":
			if (accion.length==2) {
				if (automoviles.containsKey(accion[1])) {
					automoviles.get(accion[1]).llenarDeposito();
					resultado=true;
				}else {
					mensajeError="No existe ese modelo";
				}	
			}else if (accion.length==3) {
				if (automoviles.containsKey(accion[1])) {
					devuelveMetodo=automoviles.get(accion[1]).llenarDeposito(Double.parseDouble(accion[2]));
					resultado=true;
				}else {
					mensajeError="No existe ese modelo";
				}
			} 
			break;
		}
		if (!resultado)	System.out.println(mensajeError);
		return resultado;
	}
	

}
