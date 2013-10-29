package source;

import java.util.Comparator;

public class ByPromedio implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		
		// TODO Auto-generated method stub
		/*double in = a.getPromedio();
		double ou = b.getPromedio();
		int q = Double.compare(in, ou);
		return q;*/
		return Double.compare(a.getPromedio(), b.getPromedio());
	}

}
