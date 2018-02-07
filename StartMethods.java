import java.util.Scanner;

public class StartMethods {
	
	private Scanner scan = new Scanner(System.in);
	private SportsMethods test = new SportsMethods();
	private Participant choicePart = new Participant();
	private Event event = new Event();
	private Result result = new Result();
	
	private void startOptions() {
		
		System.out.print("Command: ");
		String commander = scan.nextLine();
		
		if (commander.toLowerCase().equals("add event")) {
			event.addEvent();
		}
			
		else if (commander.toLowerCase().equals("add participant")) {
			choicePart.addParticipant();
		}
		
		else if (commander.toLowerCase().equals("remove participant")) {
			choicePart.removeParticipant();
		}
		
		else if (commander.toLowerCase().equals("add result")) {
			result.addResult();
		}
		
		else if (commander.toLowerCase().equals("participant")) {
			result.checkParticipant();
		}
		
		else if (event.getNameList().contains(commander)) {
			test.eventInput(commander);
		}
		
		else if (commander.contains("message")) {
			String parts[] = commander.split(" ", 2);
			String longText = parts[1];
			test.message(longText);
		}
		
		else if (commander.toLowerCase().equals("exit")) {
			test.sysExit();
		}
		else {
			System.out.println("Error: unknown command " + commander);
		}
		
	}
	
	public void runProgram() {
		// Loopar metoden startOptions vilket är huvudmenyn
		while (true) {
			startOptions();
		}
	}
}
