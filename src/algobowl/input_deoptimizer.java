package algobowl;

import java.util.ArrayList;
import java.util.Set;

import javafx.util.Pair;

public class input_deoptimizer {
	int temperature;
	static final int LOCAL_SEARCH = 10;
	
	public input_deoptimizer(int temperature) {
		this.temperature = temperature;
		
	}
	
	public Pair<Integer,ArrayList<Pair<Integer,Set<Integer>>>> deoptimize(Pair<Integer,ArrayList<Pair<Integer,Set<Integer>>>> input) {
		Pair<Integer,ArrayList<Pair<Integer,Set<Integer>>>> next;
		int delta;
		double prob = 1;
		
		while(true) {
			if(temperature == 0) {
				return input;
			}
			next = randomSuccessor(input);
			delta = getMetric(input); 
			if (delta > 0) {
				input = next;
				prob = 1;
			}
			else {
				input = next;
				prob = Math.exp(delta/temperature);
			}
		}
	}
	
	public Pair<Integer,ArrayList<Pair<Integer,Set<Integer>>>> randomSuccessor(Pair<Integer,ArrayList<Pair<Integer,Set<Integer>>>> input) {
		return input;
	}
	
	public int getMetric(Pair<Integer,ArrayList<Pair<Integer,Set<Integer>>>> input) {
		return 0;
	}
}
