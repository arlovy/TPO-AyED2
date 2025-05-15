package Ejercicio4;

public class Test {

	public static void main(String[] args) {
		/*	Defino el método pilaRepetidos(), que declara dos conjuntos adentro.
		 * Uno de los conjuntos contendrá los valores únicos, y uno servirá como
		 * referencia para ver si el valor que se está analizando está repetido en la
		 * pila o no.
		 * Tras iterar toda la pila, retorno el conjunto de valores repetidos.
		 * 
		 * Además, implemento el método copiaPila() en la clase PilaTDA para copiar una pila, 
		 * de manera que el método pilaRepetidos() no destruya la pila original al realizar 
		 * un desapile.
		 * */
		int[] valoresPrueba = {3,3,6,2,6,7,8,4};
		PilaTDA pila = new PilaTDA();
		
		for (int i = 0; i < valoresPrueba.length; i++) {
			pila.apilar(valoresPrueba[i]);
		}
		
		ConjuntoTDA valoresRepetidos = pilaRepetidos(pila);
		System.out.println(valoresRepetidos.pertenece(7));
		System.out.println(valoresRepetidos.pertenece(3));
		System.out.println(valoresRepetidos.pertenece(6));
		System.out.println(valoresRepetidos.pertenece(4));
	}
	
	public static ConjuntoTDA pilaRepetidos(PilaTDA pila) {
		// Complejidad O(1) en el mejor caso, O(n) en el peor caso
		PilaTDA copiaPila = pila.copiaPila();
		ConjuntoTDA unicos = new ConjuntoTDA();
		ConjuntoTDA repetidos = new ConjuntoTDA();
	
		while(!copiaPila.pilaVacia()) {
			if (unicos.pertenece(copiaPila.tope())) {
				repetidos.agregar(copiaPila.tope());
			} else {
				unicos.agregar(copiaPila.tope());
			}
			copiaPila.desapilar();
		}
		
		return repetidos;
	}

}
