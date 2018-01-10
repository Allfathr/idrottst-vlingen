public class Event {
	
	private String name;
	private int attempts;
	
	public Event(String name, int attempts) {
		this.name = name;
		this.attempts = attempts;
	}

	public String getName() {
		return name;
	}
}
