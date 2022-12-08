package Objects;

import WorkingPlace.WorkingPlace;
import WorkingPlace.WorkingPlace;

public class Objects extends WorkingPlace{
	private int id;
	private String in_use;
	WorkingPlace workingPlace;
		
		public Objects() {
			id = 0;
			in_use = "Not in use";	
			workingPlace = new WorkingPlace();
			}
		
		public void setId(int n) {
			id = n;
		}
		
		public int getId() {
			return id;
		}
		
		public void setUse(String use) {
			in_use = use;
		}
		
		public String getUse() {
			return in_use;
		}
		
		public String getWorkingPlace() {
			return workingPlace.getPlace();
		}
}