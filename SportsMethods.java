import java.util.Scanner;
import java.util.ArrayList;

public class SportsMethods {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Event> allEvents = new ArrayList<>();
	private ArrayList<String> eventNames = new ArrayList<>();
	private ArrayList<Participant> allParticipants = new ArrayList<>();
	private int attempts, participantNumber, resultNumber;
	private String eventName, firstName, lastName, teamName;
	
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
				continue;
			}
			
			else {
				eventName = capitalizeTrim(eventName);
				break;
			}
		} while (eventName == null || eventName.isEmpty());
		
		do {
			System.out.print("Attempts allowed: ");
			attempts = scan.nextInt();
			scan.nextLine();
			
			if (attempts <= 0) {
				System.out.println("Error: too low, must allow at least one attempt.");
			}
			else {
				break;
			}
		}  while (attempts <= 0);
	
		Event event = new Event(eventName, attempts);
		allEvents.add(event);
		eventNames.add(eventName);
		System.out.println(eventName + " added.");
	}
	
	public void addParticipant() {
		
		while (firstName == null || firstName.isEmpty()) {
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
		}
		while (lastName == null || lastName.isEmpty()) {
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
		}
		while (teamName == null || teamName.isEmpty()) {
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
		}
		Participant participant = new Participant(firstName, lastName, teamName, participantNumber);
		allParticipants.add(participant);
		System.out.print("");
	}
	
	public void addResult() {
		System.out.print("Number: ");
		participantNumber = scan.nextInt();
		scan.nextLine();
		System.out.print("Event: ");
		String resultEvent = scan.nextLine();
		
		for (int i = 0; i < allEvents.size(); i++) {
			if (allEvents.get(i).getName().equalsIgnoreCase(resultEvent)) {
				// Obs lägg in kod här för listorna för team och deltagare
				System.out.print("Results for " + "participantName" + "from " + "teamName" + " in " 
				+ allEvents.get(i).getName() +": ");
				resultNumber = scan.nextInt();
			}
			else {
				System.out.println("Error: no event called: '" + allEvents.get(i).getName() + "' found.");
			}	
		}
	}
}
