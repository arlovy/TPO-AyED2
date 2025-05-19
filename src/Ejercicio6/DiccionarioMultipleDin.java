package Ejercicio6;

public class DiccionarioMultipleDin {
	private class NodoClave { //la c�lula de la estructura de claves
		int clave; //la clave
		NodoValor valores; //la referencia a la lista de valores
		NodoClave sigClave; //la referencia a la siguiente clave
	}
	
	private class NodoValor { //la c�lula de las estructuras de valores
		int valor; //el valor almacenado
		NodoValor sigValor; //la referencia al siguiente valor
	}
	
	private NodoClave origen; //la referencia de la estructura
	
	public void inicializarDiccionario() {
		origen = null;
	}
	
	public void agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) { //la clave no existe
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc; //nuevo origen
		}
		NodoValor aux = nc.valores; //nodo viajero
		while (aux != null && aux.valor != valor) {
			aux = aux.sigValor;
		}
		if (aux == null) { //el valor no existe
			NodoValor nv = new NodoValor();
			nv.valor = valor;
			nv.sigValor = nc.valores;
			nc.valores = nv; //nuevo origen de valores
		}
	}
	
	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen; //el nodo viajero
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}
	
	public void eliminarValor(int clave, int valor) {
		if (origen != null) {
			if (origen.clave == clave) { //es en el primero
				EliminarValorEnNodo(origen, valor);
				if (origen.valores == null) { //qued� vac�o
					origen = origen.sigClave;
				}
			} else { //es en alg�n otro
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					EliminarValorEnNodo(aux.sigClave, valor);
					if (aux.sigClave.valores == null) { //qued� vac�o
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
			}
		}
	}
	
	private void EliminarValorEnNodo(NodoClave nodo, int valor) {
		if (nodo.valores != null) {
			if (nodo.valores.valor == valor) { //es el primero
				nodo.valores = nodo.valores.sigValor;
			} else { //es alg�n otro
				NodoValor aux = nodo.valores;
				while (aux.sigValor != null && aux.sigValor.valor != valor) {
					aux = aux.sigValor;
				}
				if (aux.sigValor != null) {
					aux.sigValor = aux.sigValor.sigValor;
				}
			}
		}
	}
	
	public void eliminar(int clave) {
		if (origen != null) {
			if (origen.clave == clave) { //es el primero
				origen = origen.sigClave;
			} else { //es alg�n otro
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}
	
	public ConjuntoTDA recuperar(int clave) {
		NodoClave nc = Clave2NodoClave(clave);
		ConjuntoTDA c = new ConjuntoTDA();
		c.inicializarConjunto();
		if (nc != null) {
			NodoValor aux = nc.valores;
			while (aux != null) {
				c.agregar(aux.valor);
				aux = aux.sigValor;
			}
		}
		return c;
	}
	
	public ConjuntoTDA claves() {
		ConjuntoTDA c = new ConjuntoTDA();
		c.inicializarConjunto();
		NodoClave aux = origen;
		while (aux != null) {
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}
}