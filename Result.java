public class Result {
	
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
}
