package Ejercicio2;

public class Test {

	public static void main(String[] args) {
		// (7,3), (16,4), (3,4), (16,2), (3,6), (5,3)
		DiccionarioSimpleMod diccionario = new DiccionarioSimpleMod();
		
		diccionario.agregar(7, 3);
		diccionario.agregar(16, 4);
		diccionario.agregar(3, 4);
		diccionario.agregar(16, 2);
		diccionario.agregar(3, 6);
		diccionario.agregar(5, 3);
		
		ConjuntoTDA claves = diccionario.claves();
		System.out.println(claves.pertenece(2));
		System.out.println(claves.pertenece(3));
		
		System.out.println(diccionario.recuperarMod(3)); // 1, fue modificado 1 vez
		System.out.println(diccionario.recuperarMod(7)); // 0, no fue modificado
		
	}

}
