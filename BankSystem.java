package Application;

import java.net.InetAddress;
import java.util.ArrayList;


//  Created by Clayton Paplaczyk	

//  Description: The BankSystem class has a list of customers and a list of banks that
//			     can be organized at the bank system. The bank system will be a fully
//			     encapsulated object.


public class BankSystem {
	
	//private ArrayList customerList, bankList; //A list of customers and banks in the bank system
	

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<Bank> bankList = new ArrayList<Bank>();
	
	
	public int customerExists(String a){
		for(int i=0; i<customerList.size(); i++){
			if(((Customer)customerList.get(i)).getCustomerID().equals(a))
			return -1;
		}
			return 1;
	}
	
	public boolean addCustomer(String a){
		Customer addCust=(Customer)CustomerParser.parseStringToCustomer(a);

		if(customerExists(a) != -1){
			customerList.add(addCust);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeCustomer(String c){
		int origSize = customerList.size();
		if(customerList.size() > origSize){
			customerList.remove(customerExists(c));
			return true;
		}
		else 
			return false;
	}
	
	public void sortCustomers(){
		Sorts.sort(customerList);
	}
	
	public String listCustomers(){
		String output = "";
		if(customerList.isEmpty()) //if no cust
			output = "no customer\n";
		else
		{
			for(int i = 0; customerList.size()>i; i++){
				output = ((Customer)customerList.get(i)).toString();
				System.out.print(output);
			}
		}
		//System.out.print(output);
		return output;
	}
	
	public int bankExists(String bankName, int bankID, String city, String state){
		for(int i = 0; bankList.size() > i; i++){
			if((((Bank)bankList.get(i)).getBankID()) > 0);
			return 1;
		}
		return -1;
	}
	
	public boolean addBank(String c){
		Bank addBk = (Bank)BankParser.parseStringToBank(c);
		String a = addBk.getBankName();
		int b = addBk.getBankID();
		String d = addBk.getBankAddress().getCity();
		String e = addBk.getBankAddress().getState();
		
		if(bankExists(a, b, d, e) == -1){
			bankList.add(addBk);
			return false;
			
		}
		else
			//bankList.add(addBk);
			return true;
	}
	
	public boolean removeBank(String bankName, int bankID, String city, String state){
		if(-1 != bankExists(bankName, bankID, city, state) )
			return false;
		else{
			customerList.remove(bankExists(bankName, bankID, city, state));
			return true;
		}
	}
	
	public void sortBanks(){
		Sorts.sort(bankList);
	}
	
	public String listBanks(){
		String output = "";
		if(bankList.isEmpty()){ //if no cust
			output = "no bank\n";
			System.out.print(output);
		}
		else
		{
			Bank banks = new Bank(); //to print out cust info calls toString from Customer
			for(int i = 0; bankList.size()>i; i++){
				output = ((Bank)bankList.get(i)).toString();
				System.out.println(output);
			}
		}
		//System.out.println(output);
		return output;
	}
	
	public void closeBankSystem(){ //clears out customer list and bank list
		customerList.clear(); //clears all customers
		bankList.clear(); //clears all banks 
	}
}
