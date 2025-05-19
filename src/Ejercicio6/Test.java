package Ejercicio6;

public class Test {
	public static void main (String[] args) {
		/* Para este ejercicio, defino el método diccionario2Cola().
		 * Al pasarle el diccionario, crea un conjunto de claves y un 
		 * conjunto que guardará los valores únicos de todo el diccionario.
		 * Itero todas las claves del diccionario, accediendo a sus valores 
		 * y agregandolos al conjunto 'unicos'.
		 * Luego, itero el conjunto, y cada valor es acolado en la cola.
		 * */
		DiccionarioMultipleDin dict = new DiccionarioMultipleDin();
		int[] clavesPrueba = {4,6,9,8};
		int[][] valoresPrueba = {{4,5,6},{7,5,8,9},{4,8,7,5},{7,4,5,9,0,4}};
		
		for (int i = 0; i < clavesPrueba.length; i++) {
		    for (int j = 0; j < valoresPrueba[i].length; j++) {
		        dict.agregar(clavesPrueba[i], valoresPrueba[i][j]);
		    }
		}
		
		ColaDin colaPrueba = diccionario2Cola(dict);
		System.out.println("Valores unicos del diccionario:");
		
		String cadena = "";
		while (!colaPrueba.colaVacia()) {
			cadena += colaPrueba.primero() + " ";
			colaPrueba.desacolar();
		}
		
		System.out.println(cadena);
		
		}
	
	public static ColaDin diccionario2Cola(DiccionarioMultipleDin diccionario) {
		// Complejidad O(n^2) en el peor caso, O(1) en el mejor caso.
		ConjuntoTDA claves = diccionario.claves();
		ConjuntoTDA unicos = new ConjuntoTDA();
		unicos.inicializarConjunto();
		
		while (!claves.conjuntoVacio()) {
			int claveActual = claves.elegir();
			ConjuntoTDA valoresClaveActual = diccionario.recuperar(claveActual);
			
			while (!valoresClaveActual.conjuntoVacio()) {
				int valorActual = valoresClaveActual.elegir();
				unicos.agregar(valorActual);
				valoresClaveActual.sacar(valorActual);
			}
			
			claves.sacar(claveActual);
		}
		
		ColaDin valoresUnicosDiccionario = new ColaDin();
		valoresUnicosDiccionario.inicializarCola();
		while (!unicos.conjuntoVacio()) {
			int valorAcolar = unicos.elegir();
			valoresUnicosDiccionario.acolar(valorAcolar);
			unicos.sacar(valorAcolar);
		}
		
		return valoresUnicosDiccionario;
	}
}


