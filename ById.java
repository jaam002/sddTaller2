package source;

import java.util.Comparator;

public class ById implements Comparator<Student>{

	@Override
	public int compare(Student a, Student b) {
		// TODO Auto-generated method stub
		return a.getId() - b.getId();
	}

}
