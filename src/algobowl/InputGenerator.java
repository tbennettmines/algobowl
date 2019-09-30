package algobowl;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Runtime iterator for the input deoptimizer algorithm.
 * <br>
 * @author Kane Bruce
 */
public class InputGenerator {

	private static int[] U;
	private static Random r;
	
	public static void main(String[] args) {
		r = new Random();
		U = new int[1000];
		// Generate U = {1, 2, ... , 1000}
		for (int i = 0; i < U.length; i++)
			U[i] = i+1;
		ArrayList<Set<Integer>> subsets = new ArrayList<Set<Integer>>();
		int m = r.nextInt(500) + 1;
		int[] weights = new int[m];
		
		// Generate m random subsets of U
		for (int j = 0; j < m; j++) {
			Set<Integer> s_m = new HashSet<Integer>();
			int size = r.nextInt(U.length + 1);
			
			for (int k = 0; k < size; k++) {
				int num = U[r.nextInt(U.length)];
				if ( !(s_m.contains(num)) )
					s_m.add(num);
				else
					k--;
			}
			
			weights[j] = r.nextInt(999) + 1;
			subsets.add(s_m);
		}
		String str = "";
		// n = length of U
		str = str.concat(U.length + "\n");
		// m subsets of U
		str = str.concat(m + "\n");
		int counter = 1;
		for (Set<Integer> s : subsets) {
			for (int num : s)
				str = str.concat(num + " ");
			str = str.concat("\n" + weights[counter-1] + "\n");
			counter++;
		}
		
		// Output to a correctly-formatted text file
		Path p = Paths.get("./input.txt");
		byte[] data = str.getBytes();
	    OutputStream out = null;
	    try {
	    	out = new BufferedOutputStream(
	    	      Files.newOutputStream(p, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING));
	    	out.write(data, 0, data.length);
	    } catch (IOException x) {
	    	System.err.println(x);
	    } finally {
	    	try {
	    		if (out != null) {
	    			out.close();
	    		}
	    	} catch (Exception e) {}
	    }
	}
}
