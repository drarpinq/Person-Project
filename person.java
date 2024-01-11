

public class person {

	private String firstName; 
	private String lastName;
	protected double balance;
	protected int salary = 50;
	protected int success; 
	protected int flawless; 
	//Constructor 
	
	
	public person(String Man, String Singh) {
		
		firstName = Man; 
		lastName = Singh;	
		
		
	}
	
	public String getFirstName() {
		
		return firstName; 
	}
	
	public String getLastName(){
		
		return lastName;
	}
		
	public double getCashBalance() {
		
		return balance;
	}
	
	public void pay() {
        
    }
	
	public void raise(int amount) {
        
    }
	
	public void battle() {
		
	}
}