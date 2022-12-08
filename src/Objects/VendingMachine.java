package Objects;

public class VendingMachine extends Objects{
	private Objects object;
	
	public VendingMachine() {
		object = new Objects();
	}
	
	public String getStatus() {
		return object.getUse();
	}
	
	public void setStatus(String st) {
		object.setUse(st);
	}
}
