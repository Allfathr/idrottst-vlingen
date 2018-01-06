import java.util.Scanner;
import java.util.ArrayList;

public class SportsMethods {
	
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Event> allEvents = new ArrayList<>();
	
	public void addEvent() {
		System.out.print("Event name: ");
		String name = scan.nextLine();
		System.out.print("Attempts allowed: ");
		int attempts = scan.nextInt();
		scan.nextLine();
		System.out.println(name + " added.");
		
		Event event = new Event(name, attempts);
		
		allEvents.add(event);
	}
	

}
