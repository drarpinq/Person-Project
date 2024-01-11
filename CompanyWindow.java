import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CompanyWindow extends JFrame {

	private JTextArea displayResults;
	private JComboBox selectEmployee;
	private JComboBox selectEmployeeType;
	private JTextArea employeeListDisplay;
	private JButton addEmployee;
	private JButton removeEmployee;
	private JButton payAll;
	private JButton raise;
	private JTextField raiseAmt;
	private JTextField firstName;
	private JTextField lastName;
	
	private PersonnelManager theList;
	
	
	public static void main(String[] args) {
		new CompanyWindow();
	}
	
	public CompanyWindow(){
		JPanel windowPane=new JPanel();
		windowPane.setLayout(new BorderLayout());
		displayResults=new JTextArea();
		displayResults.setText("Starting new Company \n");
		displayResults.setEditable(false);
		windowPane.add(new JScrollPane(displayResults),BorderLayout.CENTER);
		
		
		theList=new PersonnelManager();
		
		JPanel employeeListPane=new JPanel();
		employeeListPane.setLayout(new BorderLayout());
		employeeListPane.add(new JLabel("Employee List"),BorderLayout.NORTH);
		employeeListDisplay=new JTextArea();
		employeeListDisplay.setEditable(false);
		employeeListPane.add(new JScrollPane(employeeListDisplay));
		windowPane.add(employeeListPane,BorderLayout.WEST);
		
		JPanel tools=new JPanel();
		windowPane.add(tools,BorderLayout.NORTH);
		selectEmployee=new JComboBox();
		tools.add(new JLabel("Selected Employee: "));
		tools.add(selectEmployee);
		
		removeEmployee=new JButton("Remove Employee");
		tools.add(removeEmployee);
		removeEmployee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(theList.getNumberOfEmployees()!=0){
					displayResults.setText(displayResults.getText()+"\nFiring Employee: "+theList.getEmployeeName(selectEmployee.getSelectedIndex()));
				theList.removeEmployee(selectEmployee.getSelectedIndex());
				employeeListDisplay.setText(theList.getEmployeeList());
				}else{
					JOptionPane.showMessageDialog(null,"No employees");
				}
				reWorkEmployeeSelector();
			}
		});
		payAll=new JButton("Pay");
		payAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String newText=displayResults.getText();
				newText+="\nPaying All Employees\n";
				displayResults.setText(newText+theList.payAllEmployees());
			}
		});
		tools.add(payAll);
		JButton battle = new JButton("Battle");
        battle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newText=displayResults.getText();
                newText+="\nPriming the Cannons\n";
                newText+="\nMounting Horses\n";
                newText+="\nSharpening Swords\n";
                newText+="\nFletching Arrows\n";
                newText+="\nFeeding Elephants\n";
                
                displayResults.setText(newText+theList.goToWar());
            }
        });
        tools.add(battle);
        
    	tools.add(payAll);
		/*JButton Reinforce = new JButton("Reinforce");
        battle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newText=displayResults.getText();
                newText+="\nResupplying commanders with new divisons.\n";
                
                displayResults.setText(newText+theList.goToWar());
            }
        });
        tools.add(Reinforce);
        */
    	
    	JButton BattlesWon = new JButton("BattlesWon = " );
        battle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newText=displayResults.getText();
                
                newText+="\nResupplying commanders with new divisons.\n";
                
                displayResults.setText(newText+theList.goToWar());
            }
        });
        tools.add(BattlesWon);
        
        
		raise=new JButton("Raise");
		raise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String newText=displayResults.getText();
					newText+="\nGiving all employes a $"+raiseAmt.getText()+" raise";
					displayResults.setText(newText+theList.raiseForAll(Integer.parseInt(raiseAmt.getText())));
				}catch(NumberFormatException n){
					JOptionPane.showMessageDialog(null,"Type a number for the raise");
				}
				
			}
		});
		tools.add(raise);
		raiseAmt=new JTextField(5);
		tools.add(raiseAmt);
		
		JPanel bottomPanel=new JPanel();
		selectEmployeeType=new JComboBox();
		
		//YOU WILL WANT TO CHANGE THESE SO THAT THEY FIT YOUR PEOPLE
			selectEmployeeType.addItem("Cavalry Division");
			selectEmployeeType.addItem("Infantry Division");
			selectEmployeeType.addItem("Tank Division(Elephant)");
			selectEmployeeType.addItem("Archer Division)");
			selectEmployeeType.addItem("Cannon Division");
		
		bottomPanel.add(selectEmployeeType);
		bottomPanel.add(new JLabel("First Name:"));
		firstName=new JTextField(5);
		bottomPanel.add(firstName);
		bottomPanel.add(new JLabel("Last Name:"));
		lastName=new JTextField(5);
		bottomPanel.add(lastName);
		addEmployee=new JButton("Add Employee");
		bottomPanel.add(addEmployee);
		addEmployee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				person newPerson = null;
				int selected=selectEmployeeType.getSelectedIndex();
				
				//YOUT WILL WANT TO CHANGE THESE SO THEY FIT YOUR PEOPLE
					if(selected==0){
						newPerson=new AdvanceCommanderOne(firstName.getText(),lastName.getText());
					} else if(selected==1){
						newPerson=new AdvanceCommanderTwo(firstName.getText(),lastName.getText());
					}else if(selected==2){
						newPerson=new AdvanceCommanderThree(firstName.getText(),lastName.getText());
					}
					else if(selected==3){
						newPerson=new AdvanceCommanderFour(firstName.getText(),lastName.getText());
					}
					else if(selected==4){
						newPerson=new AdvanceCommanderFive(firstName.getText(),lastName.getText());
					}
					
					
				
				theList.addEmployee(newPerson);
				displayResults.setText(displayResults.getText()+"\nAdding New Employee: "+theList.getEmployeeName(theList.getNumberOfEmployees()-1));
				employeeListDisplay.setText(theList.getEmployeeList());
				reWorkEmployeeSelector();
			}
		});
		windowPane.add(bottomPanel,BorderLayout.SOUTH);
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(windowPane);
		this.setSize(600,500);
		this.setVisible(true);
	}
	
	public void reWorkEmployeeSelector(){
		selectEmployee.removeAllItems();
		for(int i=0;i<theList.getNumberOfEmployees();i++){
			selectEmployee.addItem(theList.getEmployeeName(i));
		}
	}

}
