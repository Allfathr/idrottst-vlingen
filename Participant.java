// Anton Sandström ansa6928
// Jesper Jönsson jeja6606

import java.util.ArrayList;

public class Participant {
	
	private ArrayList<Result> allResults = new ArrayList<>();
	private String firstName, lastName, teamName;
	private int participantNumber;
		
	public Participant(String firstName, String lastName, String teamName, int participantNumber) {
		this.firstName = firstName; 
		this.lastName = lastName;
		this.teamName = teamName;
		this.participantNumber = participantNumber;
	}
		
	public Result getResult(Event e) {
		for (Result r : allResults) {
			if (r.getEvent().getName().equals(e.getName())) {
				return r;
			}
		}
		return null;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public int getParticipantNumber() {
		return participantNumber;
	}
	
	public void addResult(Result result) {
		allResults.add(result);
	}
	
	public void printResults() {
		for (Result r : allResults) {
			System.out.println(r.toString());
		}
	}
	
	public String toString() {
		return firstName + " " + lastName + " from " + teamName;
	}
	
	public String toStringWithNumber() {
		return firstName + " " + lastName + " from " + teamName + " with number " + participantNumber;
	}
	
}
