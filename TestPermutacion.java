package source;

public class TestPermutacion  extends Permutacion implements Comparable<Double> {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Comparable[] m = new Comparable[5];
			m[0]= 10;
			m[1]= 5;
			m[2]= 7;
			m[3]= 3;
			m[4]= 2;
			
			printPermutations(m);
	}

	@Override
	public int compareTo(Double arg0) {
		// TODO Auto-generated method stub
		return this.compareTo(arg0);
	}

}
