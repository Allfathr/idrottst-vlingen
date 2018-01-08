import java.util.Scanner;

public class StartMethods {
	
	private Scanner scan = new Scanner(System.in);
	private SportsMethods test = new SportsMethods();
	
	private void sysExit() {
		System.out.println("Programmet avslutas");
		System.exit(0);
		}
	
	private void startOptions() {
		
		System.out.print("Command: ");
		String choice = scan.nextLine();

		switch (choice.toLowerCase()) {

		case "add event":
			test.addEvent();
			break;
		case "add participant":
			test.addParticipant();
			break;
		case "remove participant":

			break;
		case "add result":

			break;
		case "participant":

			break;
		case "hi":
			break;
		case "message":
			
			break;
		case "exit":
			sysExit();
			break;
		default:
			System.out.println("Error - fel indata.");
			break;
		}
	}
	
	public void runProgram() {
		// Loopar metoden startOptions vilket är huvudmenyn
		while (true) {
			startOptions();
		}
	}
}
