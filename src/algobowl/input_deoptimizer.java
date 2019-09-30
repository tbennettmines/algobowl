package algobowl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;

import javafx.util.Pair;

public class input_deoptimizer {
	int temperature;
	double threshold;
	int localSearch;
	Random rand;
	
	public input_deoptimizer(int temperature, double threshold) {
		this.temperature = temperature;
		this.threshold = threshold;
		this.rand = new Random();
	}
	
	public Pair<Integer, ArrayList<Pair<Integer,Set<Integer>>>> deoptimize(Pair<Integer, ArrayList<Pair<Integer,Set<Integer>>>> input) {
		Pair<Integer, ArrayList<Pair<Integer,Set<Integer>>>> next;
		int delta;
		double prob = 1;
		this.localSearch = (input.getValue().size())/10;
		while(true) {
			if(temperature == 0) {
				return input;
			}
			next = randomSuccessor(input);
			delta = getMetric(input); 
			if (delta > 0) {
				prob = 1;
				input = next;
			}
			else {
				prob = Math.exp(delta/temperature);
				if(prob > threshold) {
					input = next;
				}
			}
		}
	}
	
	public Pair<Integer, ArrayList<Pair<Integer,Set<Integer>>>> randomSuccessor(Pair<Integer, ArrayList<Pair<Integer,Set<Integer>>>> input) {
		Pair<Integer, ArrayList<Pair<Integer,Set<Integer>>>> next;
		ArrayList<Pair<Integer,Set<Integer>>> tempValue = input.getValue();
		for(int i = 0; i < localSearch;i++) {
			int first = rand.nextInt(input.getValue().size());
			int second = rand.nextInt(input.getValue().size());
			Collections.swap(tempValue, first, second);
		}
		next = new Pair(input.getKey(),tempValue);
		return next;
	}
	
	public int getMetric(Pair<Integer, ArrayList<Pair<Integer,Set<Integer>>>> input) {
		int distance = 0;
		
		return distance;
	}
}
