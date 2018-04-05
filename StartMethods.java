// Anton Sandström ansa6928
// Jesper Jönsson jeja6606

import java.util.ArrayList;
import java.util.Scanner;

public class StartMethods {

	private Scanner scan = new Scanner(System.in);
	private SportsMethods test = new SportsMethods();
	private ArrayList<Event> allEvents = new ArrayList<>();
	private ArrayList<Participant> allParticipants = new ArrayList<>();
	private static int incrementNumber = 100;

	private void startOptions() {

		System.out.print("Command: ");
		String commander = scan.nextLine();

		if (commander.toLowerCase().equals("add event")) {
			addEvent();
		}

		else if (commander.toLowerCase().equals("add participant")) {
			addParticipant();
		}

		else if (commander.toLowerCase().equals("remove participant")) {
			removeParticipant();
		}

		else if (commander.toLowerCase().equals("add result")) {
			addResult();
		}

		else if (commander.toLowerCase().equals("participant")) {
			checkParticipant();
		}

		else if (getEvent((commander = test.capitalizeTrim(commander))) != null) {
			getEvent(commander).getHighScore();
		}

		else if (commander.toLowerCase().contains("message")) {
			String[] parts = commander.split(" ", 2);
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

	private Event getEvent(String eventName) {
		for (Event e : allEvents) {
			if (e.getName().equals(eventName)) {
				return e;
			}
		}

		return null;
	}

	private Participant getParticipant(int participantNumber) {
		for (Participant p : allParticipants) {
			if (p.getParticipantNumber() == participantNumber) {
				return p;
			}
		}

		return null;
	}

	private void addParticipant() {

		String mainName;
		String surName;
		String nameOfTeam;

		do {
			System.out.print("First name: ");
			mainName = scan.nextLine();

			if (mainName == null || mainName.trim().isEmpty()) {
				System.out.println("Error: name can't be empty.");
			} else {
				mainName = test.capitalizeTrim(mainName);
			}
		} while (mainName == null || mainName.trim().isEmpty());

		do {
			System.out.print("Last name: ");
			surName = scan.nextLine();

			if (surName == null || surName.trim().isEmpty()) {
				System.out.println("Error: name can't be empty.");
			} else {
				surName = test.capitalizeTrim(surName);
			}
		} while (surName == null || surName.trim().isEmpty());

		do {
			System.out.print("Team: ");
			nameOfTeam = scan.nextLine();

			if (nameOfTeam == null || nameOfTeam.trim().isEmpty()) {
				System.out.println("Error: name can't be empty.");
			} else {
				nameOfTeam = test.capitalizeTrim(nameOfTeam);
				int competitionNumber = incrementNumber;
				incrementNumber++;
				Participant participant = new Participant(mainName, surName, nameOfTeam, competitionNumber);
				allParticipants.add(participant);
				System.out.println(mainName + " " + surName + " from " + nameOfTeam + " with number "
						+ competitionNumber + " added.");
			}
		} while (nameOfTeam == null || nameOfTeam.trim().isEmpty());
	}

	private void removeParticipant() {

		int removeNumber;

		System.out.print("Number: ");
		removeNumber = scan.nextInt();
		scan.nextLine();

		Participant tempParticipant = getParticipant(removeNumber);

		if (tempParticipant != null) {
			System.out.println(tempParticipant.toStringWithNumber() + " removed.");
			allParticipants.remove(tempParticipant);
			for (Event e : allEvents) {
				e.removePartResult(tempParticipant);
			}
			return;
		}

		System.out.println("Error: no participant with number " + removeNumber + " exists.");
	}

	private void addResult() {
	
		boolean goodResult = false;
		
		System.out.print("Number: ");
		int partNumber = scan.nextInt();
		scan.nextLine();
		Participant p = getParticipant(partNumber);
		
		if (p == null) {
			System.out.println("Error: participant does not exist.");
			return;
		}
		System.out.print("Event: ");
		String eventName = scan.nextLine();
		eventName = test.capitalizeTrim(eventName);
		Event e = getEvent(eventName);
		if (e == null) {
			System.out.println("Error: event does not exist.");
			return;
		}
		
		Result r = p.getResult(e);
		
		if (r != null) {
			if (r.getTries() >= e.getAttempts()) {
				System.out.println("Error: No more attempts.");
				return;
			}
		}	
		
		System.out.print("Add result for " + p.getFullName() + " in " + e.getName() + ": " );
		double result = scan.nextDouble();
		
		if(result < 0) {
			while (!goodResult) {
				goodResult = true;
				System.out.println("Error: must be higher than zero.");
				result = scan.nextDouble();
				if(result < 0) {
					goodResult = false;
				}
			}
		}
		
		scan.nextLine();
		if (r == null) {
			r = new Result(e, p, result);
			p.addResult(r);
			e.addResult(r);
		} 
		else {
			r.addTries(result);
		} 		
	}

	private void checkParticipant() {
	
		System.out.print("Number: ");
		int searchParticipant = scan.nextInt();
		scan.nextLine();
		Participant niceParticipant = getParticipant(searchParticipant);

		if (niceParticipant != null) {
			niceParticipant.printResults();

		}

		else {
			System.out.println("Error: no participant with number " + searchParticipant + " found!");
		}

	}

	private void addEvent() {

		String eventName;
		int noOfTries;

		do {
			System.out.print("Event name: ");
			eventName = scan.nextLine();
			
			for (Event e : allEvents) {
				
				if (eventName.trim().equalsIgnoreCase(e.getName())) {
					System.out.println("Error: event already exists.");
					return;
				}
			}
			
			if (eventName == null || eventName.trim().isEmpty()) {
				System.out.println("Error: name can't be empty.");
				continue;
			}

			else {
				do {
					System.out.print("Attempts allowed: ");
					noOfTries = scan.nextInt();
					scan.nextLine();

					if (noOfTries <= 0) {
						System.out.println("Error: too low, must allow at least one attempt.");
						continue;
					} 
					else {
						eventName = test.capitalizeTrim(eventName);
						Event event = new Event(eventName, noOfTries);
						allEvents.add(event);
						System.out.println(eventName + " added.");
						break;
					}
				} while (noOfTries <= 0);
			}
		} while (eventName == null || eventName.trim().isEmpty());
	}

}
