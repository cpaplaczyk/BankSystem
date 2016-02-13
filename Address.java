package Application;

//         Created by Clayton Paplaczyk	
//  Description: The Address class describes city and state of a bank.
//  			 It will be used as an aggregate object of the Bank class. It has following attributes:

public class Address
 {
   // instance variables
   private String city;
   private String state;

   
  // Constructor method to initialize intance variables.

   public Address()
    {
     city = new String("?");
     state= new String("?");
    }

 
   //This method returns the city of the address.
   
   public String getCity()
    {
     return city;
    }

  
  // This method returns the state of the address.
  
   public String getState()
    {
     return state;
    }

  
 //  This method sets the city of the address given by its parameter.
 
   public void setCity(String city)
    {
     this.city = city;
    }

  
   //This method sets the state of the address by its parameter.

   public void setState(String state)
    {
      this.state = state;
    }


   //This method return a string containing the attribute information in address
 
   public String toString()
    {
     String result;
     result = city + "," + state;

      return result;
    }

}
