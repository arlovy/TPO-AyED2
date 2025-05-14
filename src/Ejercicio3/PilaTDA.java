package Ejercicio3;

public class PilaTDA implements PilaTDAInterfaz {
	/*	Para este ejercicio, recorro la pila y reviso la información
	 * de cada nodo. Si el modulo del nodo dividido por 2 es 0, incremento
	 * una variable contador en 1.
	 * Al finalizar la recorrida de la pila, retorno la variable.
	 * */
	private class Nodo { //la c�lula de la estructura
		int info; //el valor almacenado
		Nodo sig; //la referencia al siguiente nodo
	}
	
	private Nodo primero; //la referencia a la estructura
	
	public void inicializarPila() {
		// Complejidad O(1)
		primero = null;
	}
	
	public void apilar(int x) { //el nuevo elemento se agrega al inicio
		// Complejidad O(1)
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = primero;
		primero = nuevo; //nueva referencia a la estructura
	}
	
	public void desapilar() {
		// Complejidad O(1)
		primero = primero.sig; //nueva referencia a la estructura
	}
	
	public boolean pilaVacia() {
		// Complejidad O(1)
		return (primero == null);
	}
	
	public int tope() {
		// Complejidad O(1)
		return primero.info;
	}
	
	public int cantidadPares() {
		// Complejidad O(1) en el mejor caso, O(n) en el peor caso
		int contador = 0;
		
		if (!pilaVacia()) {
			Nodo pivote = primero;
			
			while (pivote.sig != null) {
				if ((pivote.info % 2) == 0) {
					contador += 1;
				}
				pivote = pivote.sig;
			}
		}

		return contador;
	}
}