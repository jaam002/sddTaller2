package source;

import java.util.Arrays;

public class Permutacion {

	/**
	 * @param args
	 */
	
	// método para imprimir las permutaciones hechas
	protected static void printPermutations( Comparable[] c ) {
		int permutaciones = 1;
		insertionsort(c);//ordena el arreglo de menor a mayor
		System.out.println("El arreglo es: " + Arrays.toString( c ) + "\n" );
		while ( ( c = nextPermutation( c ) ) != null ) {
			permutaciones++;
			System.out.println( Arrays.toString( c ) );
		}
		System.out.println("\n Número de permutaciones: " + permutaciones);
	}
	//método para modificar el arreglo a su siguiete permutación o retornar nulo si no hay
	//más permutaciones posibles

	private static Comparable[] nextPermutation( final Comparable[] c ) {
		// encontrar el k más grande, tal que c[k] < c[k+1]
		int first = getFirst( c );
		if ( first == -1 ) return null; 
		//encontramos el carácter de menor valor que sea mayor a este, y que está en el intervalo [k,toswap]
		int toSwap = c.length - 1;
		while ( c[ first ].compareTo( c[ toSwap ] ) >= 0 )
			--toSwap;
		//intercambiamos los elementos
		swap( c, first++, toSwap );
		//revertimos la secuencia desde k+1 a n
		toSwap = c.length - 1;
		while ( first < toSwap )
			swap( c, first++, toSwap-- );
		return c;
	}

	// encontrar el k más grande, tal que c[k] < c[k+1]
	private static int getFirst( final Comparable[] c ) {
		for ( int i = c.length - 2; i >= 0; --i )
			if ( c[ i ].compareTo( c[ i + 1 ] ) < 0 )
				return i;
		return -1;
	}

	// cambia dos elementos entre si, en el arreglo
	private static void swap( final Comparable[] c, final int i, final int j ) {
		final Comparable tmp = c[ i ];
		c[ i ] = c[ j ];
		c[ j ] = tmp;
	}
	
	//ordenar el arreglo
	private static void insertionsort(Comparable [] arr){
		int i, j;
		Comparable newValue;
		for (i = 1; i < arr.length; i++) {
			newValue = arr[i];
			j = i;
			while (j > 0 && arr[j - 1].compareTo(newValue) > 0) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = newValue;
		}
	}
	
}
