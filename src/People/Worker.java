package People;


import java.util.concurrent.ThreadLocalRandom;



public class Worker extends Human{
	private Human human;
	private String status;
	
		public Worker() {
			status = "going to work";
			human = new Human();
		}
		
		public String getStatus() {
			return status;
		}
		
		
		
		public void setShift(int s) {
			if(s == 1) {
				human.setShift("morning");
			}else if(s == 2) {
				human.setShift("afternoon");
			}else if(s == 3) {
				human.setShift("evening");
			}
		}
			
			public Human getHuman() {
				return human;
			}
			public void checkWorkingDay(String day) {
				if(human.checkDay(day) == true) {
						int choice = ThreadLocalRandom.current().nextInt(0, 10);
						if(choice == 4) {
							choice  = ThreadLocalRandom.current().nextInt(0, 6);
							String wher;
							if(choice == 0) {
								wher = "outside.";
							}else if(choice == 1) {
								wher = "inside at the working place.";
							}else if(choice == 2) {
								wher = "eating in the kitchen.";
							}else if(choice == 3) {
								wher = "making a coffee in the kitchen.";
							}else if(choice == 4){
								wher = "in the toilet.";
							}else {
								wher = "in the recreation room.";
							}
							status = "On a break " + wher;
						}else {
							status = "Working at the working place.";
						}
				}else {
					status = "on a Free Day.";
				}
			}
			
			public void checkWorkingHour(String day, String hour) {
				if(human.checkDay(day) == true) {
					if(human.checkHour(hour)==true) {
						int choice = ThreadLocalRandom.current().nextInt(0, 10);
						if(choice == 4) {
							choice  = ThreadLocalRandom.current().nextInt(0, 6);
							String wher;
							if(choice == 0) {
								wher = "outside.";
							}else if(choice == 1) {
								wher = "inside at the working place.";
							}else if(choice == 2) {
								wher = "eating in the kitchen.";
							}else if(choice == 3) {
								wher = "making a coffee in the kitchen.";
							}else if(choice == 4){
								wher = "in the toilet.";
							}else {
								wher = "in the recreation room.";
							}
							status = "On a break " + wher;
						}else {
							status = "Working at the working place.";
						}
				}else {
					status = "Out of working hours.";
				}
				}else {
					status = "on a Free Day.";
				}
			}
}

