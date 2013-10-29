package source;

import java.util.ArrayList;
import java.util.Comparator;


public class Student implements Comparable<Student> {
	
	public int identificacion;
	public String apellido;
	public double promedio;
	//Student s = new Student("Desconocido", 0.0, 0);
	
	
	public Student(String apellido, double promedio, int id){
		
		this.apellido = apellido;
		this.promedio = promedio;
		this.identificacion = id;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId() {
		return identificacion;
	}

	public void setId(int id) {
		this.identificacion = id;
	}
	
	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	public int compareTo(Student o) {
		//return this.apellido.compareTo(o.getApellido());
		return Double.compare(this.getPromedio(), o.getPromedio());
		
	}

	public String toString() {
		return String.format("[%d - %s - %.1f ]", identificacion, apellido, promedio);
	}
	

}
