
public class AdvanceCommanderFive extends person {
    private String special;
    private double salary;
    protected int Victory = 0;
    public AdvanceCommanderFive(String firstName, String lastName) {
        super(firstName, lastName);
        success = 60; 
        salary = 1000;
    }
    
    
   
    public void pay() {
    	
    	if(Victory >= 1) {
    		
    		balance += salary;
    		
    	}
    	
    	
		if(flawless >= 4) {
    		
    		balance += 5000;
    	}
    	
    	if (flawless >=10) {
            balance += 30000;
        }
    }

   
    public void raise(int amount) {
       if(Victory >= 2) {
    	   
    	   salary += amount;
    	   
       }
    	
    	
    	
    }
    
    public void battle() {
    	if (Math.random()*100 <= success) {
            Victory +=1;
            flawless += 1;

        }else {
            flawless = 0;
        }
    	
    		
    		
    		
    		
    	}
    	
   
    	
    
    	
    }
