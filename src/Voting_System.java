import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Voting_System {
	private static ArrayList<Voter> voter_al= new ArrayList<Voter>();
	public Voting_System() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input=0;
		String choice=null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println("Voter's List");
			System.out.println("1.Add Voter. \n2.Remove Voter \n3.Display List\n4.Voting Status");
			System.out.println("Enter your choice : ");
			try{
				input=Integer.parseInt(br.readLine());
			}catch(Exception e){
				System.out.println("Exception is : "+e);
			}
			
			switch(input){
				case 1:
					if(getName())
						System.out.println("Voter added in List.");
					else
						System.out.println("Voter not added");
					break;
				case 2:
					if(dropName())
						System.out.println("Voter removed from List.");
					else
						System.out.println("List is empty");
					break;
				case 3:
					displayVoterList();
					break;
				case 4:
					isComeForVote();
					break;
				default:
					System.out.println("Default choice selected");
			}
			System.out.println("Do you want to contiue? Yes OR No : ");
			try{
				choice=br.readLine();
			}catch(Exception e){
			System.out.println("Exception is : "+e);
			}	
		}while(choice.equalsIgnoreCase("Yes"));
	}
	
	public static boolean getName(){
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		int ssn=0;
		String name=null;
		Voter v1;
		try{
			System.out.println("Enter Voter's ssn : ");
			ssn=Integer.parseInt(br1.readLine());
			System.out.println("Enter Voter's name : ");
			name=br1.readLine();			
		}catch(Exception e){
			System.out.println("Exception is : "+e);
		}
		v1=new Voter(ssn,name);
		return voter_al.add(v1);
	}
	
	public static boolean dropName(){
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		int ssn=0;
		try{
			System.out.println("Enter ssn whose name want to delete : ");
			ssn=Integer.parseInt(br1.readLine());
		}catch(Exception e){}
		Iterator itr = voter_al.iterator();
		while(itr.hasNext()){
			Voter v = (Voter)itr.next();
			if(v.ssn == ssn)
				return voter_al.remove(v);
		}
		return false;
	}
	
	public static void displayVoterList(){
		Iterator itr = voter_al.iterator();
		if(voter_al.isEmpty()){
			System.out.println("List is empty");
			return;
		}
		while(itr.hasNext()){
			Voter v = (Voter)itr.next();
			if(v.voted == true)
				System.out.println("Voter's ssn : " + v.ssn + "  Voter's name : " + v.name + " Voting Status: Voted");
			else
				System.out.println("Voter's ssn : " + v.ssn + "  Voter's name : " + v.name + " Voting Status: Yet to Vote");
		}
	}
	
	public static void isComeForVote(){
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		int ssn=0;
		try{
			System.out.println("Enter ssn who has come for voting : ");
			ssn=Integer.parseInt(br1.readLine());
		}catch(Exception e){}
			
		Iterator itr = voter_al.iterator();
		while(itr.hasNext()){
			Voter v = (Voter)itr.next();
			if(v.ssn == ssn)
				v.voted = true;
		}
	}
}
