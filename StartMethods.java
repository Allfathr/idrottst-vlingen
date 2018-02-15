import java.util.ArrayList;
import java.util.Scanner;

public class StartMethods {
	
	private Scanner scan = new Scanner(System.in);
	private SportsMethods test = new SportsMethods();
	private ArrayList<Result> allResults = new ArrayList<>();
	private ArrayList<Participant> allParticipants = new ArrayList<>();
	private ArrayList<Event> allEvents = new ArrayList<>();
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
		
		else if (allEvents.contains(commander)) {
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

	public void addParticipant() {
			
			String mainName;
			String surName;
			String nameOfTeam;
			
			do {
				System.out.print("First name: ");
				mainName = scan.nextLine();
				
				if (mainName == null || mainName.trim().isEmpty()) {
					System.out.println("Error: name can't be empty." );
				}
				else {
					mainName = test.capitalizeTrim(mainName);
				}
			} while (mainName == null || mainName.trim().isEmpty());
			
			do {
				System.out.print("Last name: ");
				surName = scan.nextLine();
				
				if (surName == null || surName.trim().isEmpty()) {
					System.out.println("Error: name can't be empty." );
				}
				else {
					surName = test.capitalizeTrim(surName);
				}
			} while (surName == null || surName.trim().isEmpty());
			
			do {
				System.out.print("Team: ");
				nameOfTeam = scan.nextLine();
				
				if (nameOfTeam == null || nameOfTeam.trim().isEmpty()) {
					System.out.println("Error: name can't be empty." );
				}
				else {
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
		
	public void removeParticipant() {
			
		boolean removed = false;
		int removeNumber;
			
		System.out.print("Number: ");
		removeNumber = scan.nextInt();
		scan.nextLine();
				
		for (int i = 0; i < allParticipants.size(); i++) {
			Participant tempParticipant = allParticipants.get(i);
			if (tempParticipant.getParticipantNumber() == removeNumber) {
						removed = true;
			}
					
			if (removed) {
				System.out.println(tempParticipant.toStringWithNumber() + " removed.");
				allParticipants.remove(tempParticipant);
				break;
			}
		}
				
		if (!removed) {
				System.out.println("Error: no participant with number " + removeNumber + " exists.");
		}
	}

	public void addResult() {
		
		double resultNumber = 0;
		Participant goodParticipant = null;
		Event goodEvent = null;
		
		System.out.print("Number: ");
		int checkParticipant = scan.nextInt();
		scan.nextLine();
		
		if (allParticipants.contains(checkParticipant)) {
			System.out.print("Event: ");
			String resultEvent = scan.nextLine();
			resultEvent = test.capitalizeTrim(resultEvent);
				
			if (allEvents.contains(resultEvent)) {
				do {
					for (Participant listParticipant : allParticipants) {
						if (checkParticipant == listParticipant.getParticipantNumber()) {
							goodParticipant = listParticipant;
						}
							for (Event listEvent : allEvents) {
								if (resultEvent.equals(listEvent.getName())) {
									goodEvent = listEvent;
								}
								System.out.print("Results for " + goodParticipant.toString() + " in " 
											+ goodEvent.getName() + ": ");
								resultNumber = scan.nextDouble();
								scan.nextLine();
									
								Result result = new Result(goodEvent.getName(), goodParticipant.getFullName(), +
											resultNumber);
								allResults.add(result);
							}
						}
					} while (resultNumber <= 0);
			}
			else {
				System.out.println("Error: no event called: '" + resultEvent + "' found!");
			}	
		}
		else {
			System.out.println("Error: no participant with number " + checkParticipant + " found!");
		}
	}
	
	public void checkParticipant() {
		Result niceResult = null;
		Participant niceParticipant = null;
		
		System.out.print("Number: ");
		int searchParticipant = scan.nextInt();
		scan.nextLine();
		
		if (allParticipants.contains(searchParticipant)) {
			for (Participant resultParticipant : allParticipants) {
				// Om värdet för searchParticipant matchar något värde i listan
				if (searchParticipant == resultParticipant.getParticipantNumber()) {
					// Sätt niceParticipant lika med det den matchar
					niceParticipant = resultParticipant;
					for (Result listResult : allResults) {
						if (niceParticipant.getFullName().equals(listResult.getName())) {
							niceResult = listResult;
							System.out.println(niceResult.toString());
						}
					}
				}
			}
		}
		else {
			System.out.println("Error: no participant with number " + searchParticipant + " found!");
		}
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
			
			else if (allEvents.contains(eventName = test.capitalizeTrim(eventName))) {
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
						System.out.println(eventName + " added.");
						break;
					}
				} while (noOfTries <= 0);
			}
		} while (eventName == null || eventName.trim().isEmpty());
	}
	
}
