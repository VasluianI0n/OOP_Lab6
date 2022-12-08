package utilities;
import java.util.concurrent.*;
public class Nicknames {
	private String nknames[] = {"Noah","Oliver","George","Leo","Theo","Arthur","Freddie","Harry","Charlie","Jack","Archie","Oscar","Henry","Alfie ","Jacob"
			  ,"Finley","Teddy","Tommy","Thomas","Lucas","Roman","Arlo","Isaac","Max","Theodore","Elijah","Albie","Mason","Logan","Joshua","Harrison","James"
			  ,"William","Ethan","Reuben","Reggie","Rory","Alexander","Louie","Luca","Hunter","Ezra","Ronnie","Sebastian","Adam","Hugo","Jude","Hudson","Dylan","Alex"
			  ,"Olivia","Emma","Ava","Charlotte","Sophia","Amelia","Isabella","Mia","Evelyn","Harper","Camila","Gianna","Abigail","Luna","Ella","Elizabeth",
			  "Sofia","Emily","Avery","Mila","Scarlett","Eleanor","Madison","Layla","Penelope","Aria","Chloe","Grace","Ellie","Nora","Hazel","Zoey","Riley"
			  ,"Victoria","Lily","Aurora","Violet","Nova","Hannah","Emilia","Zoe","Stella","Everly","Isla","Leah","Lillian","Addison","Willow","Lucy","Paisley"};
	private String name;
	public Nicknames() {
		int position = ThreadLocalRandom.current().nextInt(0, 100);
		name = nknames[position];
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		int position = ThreadLocalRandom.current().nextInt(0, 100);
		name = nknames[position];
	}
}
