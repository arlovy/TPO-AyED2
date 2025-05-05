package Ejercicio1;

public interface ConjuntoTDA {
	public void inicializarConjunto();
	public boolean conjuntoVacio();
	public void agregar(int x);
	public int elegir();
	public void sacar(int x);
	public boolean pertenece(int x);
}
