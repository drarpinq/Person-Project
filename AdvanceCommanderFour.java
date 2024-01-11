
public class AdvanceCommanderFour extends person {
    private String special;
    private double salary;
    protected int Victory = 0;
    public AdvanceCommanderFour(String firstName, String lastName) {
        super(firstName, lastName);
        success = 60; 
        salary = 5000;
    }
    
    
   
    public void pay() {
    	
    	if(Victory >= 1) {
    		
    		balance += salary;
    		
    	}
    	
    	if(flawless >= 3) {
    		
    		balance += 50000;
    	}
    	
    	if (flawless >=5) {
            balance += 70000;
        }
    	
    	if(flawless >= 10) {
    		
    		balance += 100000;
    	}
    }

   
    public void raise(int amount) {
       if(Victory >= 1) {
    	   
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
