package People;

import utilities.Nicknames;

public class Senior extends Human{
	private Human human;
	private String status;
		
		public Senior() {
			human = new Human();
			status = "watching over the workers:";
		}
		
		public void setShift(int n) {
			if(n == 0) {
				human.setShift("morning");
			}else if(n == 1) {
				human.setShift("afternoon");
			}else if(n == 2) {
				human.setShift("evening");
			}
		}
		public Human getHuman() {
			return human;
		}
		public String getStatus() {
			return status;
		}
}
