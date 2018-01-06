import java.util.Scanner;

public class StartMethods {
	
	private Scanner scan = new Scanner(System.in);
	SportsMethods test = new SportsMethods();
	
	private void sysExit() {
		System.out.println("Programmet avslutas");
		System.exit(0);
		}
	
	public void startOptions() {
		
		System.out.println("command: ");
		String choice = scan.nextLine();

		switch (choice.toLowerCase()) {

		case "add event":
			test.addEvent();
			break;
		case "add participant":
			
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
			System.out.println("error - Fel indata.");
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
