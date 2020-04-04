package repaso2ev;

public class Matrices {

	//cuadrada1
	static int[][] cuadrada1(int dim) {
		int contador=0;
		int matriz[][] = new int[dim][dim];
		for (int col = 0; col < dim; col++) {
			for (int fil = 0; fil < dim; fil++) {
				contador++;
				matriz[fil][col] = contador;
			}
		}
		return matriz;
	}
	
	//cuadrada2
	static int[][] cuadrada2(int dim) {
		int contador=0;
		int matriz[][] = new int[dim][dim];
		for (int col = 0; col < dim; col++) {
			if (col % 2 == 0) {
				for (int fil = 0; fil < dim; fil++) {
					contador++;
					matriz[fil][col] = contador;
				}
			} else {
				for (int fil=dim-1; fil>=0; fil--) {
					contador++;
					matriz[fil][col] = contador;
				}
			}
		}
		return matriz;
	}
	

	//palindromos
	static String[][] palindromos(int c, int f) {
		if ((c >= 1 && c <= 26) && (f >= 1 && f <= 26)) {
			String matriz[][] = new String[f][c];
			for (int fil = 0; fil<f; fil++) {
				for (int col=0; col<c; col++) {
					//Si el carácter central del palindromo pasa de la z se deja siempre z
					if (fil+col+97>122) 
					{
						matriz[fil][col]=Character.toString((char)(fil+97))+"z"+ Character.toString((char)(fil+97));
					}else 
					{
						matriz[fil][col]=Character.toString((char)(fil+97))+Character.toString((char)(fil+col+97))+Character.toString((char)(fil+97));
					}
				}
			}
			return matriz;
		}else {
			return null;
		}
	}
	
	//max3x3sum
	static int max3x3sum(int[][] matriz) {
		int maximo = 0;
		if (matriz.length>=3 && matriz[0].length>=3) 
		{
			for (int fil=0; fil<=(matriz.length-3); fil++) 
			{
				for (int col=0; col<=(matriz[fil].length-3); col++) {
					int suma = 0;
					for (int i = fil; i <= (fil + 2); i++) 
					{
						for (int j = col; j <= (col + 2); j++) 
						{
							suma += matriz[i][j];
						}
					}
					if (suma > maximo) maximo = suma;
				}
			}
		}
		return maximo;
	}
	
}
