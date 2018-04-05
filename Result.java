// Anton Sandström ansa6928
// Jesper Jönsson jeja6606

import java.util.Arrays;

public class Result {
	
	private Event event;
	private Participant participant;
	private int tries = 0;
	// deklarerar en Array med doubles
	private double[] resultAttempts;

	public Result(Event event, Participant participant, double result) {
		this.event = event;
		this.participant = participant;
		
		// allokerar plats i arrayen för så många försök grenen har
		resultAttempts = new double[event.getAttempts()];
		resultAttempts[tries] = result;
		tries++;
	}
	
	public double bestResult() {
		double best = -1;
		for (int i = 0; i < tries; i++) {
			if (resultAttempts[i] > best) {
				best = resultAttempts[i];
			}
		}
		return best;
	}
		
	public String toString() {
		return String.format("Results for %s in %s: %s", participant.getFullName(),
							event.getName(), Arrays.toString(resultAttempts)); 
	
	}
	
	public Participant getParticipant() {
		return participant;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public int getTries() {
		return tries;
	}
	
//	public double[] getResultAttempts() {
//		return resultAttempts;
//	}
	
	public void addTries(double resultTries) {
		System.out.println(resultAttempts.length);
		resultAttempts[tries] = resultTries;
		tries++;
	}
	
}
