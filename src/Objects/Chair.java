package Objects;

public class Chair extends Objects{
private Objects object;

	public Chair() {
		object = new Objects();
	}
	
	public String getStatus() {
		return object.getUse();
	}
	
	public void setStatus(String st) {
		object.setUse(st);
	}
}
