package People;

import utilities.Nicknames;

public class WatchMan extends Human{
	private Nicknames nickname =  new Nicknames();
	private String day;
	private String status;
		
		public WatchMan() {
			status = "Guarding the doors.";
		}
		
		public void setDay(String day) {
			this.day = day;
		}
		
		public String getDay() {
			return day;
		}
		
		public String getnickname() {
			return nickname.getName();
		}
		
		public String getStatus() {
			return status;
		}
}
