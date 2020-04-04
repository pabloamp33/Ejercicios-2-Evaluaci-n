package repaso2ev;

import repaso2ev.Matrices;
import java.util.Scanner;
import java.util.Random;


	public class PruebaMatrices {
		
		public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);
		
			//Llamadas a metodos de la clase Matrices
			
			//cuadrada1
			System.out.println("Introduce dimensión matriz cuadrada1: ");
			int dim = scan.nextInt();
			int[][] cuadrada1 = Matrices.cuadrada1(dim);
			for (int fil=0; fil<cuadrada1.length; fil++) {
				for (int col=0; col<cuadrada1[fil].length; col++) {
					System.out.print(cuadrada1[fil][col] + "\t");
				}
				System.out.println();
			}
			System.out.println();
			

			
			//cuadrada2
			System.out.println("Introduce dimensión matriz cuadrada2: ");
			dim = scan.nextInt();
			int[][] cuadrada2 = Matrices.cuadrada2(dim);
			for (int fil=0; fil<cuadrada2.length; fil++) {
				for (int col=0; col<cuadrada2[fil].length; col++) {
					System.out.print(cuadrada2[fil][col] + "\t");
				}
				System.out.println();
			}
			System.out.println();
			

			
			//palindromos
			System.out.println("Columnas y Filas palindromos");
			System.out.println("Introduzca filas (1..26): ");
			int filas= scan.nextInt();
			System.out.print("Introduzca columnas (1..26): ");
			int columnas = scan.nextInt();
			String[][] palindromos = Matrices.palindromos(columnas,filas);
			if (palindromos != null) {
				for (int fil = 0; fil < palindromos.length; fil++) {
					for (int col = 0; col < palindromos[fil].length; col++) {
						System.out.print(palindromos[fil][col] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("La matriz excede de los limites");
			}
			System.out.println();
			

			
			//max3x3sum
			System.out.println("Columnas y filas max3x3sum");
			System.out.print("Introduzca filas (>= 3): ");
			filas= scan.nextInt();
			System.out.print("Introduzca columnas (>= 3): ");
			columnas = scan.nextInt();
			int[][] max3x3sum = new int[filas][columnas];
			llenaMatriz(max3x3sum);
			for (int fil = 0; fil < max3x3sum.length; fil++) {
				for (int col = 0; col < max3x3sum[fil].length; col++) {
					System.out.print(max3x3sum[fil][col] + "\t");
				}
				System.out.println(); 
			}
			int maximo = Matrices.max3x3sum(max3x3sum);
			System.out.println("El máximo de todos los resultados que se obtienen sumando los elementos de cada matriz de 3x3 es "+ maximo);

			scan.close();
		}

		
		//metodos auxuliares
		
		//Llena aleatoriamente con numeros una matriz que le llega como parámetro
		static void llenaMatriz(int[][] matriz) {
			Random random = new Random();
			for (int fil = 0; fil < matriz.length; fil++)
				for (int col = 0; col < matriz[fil].length; col++)
					matriz[fil][col] = random.nextInt(50);
		}

		
}
