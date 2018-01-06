import java.util.Scanner;
import java.util.ArrayList;

public class SportsMethods {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Event> allEvents = new ArrayList<>();
	private int attempts;
	private String nameInput, name;
	
	
	
	public void addEvent() {
		
		System.out.print("Event name: ");
		nameInput = scan.nextLine();
		name = nameInput.substring(0,1).toUpperCase() + nameInput.substring(1).toLowerCase();
		name = name.trim();
			
		while (name == null || name.isEmpty()) {
			System.out.println("Error: name can't be empty." );
			System.out.print("Event name: ");				
			nameInput = scan.nextLine();
			name = nameInput.substring(0,1).toUpperCase() + nameInput.substring(1).toLowerCase();
			name = name.trim();
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
		
		Event event = new Event(name, attempts);
		allEvents.add(event);
		System.out.println(name + " added.");
	}
}
