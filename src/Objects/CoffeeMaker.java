package Objects;

public class CoffeeMaker extends Objects{

private Objects object;

	public CoffeeMaker() {
		object = new Objects();
	}
	
	public String getStatus() {
		return object.getUse();
	}
	
	public void setStatus(String st) {
		object.setUse(st);
	}
}
