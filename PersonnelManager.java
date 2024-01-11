import java.util.ArrayList;

public class PersonnelManager {

	private ArrayList employees;
	
	public PersonnelManager(){
		employees=new ArrayList();
	}
	
	public int getNumberOfEmployees(){
		return employees.size();
	}
	
	public void removeAllEmployees(){
		employees=new ArrayList();
	}
	
	public void addEmployee(person p){
		employees.add(p);
	}
	
	public String getEmployeeList(){
		String list="";
		for(int i=0;i<employees.size();i++){
			person employee=(person)employees.get(i);
			list=list+employee.getClass().getName()+": "+employee.getFirstName()+", "+employee.getLastName()+"\n";
		}
		return list;
	}
	
	public String getEmployeeName(int number){
		person person=(person)employees.get(number);
		return person.getClass().getName()+": "+person.getFirstName()+", "+person.getLastName();
	}
	
	public String getEmployeeName(person employee){
		return employee.getClass().getName()+": "+employee.getFirstName()+", "+employee.getLastName();
	}
	
	public String getEmployeeBalance(person employee){
		return getEmployeeName(employee)+", Current cash: "+employee.getCashBalance()+"\n";
	}
	
	public void removeEmployee(int x){
		employees.remove(x);
	}
	
	public String payAllEmployees(){
		String printingPay="";
		for(int i=0;i<employees.size();i++){
			person employee=(person)employees.get(i);
			employee.pay();
			printingPay=printingPay+getEmployeeBalance(employee);
		}
		return printingPay;
	}
	
	public String raiseForAll(int x){
		String printingRaise="";
		for(int i=0;i<employees.size();i++){
			person employee=(person)employees.get(i);
			employee.raise(x);
			printingRaise=printingRaise+getEmployeeBalance(employee);
		}
		return printingRaise;
	}
	public String goToWar() {
        String printingWork="";
        for(int i=0;i<employees.size();i++){
            person employee=(person)employees.get(i);
            employee.battle();
            printingWork=printingWork+getEmployeeBalance(employee);
        }
        return printingWork;
    }
//(This is for the Personel manager, make sure to switch "work" to "battle") 

}
