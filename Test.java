package source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Test{
	
	/**
	 * @param args
	 */
	
	static Student s = new Student("Desconocido", -1, -1);
	
	public static int aderecha(ArrayList<Student> list, int desde, double promedio){
		int n = 0;
		desde++;
		if(list.size()-1 == desde)
		return n;
		while(desde < list.size()){
			if(list.get(desde).getPromedio() == promedio){
				n++;
				desde++;
			}
			else{
				return n;
			}
		}
		return n;
		
	}
	
	public static int aizquierda(ArrayList<Student> list, int desde, double promedio){
		int n = 0;
		desde--;
		if(desde <= 0)
		return n;
		while(desde >= 0){
			if(list.get(desde).getPromedio() == promedio){
				n++;
				desde--;
			}
			else{
				return n;
			}
		}
		return n;
		
	}
	
	public static Student buscar_m(ArrayList<Student> list, double promedio, int n){
		
		int inicio = 0; 
		int fin = list.size() - 1;               //list.length - 1; 
		int medio; 
		
		if(n < 1){
			System.out.println("Índice de busqueda no válido");
			return s;
		}
		
		while (inicio <= fin) 
		{
		medio = (inicio+fin)/2; 
		if  (Double.compare(list.get(medio).getPromedio(), promedio) < 0)//(list.get(medio).compareTo(x) < 0) //(A[medio] < X) 
			inicio = medio + 1;
		else if (Double.compare(list.get(medio).getPromedio(), promedio) > 0)//(list.get(medio).compareTo(x) > 0) //(A[medio] > X)
				fin = medio - 1;
			else {
				int iz = aizquierda(list, medio,promedio );
				int der = aderecha(list, medio,promedio );
				if(iz + der + 1 < n){
					System.out.println("No hay " + n + " Estudiante(s) con este promedio");
					return s;
					
				}
				if(iz + der == 0)
					return list.get(medio);   //medio;
				int p = medio - iz;
				n--;
				System.out.println("El estudiante es: ");
				return list.get(p + n);
				
			}
		}
		System.out.println("Estudiante con ese promedio no existe");
		return s;               //-1;
		
		}
	
	/*public static Student buscar_n(ArrayList<Student> list, double promedio){
		
		int inicio = 0; 
		int fin = list.size() - 1;               //list.length - 1; 
		int medio; 
		
		while (inicio <= fin) 
		{
		System.out.println("inicio: " + inicio);
		System.out.println("fin: " + fin);
		medio = (inicio+fin)/2; 
		System.out.println("medio: " + medio);
		if  (Double.compare(list.get(medio).getPromedio(), promedio) < 0)//(list.get(medio).compareTo(x) < 0)                                  //(A[medio] < X) 
			inicio = medio+1;
		else if (Double.compare(list.get(medio).getPromedio(), promedio) > 0)//(list.get(medio).compareTo(x) > 0)                   //(A[medio] > X)
				fin = medio -1;
			else return list.get(medio);   //medio; 
		}
		System.out.println("Estudiante con ese promedio no existe");
		return s;               //-1;
		
		}
	
	public static Student buscar(ArrayList<Student> list, Student x){
		
		int inicio = 0; 
		int fin = list.size() - 1;               //list.length -1;
		int medio; 
		
		while (inicio <= fin) 
		{
		medio = (inicio+fin)/2; 
		if  (list.get(medio).compareTo(x) < 0)                                  //(A[medio] < X) 
			inicio = medio+1;
		else if (list.get(medio).compareTo(x) > 0)                   //(A[medio] > X)
				fin = medio -1;
			else return list.get(medio);   //medio; 
		}
		
		return s;               //-1;
		
		}
		
		//return x;
		
	
	public static Student busqueda(ArrayList<Student> list, Student X, int inicio, int fin){
		int medio; 
		if (inicio > fin) return s;
			else
			{
				medio = (inicio+fin)/2; 
				if (list.get(medio).compareTo(X) > 0) return busqueda(list,X,medio+1,fin);
				else if (list.get(medio).compareTo(X) < 0) return busqueda(list,X,inicio,medio -1);
				else return list.get(medio); 
		}
		
	}*/
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		ArrayList<Student> my = new ArrayList<Student>();
		
		Student x = new Student("Alarcon", 4.5, 001);
		Student y = new Student("Paez", 4.5, 002);
		Student z = new Student("Rodriguez", 3.1, 003);
		Student w = new Student("Saenz", 4.7, 004);
		Student t = new Student("Manrique", 4.0, 005);
		Student r = new Student("Burns", 4.5, 006);
		
		my.add(r);my.add(x);my.add(t);my.add(y);my.add(w);my.add(z);
		
		Comparator<Student> by_Id = new ById( );
		Comparator<Student> by_Prom = new ByPromedio( );
		
		System.out.println("La lista es: [Identificación - Apellido - Promedio]");
		for (Student s : my) {
			System.out.println(s.toString());
		}
		System.out.println("\n");
		
		Collections.sort(my);
		System.out.println("La lista Ordenada por promedio es: [Identificación - Apellido - Promedio]");
		for (Student s : my) {
			System.out.println(s.toString());
		}
		System.out.println("\n");
		
		Scanner input= new Scanner(System.in);
		System.out.print("Ingrese el promedio a buscar (Ej: 4,7): ");
		double k = input.nextDouble();
		
		System.out.print("Ingrese el estudiante (n) con este promedio a buscar(Ej: 1): ");
		int l = input.nextInt();
		
		System.out.println("\n");
		
		System.out.println(buscar_m(my, k, l));
		
		
	}

}
