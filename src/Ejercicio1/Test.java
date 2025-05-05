package Ejercicio1;

public class Test {
	public static void main(String[] args) {
		ConjuntoEspecialTDA conjunto = new ConjuntoEspecialTDA();
		
		int[] valoresDePrueba = {18,2,7,4,18,22,2,7};
		for (int i = valoresDePrueba.length-1; i >= 0; i--) {
			conjunto.agregar(valoresDePrueba[i]);
		}
		
		System.out.println(conjunto.pertenece(18));
		System.out.println(conjunto.pertenece(2));
		System.out.println(conjunto.pertenece(4));
		System.out.println(conjunto.imprimirConjunto());
		conjunto.sacar(7);
		conjunto.sacar(18);
		conjunto.sacar(2);
		conjunto.sacar(22);
		conjunto.sacar(0);
		System.out.println(conjunto.imprimirConjunto());
	}
}
