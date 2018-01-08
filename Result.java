import java.util.Scanner;

public class Result {
	
	private Scanner scan = new Scanner(System.in);
	private SportsMethods test = new SportsMethods();
	
	public void addResult() {
		System.out.print("Number: ");
		int participantNumber = scan.nextInt();
		scan.nextLine();
		System.out.print("Event: ");
		String resultEvent = scan.nextLine();
		
		for (int i = 0; i < test.allEvents.size(); i++) {
			if (test.allEvents.get(i).getName().equalsIgnoreCase(resultEvent)) {
				// Obs lägg in kod här för listorna för team och deltagare
				System.out.print("Results for " + "participantname" + "from " + "teamname" + " in " 
				+ test.allEvents.get(i).getName() +": ");
				int resultNumber = scan.nextInt();
			}
			else {
				System.out.println("Error: no event called: '" + test.allEvents.get(i).getName() + "' found.");
			}	
		}
	}
}
