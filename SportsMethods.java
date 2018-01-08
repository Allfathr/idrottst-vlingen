import java.util.Scanner;
import java.util.ArrayList;

public class SportsMethods {
	
	private Scanner scan = new Scanner(System.in);
	public ArrayList<Event> allEvents = new ArrayList<>();
	public ArrayList<Participant> allParticipants = new ArrayList<>();
	private int attempts;
	private String eventName, firstName, lastName, teamName;
	
	private String capitalizeTrim(String original) {
		original = original.trim();
		original = original.substring(0,1).toUpperCase() + original.substring(1).toLowerCase();
		return original;
	}
	
	public void addEvent() {
		
		for (;;) {
		System.out.print("Event name: ");
		eventName = scan.nextLine();
		capitalizeTrim(eventName);
			
		if (eventName == null || eventName.isEmpty()) {
			System.out.println("Error: name can't be empty." );
			System.out.print("Event name: ");				
			eventName = scan.nextLine();
			capitalizeTrim(eventName);
			continue;
		}
		
		else {
			break;
		}
		
		}
		while (attempts <= 0) {
			System.out.print("Attempts allowed: ");
			attempts = scan.nextInt();
			scan.nextLine();
			
			if (attempts <= 0) {
				System.out.println("Error: too low, must allow at least one attempt.");
			}
			else {
				continue;
			}
		}
	
		Event event = new Event(eventName, attempts);
		allEvents.add(event);
		System.out.println(eventName + " added.");
	}
	
	public void addParticipant() {
		
		while (firstName == null || firstName.trim().isEmpty()) {
			System.out.print("First name: ");
			firstName = scan.nextLine();
			capitalizeTrim(firstName);
		}
		
		System.out.print("Last name: ");
		lastName = scan.nextLine();
		System.out.print("Team: ");
		teamName = scan.nextLine();
	}
}
