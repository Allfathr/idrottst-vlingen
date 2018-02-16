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
	
	public Participant() {
		
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
		System.out.println("Results for " + getFullName());
	}
	
	public String toString() {
		return firstName + " " + lastName + " from " + teamName;
	}
	
	public String toStringWithNumber() {
		return firstName + " " + lastName + " from " + teamName + " with number " + participantNumber;
	}
	
}
