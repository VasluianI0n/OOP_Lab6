package Objects;

public class Computer extends Objects{
	private Objects object;
	
		public Computer() {
			object = new Objects();
		}
		
		public String getStatus() {
			return object.getUse();
		}
		
		public void setStatus(String st) {
			object.setUse(st);
		}
}
