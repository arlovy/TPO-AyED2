package Ejercicio3;

public class Test {
	public static void main(String[] args) {
		int[] valoresPrueba = {3,4,6,2,45,7,8};

		PilaTDA pila = new PilaTDA();
		pila.inicializarPila();
		
		System.out.println(pila.cantidadPares());
		
		for (int i = 0; i < valoresPrueba.length; i++) {
			pila.apilar(valoresPrueba[i]);
		}
		
		System.out.println(pila.cantidadPares());
	}
}
