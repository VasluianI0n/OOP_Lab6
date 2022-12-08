package People;
import utilities.Days;
import utilities.Nicknames;
import WorkingPlace.WorkingPlace;

public class Human extends WorkingPlace{
	private WorkingPlace workingPlace;
	private Nicknames nickname;
	private Days workingDays;
	private String shift;
	private int workingStartHour, workingEndHour;
	
		public Human() {
			nickname = new Nicknames();
			workingDays = new Days();
			nickname.setName();
			shift = "";
			workingStartHour = 0;
			workingEndHour = 0;
			workingPlace = new WorkingPlace();
		}
		public boolean isWorkingDay(String day) {
			for(int i = 0; i < 5; i++) {
				if(day == workingDays.getWorkingDays()[i]) {
					return true;
				}
		}
		
			return false;
		}
		public void printWorkingDays() {
			for(int i = 0; i < 5; i++) {
				System.out.println("\t"+workingDays.getWorkingDays()[i]);
			}
		}
		public boolean checkDay(String day) {
			for(int i = 0; i < 5; i++) {
				if(day.equals(workingDays.getWorkingDays()[i])) {
					return true;
				}
			}
			return false;
		}
		
		public boolean checkHour(String hour) {
			String h2 = hour.substring(0,2);
			int h = Integer.parseInt(h2);
			if(getShift()=="evening") {
				if(h < getEndHour() || h > getStartHour()) {
					return true;
				}else {
					return false;
				}
			}else {
			if(h < getEndHour() && h > getStartHour()) {
				return true;
			}else {
				return false;
			}
			}
		}
		public void setShift(String sh) {
			if(sh.equals("morning")) {
				shift = "morning";
				workingStartHour = 9;
				workingEndHour = 17;
			}else if(sh.equals("afternoon")) {
				shift = "afternoon";
				workingStartHour = 12;
				workingEndHour = 20;
			}else if(sh.equals("evening")) {
				shift = "evening";
				workingStartHour = 23;
				workingEndHour = 7;
			}
		}
		
		public int getEndHour() {
			return workingEndHour;
		}
		
		public int getStartHour() {
			return workingStartHour;
		}
		public String getShift() {
			return shift;
		}
		
		public void setNickname() {
			nickname.setName();
		}
		
		public Nicknames getNickname() {
			return nickname;
		}
		public String getWorkingPlace() {
			return workingPlace.getPlace();
		}
}