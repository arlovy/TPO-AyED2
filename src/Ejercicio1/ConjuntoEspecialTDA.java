package Ejercicio1;

public class ConjuntoEspecialTDA implements ConjuntoTDA{
	/*Basándome en la interfaz ConjuntoTDA,  defino la clase ConjuntoEspecialTDA 
	  y una subclase Nodo, que contiene dos variables; info (el valor que contiene el nodo) 
	  y sig (que apunta al nodo que le sigue).

	A diferencia del conjunto tradicional, cuando agrego un valor no verifico primero
	 si este está en el conjunto, permitiendo así acepciones múltiples de un elemento. 

	Además, en el método sacar(x), itero todos los elementos del conjunto y verifico 
	para cada nodo que su valor sea igual a x. Si es igual, elimino el nodo de la lista.
	Primero itero los primeros nodos si estos son iguales a x, y luego los nodos intermedios.*/
	
	private class Nodo {
		int info;
		Nodo sig;
	}
	
	Nodo ref;
	
	public ConjuntoEspecialTDA() {
		inicializarConjunto();
	}
	
	public void inicializarConjunto() {
		// Complejidad O(1)
		ref = null;
	}
	
	public void agregar(int x) {
		// Complejidad O(1)
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = ref;
		ref = nuevo;
	}
	
	public int elegir() {
		// Complejidad O(1)
		return ref.info;
	}
	
	public void sacar(int x) {
		// Complejidad O(n) en el peor caso, O(1) en el mejor caso
		if (!conjuntoVacio()) {

			// Reviso si los primeros nodos tienen el valor a eliminar
			while(ref != null && ref.info == x) {
				ref = ref.sig;
			}
			
			/* hago un nodo de soporte que me permite ir revisando el valor
			 * del nodo siguiente, de forma que si tiene el valor a eliminar,
			 * me lo salteo.
			 * */
			Nodo pivote = new Nodo();
			pivote.sig = ref;

			while (pivote.sig != null) {
				if (pivote.sig.info == x) {
					pivote.sig = pivote.sig.sig;
				} else {
					pivote = pivote.sig;
				}
			}
		}
	}
	
	public boolean pertenece(int x) {
		// Complejidad O(n) en el peor caso, O(1) en el mejor caso
		Nodo pivote = ref;
		while (pivote != null && pivote.info != x)
			pivote = pivote.sig;
		return (pivote != null);
	}
	
	public boolean conjuntoVacio() {
		// Complejidad O(1)
		return (ref == null);
	}
	
	public String imprimirConjunto() {
		// Complejidad O(n) en el peor caso, O(1) en el mejor caso
		if (!conjuntoVacio()) {
			Nodo pivote = ref;
			String cadena = "";
			while (pivote != null) {
				cadena += (pivote.info + " ");
				pivote = pivote.sig;
			}
			return cadena;
		}
		return "";
	}
	
}
