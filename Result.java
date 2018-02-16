public class Result {
	
	private Event event;
	private Participant participant;
	private double result;
	
	public Result() {
		
	}

	public Result(Event event, Participant participant, double result) {
		this.event = event;
		this.participant = participant;
		this.result = result;
	}
		
	public String toString() {
		return String.format("Results for %s in %s: %d", participant.getFullName(), event.getName(), result); 
	}
}
