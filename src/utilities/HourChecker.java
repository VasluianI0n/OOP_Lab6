package utilities;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import People.Worker;
import People.Senior;
import People.WatchMan;
import WorkingPlace.WorkingPlace;

public class HourChecker {
	static int tp_people = 0;
	static int total_money_made=0;
	static int total_week = 0;
	static int total_tp_week = 0;
	static int total_month = 0;
	static int total_tp_month = 0;
	
	private static boolean check(Worker[] arr, String toCheckValue)
    {
        int test = 0;
        for (Worker element : arr) {
            if (element.getHuman().getNickname().getName() == toCheckValue) {
                test++;
            }
        }
        if(test > 1) {
        	return false;
        }else {
        	return true;
        }
        
    }
	

	public static float money_per_customer(float given_price, float initial_price, float TP){
		float markup,total;
		markup = given_price - initial_price;
		total = TP+markup;
		return total;
	}
	
	
	public static float money_per_customer(float given_price, float initial_price){
		float markup,total;
		markup = given_price - initial_price;
		total = markup;
		return total;
	}
	
	
	public static void setSchedule(int workers, Worker people[], Senior seniors[], WatchMan watchmen[]) {
		//Declaration of Workers
				for(int i = 0; i < workers; i++) {
					int position = ThreadLocalRandom.current().nextInt(1, 4);
					people[i] = new Worker();
					people[i].setShift(position);
				}
				
				for(int i = 0; i < workers; i++) {
						while(check(people,people[i].getHuman().getNickname().getName())==false) {
							people[i].getHuman().setNickname();
						}
				}
				//Declaration of Seniors
				for(int i = 0; i < 3; i++) {
					seniors[i] = new Senior();
					seniors[i].setShift(i);
				}
				//Declaration of Watchmen
				for(int i = 0; i < 7; i++) {
					watchmen[i] = new WatchMan();
				}
				watchmen[0].setDay("Sunday");
				watchmen[1].setDay("Monday");
				watchmen[2].setDay("Tuesday");
				watchmen[3].setDay("Wednesday");
				watchmen[4].setDay("Thursday");
				watchmen[5].setDay("Friday");
				watchmen[6].setDay("Saturday");
	}
	
	
	public static void checkSchedule(int workers, Worker people[]) {
		//Checking each worker and their itinerary
				for(int i = 0; i < workers; i++) {
					System.out.println((i+1)+"."+people[i].getHuman().getNickname().getName());
					System.out.println("   Working days:");
					people[i].getHuman().printWorkingDays();
					System.out.println(people[i].getHuman().getShift());
				}
	}
	
	
	public static void seniorWatchingOver(int h, Senior seniors[], Worker people[], int workers, String day, String hour) {
		if(h >= 9 && h <=17){
			System.out.println(seniors[0].getHuman().getNickname().getName().toUpperCase()+" is "+seniors[0].getStatus());
			for(int i = 0; i < workers; i++) {
				people[i].checkWorkingHour(day,hour);
				if(!people[i].getStatus().equals("on a Free Day.")&&!people[i].getStatus().equals("Out of working hours.")) {
					System.out.println(people[i].getHuman().getNickname().getName());
				}
			}
		}else if(h >=12 && h <= 20){
			System.out.println(seniors[1].getHuman().getNickname().getName().toUpperCase()+" is "+seniors[1].getStatus());
			for(int i = 0; i < workers; i++) {
				people[i].checkWorkingHour(day,hour);
				if(!people[i].getStatus().equals("on a Free Day.")&&!people[i].getStatus().equals("Out of working hours.")) {
					System.out.println(people[i].getHuman().getNickname().getName());
				}
			}
		}else{
			System.out.println(seniors[2].getHuman().getNickname().getName().toUpperCase()+" is "+seniors[2].getStatus());
			for(int i = 0; i < workers; i++) {
				people[i].checkWorkingHour(day,hour);
				if(!people[i].getStatus().equals("on a Free Day.")&&!people[i].getStatus().equals("Out of working hours.")) {
					System.out.println(people[i].getHuman().getNickname().getName());
				}
			}
		}
		
	}
	
	
	public static void checkAvailableWorkers(int workers,Worker people[], String day, String hour) {
		//Check what the workers that are working are doing
		Scanner in = new Scanner(System.in);
		String chk;
		System.out.println("Want to check over each of the workers who is working? Y/N");
		chk = in.nextLine();
		while(!chk.toLowerCase().equals("y") && !chk.toLowerCase().equals("n")) {
			System.out.println("Want to check over each of the workers who is working? Y/N");
			chk = in.nextLine();
		}
		if(chk.toLowerCase().equals("y")) {
			for(int i = 0; i < workers; i++) {
				int tp_people = 0;
				people[i].checkWorkingHour(day,hour);
				if(!people[i].getStatus().equals("on a Free Day.")&&!people[i].getStatus().equals("Out of working hours.")) {
					System.out.println(people[i].getHuman().getNickname().getName()+" is "+people[i].getStatus());
					int customers = ThreadLocalRandom.current().nextInt(1, 5);
					int total_money_made=0;
					for(int j = 0; j < customers; j++) {
						int TP_choice = ThreadLocalRandom.current().nextInt(1, 5);
						
						float ticket_price = 1200;
						float ticket_initial_price = ThreadLocalRandom.current().nextInt(400, 800);
						float TP_price = 120;
						if(TP_choice == 3) {
							total_money_made += money_per_customer(ticket_price, ticket_initial_price, TP_price);
							tp_people++;
						}else {
							total_money_made += money_per_customer(ticket_price, ticket_initial_price);
						}
					}
					System.out.println("Made "+total_money_made+"$ so far and sold "+tp_people+" Ticket Protections.");
				}
			}
		}
	}
	
	
	public static void checkFreeWorkers(int workers, Worker people[],String day, String hour) {
		//Check over the free workers
		Scanner in = new Scanner(System.in);
		String chk;
		System.out.println("Want to check over the free workers? Y/N");
		chk = in.nextLine();
		while(!chk.toLowerCase().equals("y") && !chk.toLowerCase().equals("n")) {
			System.out.println("Want to check over the free workers? Y/N");
			chk = in.nextLine();
		}
		if(chk.toLowerCase().equals("y")) {
			for(int i = 0; i < workers; i++) {
				people[i].checkWorkingHour(day,hour);
				if(people[i].getStatus().equals("on a Free Day.")||people[i].getStatus().equals("Out of working hours.")) {
					System.out.println(people[i].getHuman().getNickname().getName()+" is "+people[i].getStatus());
				}
			}
		}else {
			
		}
	}
	
	
	public static void checkAvailabilityPerDay(String day, String hour, WatchMan watchmen[],Senior seniors[],Worker people[], int workers) {
		//Reading the day and hour
		
				//Printing the Watchman that is on that day
				for(int i = 0; i < 7; i++) {
					if(watchmen[i].getDay().equals(day)) {
						System.out.println(watchmen[i].getnickname()+" is "+watchmen[i].getStatus());
					}
				}
				//Printing the senior on that specific shift and the workers
				String h2 = hour.substring(0,2);
				int h = Integer.parseInt(h2);
				
				seniorWatchingOver(h,seniors,people,workers,day,hour);
				checkAvailableWorkers(workers,people,day,hour);
				checkFreeWorkers(workers,people,day,hour);
				
				
	}

	
	public static void dailyReport(String day,String weekDays[],int l,int workers,Worker people[]) {
		 tp_people = 0;
		 total_money_made=0;
		day = weekDays[l];
		for(int i = 0; i < workers; i++) {
			people[i].checkWorkingDay(day);
			if(!people[i].getStatus().equals("on a Free Day.")&&!people[i].getStatus().equals("Out of working hours.")) {
				int customers = ThreadLocalRandom.current().nextInt(1, 5);
				for(int j = 0; j < customers; j++) {
					int TP_choice = ThreadLocalRandom.current().nextInt(1, 5);
					float ticket_price = 1200;
					float ticket_initial_price = ThreadLocalRandom.current().nextInt(400, 800);
					float TP_price = 120;
					if(TP_choice == 3) {
						total_money_made += money_per_customer(ticket_price, ticket_initial_price, TP_price);
						tp_people++;
					}else {
						total_money_made += money_per_customer(ticket_price, ticket_initial_price);
					}
				}
			}
		}
		System.out.println("        "+total_money_made+"$ were made on "+day+" from which "+tp_people*120+"$ from Ticket Protection");
		
	}
	
	
	public static void weeklyReport(String day,String weekDays[],int workers,Worker people[],int k) {
		for(int i = 0; i < 7; i++) {
			dailyReport(day, weekDays,i, workers, people);
			total_week+=total_money_made;
			total_tp_week+=tp_people;
		}
		System.out.println("     "+total_week+"$ were made on "+(k+1)+" week from which "+total_tp_week*120+"$ from Ticket Protection");
	}
	
	
	public static void monthlyReport(String day,String weekDays[],int workers,Worker people[]) {
		String chk;
		Scanner in = new Scanner(System.in);
		System.out.println("Want to see a whole month report? Y/N");
		chk = in.nextLine();
		while(!chk.toLowerCase().equals("y") && !chk.toLowerCase().equals("n")) {
			System.out.println("Want to see a whole month report? Y/N");
			chk = in.nextLine();
		}
		
		while(chk.toLowerCase().equals("y")) {
		for(int i = 0; i < 4; i++) {
			weeklyReport(day,weekDays,workers,people,i);
			total_month+=total_week;
			total_tp_month+=total_tp_week;
		}
		int total_given_to_workers = total_month/5;
		int electricity_price=ThreadLocalRandom.current().nextInt(10000, 14000);
		System.out.println(total_month+"$ were made on this month from which "+total_tp_month*120+"$ from Ticket Protection");
		System.out.println(total_given_to_workers+"$ were paid to the workers, making an average salary of "+ total_given_to_workers/workers+"$ per worker");
		System.out.println(electricity_price+"$ were paid for the electricity");
		System.out.println("The company got "+(total_month-total_given_to_workers-electricity_price)+"$ for this month");
		System.out.println("");
		System.out.println("Want to see the report for the next month? Y/N");
		chk = in.nextLine();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		String weekDays[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		int workers;
		WorkingPlace workingPlace = new WorkingPlace();
		String day,hour;
		Senior seniors[] = new Senior[3];
		WatchMan watchmen[] = new WatchMan[7];
		Scanner in = new Scanner(System.in);
		System.out.println("The company is working "+workingPlace.getWorkingHours()+"/7 on "+workingPlace.getPlace());
		System.out.println("How many workers does the company have:");
		workers = Integer.parseInt(in.nextLine());
		Worker people[] = new Worker[workers];
		
		
		setSchedule(workers,people,seniors,watchmen);
		checkSchedule(workers,people);
		
		System.out.println("Type in the day you want it to be:");
		day = in.nextLine();
		System.out.println("Type in the hour you want to check:");
		hour = in.nextLine();
		
		checkAvailabilityPerDay(day,hour,watchmen,seniors,people,workers);
		monthlyReport(day,weekDays,workers,people);
		

	}

}
