// Anton Sandström ansa6928
// Jesper Jönsson jeja6606

import java.util.ArrayList;
import java.util.Collections;

public class Event {

	private ArrayList<Result> allResults = new ArrayList<>();
	private String name;
	private int attempts;
	
	public Event(String name, int attempts) {
		this.name = name;
		this.attempts = attempts;
	}

	public String getName() {
		return name;
	}
	
	public int getAttempts() {
		return attempts;
	}
	
	public void addResult(Result result) {
		allResults.add(result);
	}
	
	
	public void printResultList() {
		System.out.println(allResults);
		
	}
	
	public void removePartResult(Participant p) {
		for (Result r : allResults) {
			if (r.getParticipant().getParticipantNumber() == p.getParticipantNumber()) {
				allResults.remove(r);
				break;
			}
		}
	}
	
	public void getHighScore() {
		sortResult();
		int placing = 0;
		double prevResult = -1;
		for (int i = 0; i < allResults.size(); i++) {
			if (allResults.get(i).bestResult() != prevResult) {
				placing = i + 1;
				prevResult = allResults.get(i).bestResult();
				
			}
			System.out.println(placing + " " + allResults.get(i).bestResult() 
								+ " " + allResults.get(i).getParticipant());
		}
	}
	
	// Använder en insertion sort och collection klassen
	private void sortResult() {
		for (int i = 1; i < allResults.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (allResults.get(j).bestResult() > allResults.get(j - 1).bestResult()) {
					Collections.swap(allResults, (j - 1), j);
				}
				else if (allResults.get(j).bestResult() == allResults.get(j - 1).bestResult()) {
					if (allResults.get(j).getParticipant().getFullName().compareTo(allResults.get(j - 1).getParticipant().getFullName()) < 0) {
						Collections.swap(allResults, (j - 1), j);
					}
				}
			}
		}
	}
}
