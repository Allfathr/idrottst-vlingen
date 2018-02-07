import java.util.ArrayList;
import java.util.Scanner;

public class Participant {
	
	private SportsMethods test = new SportsMethods();
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Integer> participantNumbers = new ArrayList<>();
	private ArrayList<Participant> allParticipants = new ArrayList<>();
	private String firstName, lastName, teamName;
	private int participantNumber;
	
	public Participant() {
		
	}
	
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
	
	public ArrayList<Integer> getNumberList() {
		return participantNumbers;
	}
	
	public ArrayList<Participant> getMemberList() {
		return allParticipants;
	}
	
	public String toString() {
		return firstName + " " + lastName + " from " + teamName;
	}
	
	public String toStringWithNumber() {
		return firstName + " " + lastName + " from " + teamName + " with number " + participantNumber;
	}
	
	public void addParticipant() {
		
		int incrementNumber = 100;
		String mainName;
		String surName;
		String nameOfTeam;
		
		do {
			System.out.print("First name: ");
			mainName = scan.nextLine();
			
			if (mainName == null || mainName.trim().isEmpty()) {
				System.out.println("Error: name can't be empty." );
			}
			else {
				mainName = test.capitalizeTrim(mainName);
			}
		} while (mainName == null || mainName.trim().isEmpty());
		
		do {
			System.out.print("Last name: ");
			surName = scan.nextLine();
			
			if (surName == null || surName.trim().isEmpty()) {
				System.out.println("Error: name can't be empty." );
			}
			else {
				surName = test.capitalizeTrim(surName);
			}
		} while (surName == null || surName.trim().isEmpty());
		
		do {
			System.out.print("Team: ");
			nameOfTeam = scan.nextLine();
			
			if (nameOfTeam == null || nameOfTeam.trim().isEmpty()) {
				System.out.println("Error: name can't be empty." );
			}
			else {
				nameOfTeam = test.capitalizeTrim(nameOfTeam);
				int competitionNumber = incrementNumber;
				incrementNumber++;
				Participant participant = new Participant(mainName, surName, nameOfTeam, competitionNumber);
				allParticipants.add(participant);
				participantNumbers.add(competitionNumber);
				System.out.println(mainName + " " + surName + " from " + nameOfTeam + " with number " 
				+ competitionNumber + " added.");
			}
		} while (nameOfTeam == null || nameOfTeam.trim().isEmpty());
	}
	
	public void removeParticipant() {
		
		boolean removed = false;
		int removeNumber;
		
		do {
			System.out.print("Number: ");
			removeNumber = scan.nextInt();
			
			scan.nextLine();
			
			for (int i = 0; i < allParticipants.size(); i++) {
				Participant tempParticipant = allParticipants.get(i);
				if (tempParticipant.getParticipantNumber() == removeNumber) {
					removed = true;
				}
				
				if (removed) {
					System.out.println(tempParticipant.toStringWithNumber() + " removed.");
					allParticipants.remove(tempParticipant);
					break;
				}
			}
			
			if (!removed) {
				System.out.println("Error: no participant with number " + removeNumber + " exists.");
			}
		} while (removeNumber < 100);
	}
}
