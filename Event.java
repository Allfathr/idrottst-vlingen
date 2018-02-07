import java.util.ArrayList;
import java.util.Scanner;

public class Event {
	
	private SportsMethods test = new SportsMethods();
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Event> allEvents = new ArrayList<>();
	private ArrayList<String> eventNames = new ArrayList<>();
	private String name;
	private int attempts;
	
	public Event() {
		
	}
	
	public Event(String name, int attempts) {
		this.name = name;
		this.attempts = attempts;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Event> getEventList() {
		return allEvents;
	}
	
	public ArrayList<String> getNameList() {
		return eventNames;
	}
	
	public void addEvent() {
		
		String eventName;
		int noOfTries;
		
		do {
			System.out.print("Event name: ");
			eventName = scan.nextLine();
		
			if (eventName == null || eventName.trim().isEmpty()) {
				System.out.println("Error: name can't be empty." );
				continue;
			}
			
			else if (eventNames.contains(eventName = test.capitalizeTrim(eventName))) {
				System.out.println("Error: event already exists." );
				break;
			}
			
			else {
				eventName = test.capitalizeTrim(eventName);
				do {
					System.out.print("Attempts allowed: ");
					noOfTries = scan.nextInt();
					scan.nextLine();
					
					if (noOfTries <= 0) {
						System.out.println("Error: too low, must allow at least one attempt.");
						continue;
					}
					else {
						Event event = new Event(eventName, noOfTries);
						allEvents.add(event);
						eventNames.add(eventName);
						System.out.println(eventName + " added.");
						break;
					}
				} while (noOfTries <= 0);
			}
		} while (eventName == null || eventName.trim().isEmpty());
	}
	
}
