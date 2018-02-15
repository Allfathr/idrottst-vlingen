public class Participant {
	
	private String firstName, lastName, teamName;
	private int participantNumber;
	
	public Participant(String firstName, String lastName, String teamName, int participantNumber) {
		this.firstName = firstName; 
		this.lastName = lastName;
		this.teamName = teamName;
		this.participantNumber = participantNumber;
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
	
	public String toString() {
		return firstName + " " + lastName + " from " + teamName;
	}
	
	public String toStringWithNumber() {
		return firstName + " " + lastName + " from " + teamName + " with number " + participantNumber;
	}
	
}
