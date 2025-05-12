package Ejercicio2;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA{
	/* Para implementar el seguimiento de las modificaciones de un nodo,
	 * agrego un atributo "mod" a la subclase NodoClave, que se incrementa en 1
	 * cada vez que se usa el método agregar() en una clave ya existente.
	 * */

	private class NodoClave { //la c�lula de la estructura de claves
		int clave; //la clave
		int valor; //el valor
		int mod = 0; //la cantidad de veces que fué modificado
		NodoClave sigClave; //la referencia a la siguiente clave
	}
	
	private NodoClave origen; //la referencia de la estructura
	
	public void inicializarDiccionario() {
		// Complejidad O(1)
		origen = null;
	}
	
	public void agregar(int clave, int valor) {
		// Complejidad O(1) en el mejor caso, O(n) en el peor caso
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) { //la clave no existe
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc; //nuevo origen
		} else {
			nc.mod += 1;
		}
		nc.valor = valor;
	}
	private NodoClave Clave2NodoClave(int clave){
		// Complejidad O(1) en el peor caso, O(n) en el peor caso
		NodoClave aux = origen; //el nodo viajero
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}
	public void eliminar(int clave) {
		// Complejidad O(1) en el mejor caso, O(n) en el peor caso
		if (origen != null) {
			if (origen.clave == clave) { //es el primero
				origen = origen.sigClave;
			}
			else { //es alg�n otro
				NodoClave aux = origen; //el nodo viajero
				while (aux.sigClave != null && aux.sigClave.clave != clave){
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}
	public int recuperar(int clave) {
		//Complejidad O(1), O(n) en el peor caso porque Clave2NodoClave itera la estructura
		NodoClave nc = Clave2NodoClave(clave);
		return nc.valor;
	}
	
	public int recuperarMod(int clave) {
		//Complejidad O(1), O(n) en el peor caso porque Clave2NodoClave itera la estructura
		NodoClave nc = Clave2NodoClave(clave);
		return nc.mod;
	}
	
	public ConjuntoTDA claves() {
		//Complejidad O(1) en el mejor caso, O(n) en el peor caso
		ConjuntoTDA c = new ConjuntoTDA();
		c.inicializarConjunto();
		NodoClave aux = origen; //el nodo viajero
		while (aux != null) {
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}
}
