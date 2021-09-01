package listaCircularSimple;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class App {
	
	public static void main(String[] args) throws IOException{
		Sistema system = new SistemaImpl();
		Lectura(system);
		System.out.println(system.obtenerInfo());
		try {
			System.out.println(system.encontrarString("Rut4"));
			system.eliminarPorRut("Rut1");
		} 
		catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n");
		System.out.println(system.obtenerInfo());
	}

	private static void Lectura(Sistema system) throws IOException{
		File file = new File("Jugadores.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String banana = scan.nextLine();
			String [] partes = banana.split(",");
			String rut = partes[0];
			int edad = Integer.parseInt(partes[1]);
			int sueldo = Integer.parseInt(partes[2]);
			system.ingresarJugador(rut, edad, sueldo);	
		} 	
		
	}

}
