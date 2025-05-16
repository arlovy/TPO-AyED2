package Ejercicio5;

public class Test {
	/* Nuevamente en la PilaTDA defino el método copiaPila() para no 
	 * destruir la pila original al utilizar el método.
	 * Después, en el método cantidadApariciones() creo un diccionario simple,
	 * para luego ir desapilando la pila. Si el valor de tope de la pila está en las
	 * claves del diccionario, incremento en 1 su valor, si no, inicializo el nodo con valor
	 * 1.
	 * */
	public static void main(String[] args) {
		int[] valoresPrueba = {4,3,6,6,6,7,8,4};
		PilaTDA pila = new PilaTDA();
		
		for (int i = 0; i < valoresPrueba.length; i++) {
			pila.apilar(valoresPrueba[i]);
		}
		
		DiccionarioSimpleDin cantidadApariciones = cantidadApariciones(pila);
		
		System.out.println(cantidadApariciones.recuperar(6));
		System.out.println(cantidadApariciones.recuperar(4));
		System.out.println(cantidadApariciones.recuperar(3));
		
	}
	
	public static DiccionarioSimpleDin cantidadApariciones(PilaTDA pila) {
		// Complejidad O(n^2) en el peor caso, O(1) en el mejor caso.
		PilaTDA copia = pila.copiaPila();
		DiccionarioSimpleDin dict = new DiccionarioSimpleDin();
		
		while (!copia.pilaVacia()) {
			int tope = copia.tope();
			if (!dict.claves().pertenece(tope)) {
				dict.agregar(tope, 1);
			} else {
				dict.agregar(tope, dict.recuperar(tope) + 1);
			}
			copia.desapilar();
		}
		
		return dict;
	}
}
