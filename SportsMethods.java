import java.util.Scanner;
import java.util.ArrayList;

public class SportsMethods {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Event> allEvents = new ArrayList<>();
	
	public void addEvent() {
		
		System.out.print("Event name: ");
		String nameInput = scan.nextLine();
		String name = nameInput.substring(0,1).toUpperCase() + nameInput.substring(1).toLowerCase();
		name = name.trim();
			
		while (name == null || name.isEmpty()) {
			System.out.println("Error: name can't be empty." );
			System.out.print("Event name: ");				
			nameInput = scan.nextLine();
			name = nameInput.substring(0,1).toUpperCase() + nameInput.substring(1).toLowerCase();
			name = name.trim();
		}
			
		System.out.print("Attempts allowed: ");
		int attempts = scan.nextInt();
		scan.nextLine();
		Event event = new Event(name, attempts);
			
		allEvents.add(event);
		System.out.println(name + " added.");
	}
}
