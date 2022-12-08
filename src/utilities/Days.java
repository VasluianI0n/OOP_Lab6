package utilities;

import java.util.concurrent.ThreadLocalRandom;

import People.Worker;

public class Days {
	private String weekDays[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private String workingDays[] = new String[5];
	
	private static boolean check(String[] arr, String toCheckValue)
    {
        // check if the specified element
        // is present in the array or not
        // using Linear Search method
        int test = 0;
        for (String element : arr) {
            if (element == toCheckValue) {
                test++;
            }
        }
        if(test > 1) {
        	return false;
        }else {
        	return true;
        }
        
    }
	
	
	public Days() {
		for(int i = 0; i < 5; i++) {
			int position = ThreadLocalRandom.current().nextInt(0, 7);
			workingDays[i] = weekDays[position];
		}
		for(int i = 0; i < 5; i++) {
			
			while(check(workingDays,workingDays[i])==false){
				int position = ThreadLocalRandom.current().nextInt(0, 7);
				workingDays[i] = weekDays[position];
			}
		}
	}
	
	public String[] getWorkingDays(){
		return workingDays;
	}
	
	
}
