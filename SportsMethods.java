import java.util.Scanner;
import java.util.ArrayList;

public class SportsMethods {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Event> allEvents = new ArrayList<>();
	private ArrayList<String> eventNames = new ArrayList<>();
	private ArrayList<Integer> participantNumbers = new ArrayList<>();
	private ArrayList<Participant> allParticipants = new ArrayList<>();
	private int attempts, participantNumber, removeNumber, resultNumber, checkParticipant, searchParticipant;
	private String eventName, firstName, lastName, teamName;
	private int incrementNumber = 100;
	
	private String capitalizeTrim(String original) {
		original = original.trim();
		original = original.substring(0,1).toUpperCase() + original.substring(1).toLowerCase();
		return original;
	}
	
	public void addEvent() {
		
		do {
			System.out.print("Event name: ");
			eventName = scan.nextLine();
		
			if (eventName == null || eventName.isEmpty()) {
				System.out.println("Error: name can't be empty." );
				continue;
			}
			
			else if (eventNames.contains(eventName = capitalizeTrim(eventName))) {
				System.out.println("Error: event already exists." );
				break;
			}
			
			else {
				eventName = capitalizeTrim(eventName);
				do {
					System.out.print("Attempts allowed: ");
					attempts = scan.nextInt();
					scan.nextLine();
					
					if (attempts <= 0) {
						System.out.println("Error: too low, must allow at least one attempt.");
						continue;
					}
					else {
						Event event = new Event(eventName, attempts);
						allEvents.add(event);
						eventNames.add(eventName);
						System.out.println(eventName + " added.");
						break;
					}
				} while (attempts <= 0);
			}
		} while (eventName == null || eventName.isEmpty());
	}
	
	public void addParticipant() {
		
		do {
			System.out.print("First name: ");
			firstName = scan.nextLine();
			
			if (firstName == null || firstName.isEmpty()) {
				System.out.println("Error: name can't be empty." );
				continue;
			}
			else {
				firstName = capitalizeTrim(firstName);
				break;
			}
		} while (firstName == null || firstName.isEmpty());
		
		do {
			System.out.print("Last name: ");
			lastName = scan.nextLine();
			
			if (lastName == null || lastName.isEmpty()) {
				System.out.println("Error: name can't be empty." );
				continue;
			}
			else {
				lastName = capitalizeTrim(lastName);
				break;
			}
		} while (lastName == null || lastName.isEmpty());
		
		do {
			System.out.print("Team: ");
			teamName = scan.nextLine();
			
			if (teamName == null || teamName.isEmpty()) {
				System.out.println("Error: name can't be empty." );
				continue;
			}
			else {
				teamName = capitalizeTrim(teamName);
				break;
			}
		} while (teamName == null || teamName.isEmpty());
		
		participantNumber = incrementNumber;
		incrementNumber++;
		Participant participant = new Participant(firstName, lastName, teamName, participantNumber);
		allParticipants.add(participant);
		participantNumbers.add(participantNumber);
		System.out.println(firstName + " " + lastName + " from " + teamName + " with number " + participantNumber 
				+ " added.");
	}
	
	public void removeParticipant() {
		
		boolean removed = false;
		
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
	
	public void participant() {
		System.out.print("Number: ");
		searchParticipant = scan.nextInt();
		scan.nextLine();
		
		if (participantNumbers.contains(searchParticipant)) {
			System.out.print("Event: ");
			String resultEvent = scan.nextLine();
		
		}
		else {
			System.out.println("Error: no participant with number " + searchParticipant + " found!");
		}
	}
	
	public void addResult() {
		System.out.print("Number: ");
		checkParticipant = scan.nextInt();
		scan.nextLine();
		
		if (participantNumbers.contains(checkParticipant)) {
				System.out.print("Event: ");
				String resultEvent = scan.nextLine();
				
				if (eventNames.contains(resultEvent)) {
						Participant tempoParticipant = allParticipants.get(checkParticipant);
						System.out.print("Results for " + tempoParticipant.toString() + " in");
					
				}
				else {
					System.out.println("Error: no event called: '" + resultEvent + "' found!");
				}	
		}
		else {
			System.out.println("Error: no participant with number " + checkParticipant + " found!");
		}
	}
	
	public void eventInput() {
		
	}
	
	public void message(String longText) {
		System.out.println("############################################################");
		System.out.println(String.format("%-58s #", "#"));
		System.out.println(String.format("# %-56.56s #", longText));
		System.out.println(String.format("%-58s #", "#"));
		System.out.println("############################################################");
	}
	
	public void sysExit() {
		System.out.println("Programmet avslutas");
		System.exit(0);
		}
}
