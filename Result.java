import java.util.ArrayList;
import java.util.Scanner;

public class Result {
	
	private SportsMethods test = new SportsMethods();
	private Participant choicePart = new Participant();
	private Event event = new Event();
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Result> allResults = new ArrayList<>();
	private String eventName, participantName;
	private double result;
	
	public Result() {
		
	}

	public Result(String eventName, String participantName, double result) {
		this.eventName = eventName;
		this.participantName = participantName;
		this.result = result;
	}
	
	public String getName() {
		return participantName;
	}
	
	public String toString() {
		return String.format("Results for %s in %s: %d", participantName, eventName, result); 
	}
	
	public void addResult() {
		
		double resultNumber = 0;
		Participant goodParticipant = null;
		Event goodEvent = null;
		
		System.out.print("Number: ");
		int checkParticipant = scan.nextInt();
		scan.nextLine();
		
		if (choicePart.getNumberList().contains(checkParticipant)) {
				System.out.print("Event: ");
				String resultEvent = scan.nextLine();
				resultEvent = test.capitalizeTrim(resultEvent);
				
				if (event.getNameList().contains(resultEvent)) {
						do {
							for (Participant listParticipant : choicePart.getMemberList()) {
								if (checkParticipant == listParticipant.getParticipantNumber()) {
									goodParticipant = listParticipant;
								}
								for (Event listEvent : event.getEventList()) {
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
		
		if (choicePart.getNumberList().contains(searchParticipant)) {
			for (Participant resultParticipant : choicePart.getMemberList()) {
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
}
