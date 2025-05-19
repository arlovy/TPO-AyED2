package Ejercicio6;

public class ColaDin {
	private class Nodo { //la c�lula de la estructura
		int info; //el valor almacenado
		Nodo sig; //la referencia al siguiente nodo
	}

	private Nodo primero; //primer elemento (m�s antiguo)
	private Nodo ultimo; //�ltimo elemento (m�s reciente)
	
	public void inicializarCola(){
		primero = null;
		ultimo = null;
	}
	
	public void acolar(int x){
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = null;
		if (ultimo != null) //cola no vac�a
			ultimo.sig = nuevo;
		ultimo = nuevo;
		if (primero == null) //la cola estaba vac�a
			primero = nuevo;
	}
	
	public void desacolar(){
		primero = primero.sig; //nueva referencia a la estructura
		if (primero == null) //la cola qued� vac�a
			ultimo = null;
	}
	
	public boolean colaVacia(){
		return (ultimo == null);
	}
	
	public int primero(){
		return primero.info;
	}
}
