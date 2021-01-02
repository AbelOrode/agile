package agile.Entity;

public class Flight {
	private int id;
	private String name;
	private String origin;
	private String destination;
	
	
	public Flight() {
	
	}


	public Flight(int id, String name, String origin, String destination) {
	
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.destination = destination;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
	
}
