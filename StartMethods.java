import java.util.Scanner;

public class StartMethods {
	
	private Scanner scan = new Scanner(System.in);
	private SportsMethods test = new SportsMethods();
	
	private void startOptions() {
		
		System.out.print("Command: ");
		String commander = scan.nextLine();
		
		if (commander.toLowerCase().equals("add event")) {
			test.addEvent();
		}
			
		else if (commander.toLowerCase().equals("add participant")) {
			test.addParticipant();
		}
		
		else if (commander.toLowerCase().equals("remove participant")) {
			test.removeParticipant();
		}
		
		else if (commander.toLowerCase().equals("add result")) {
			test.addResult();
		}
		
		else if (commander.toLowerCase().equals("participant")) {
			test.participant();
		}
		
		else if (commander.toLowerCase().equals("grennamn")) {
			test.eventInput();
		}
		
		else if (commander.length() > 4 && commander.substring(0, 7).toLowerCase().equals("message")) {
			String parts[] = commander.split(" ", 2);
			String longText = parts[1];
			test.message(longText);
		}
		
		else if (commander.toLowerCase().equals("exit")) {
			test.sysExit();
		}
		else {
			System.out.println("Nu blev det fel Anton");
		}
		
	}
	
	public void runProgram() {
		// Loopar metoden startOptions vilket är huvudmenyn
		while (true) {
			startOptions();
		}
	}
}
