import java.util.ArrayList;

public class Event {

	private ArrayList<Result> allResults = new ArrayList<>();
	private String name;
	private int attempts;
	
	public Event() {
		
	}
	
	public Event(String name, int attempts) {
		this.name = name;
		this.attempts = attempts;
	}

	public String getName() {
		return name;
	}
	
	public void addResult(Result result) {
		allResults.add(result);
	}
	
	// Glöm ej skriva in [grennamn] uppgift
	public void printResultList() {
		System.out.println("Results for " + name);
		
	}
	
}
