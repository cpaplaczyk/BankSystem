package Application;

//  Created by Clayton Paplaczyk	
//  Description: The Application class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. It will create an object of BankSystem containing a list
//               of banks and customers, and perform insertion, deletion,
//               search, sorting, displaying, closing, writing to a file,
//               and reading from a file.

import java.io.*;

public class Application
 {
  public static void main (String[] args)
   {
	//allows files to be automatically inputed into Eclipse
	  /*try{
		  System.setIn(new FileInputStream("C:/Users/Clayton/Desktop/Java Programs/CSE205/src/Application/Tests/input2.txt")); // inputs test .txt file
		  }catch(IOException e){
			  e.printStackTrace();
		  }*/ 
	  
     char input1;
     String inputInfo = new String(), inputInfo2 = new String();
     String inputInfo3 = new String(), inputInfo4 = new String();
     boolean operation = false;
     int operation2 = 0;
     int bankID;
     String line = new String();
     String customerInfo = new String(), bankInfo = new String();
     String filename = new String();

     // create a BankSystem object. This is used throughout this class.
     BankSystem bankSystem1 = new BankSystem();

     try
      {
       // print out the menu
       printMenu();

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.print("What action would you like to perform?\n");
         line = stdin.readLine().trim();  //read a line
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)          //check if a user entered only one character
          {
           switch (input1)
            {
             case 'A':   //Add Customer
               System.out.print("Please enter the customer information to add:\n");
               inputInfo = stdin.readLine().trim();

               operation = bankSystem1.addCustomer(inputInfo); //Customer object
               
               if (operation == true)
                System.out.print("customer added\n");
               else
                System.out.print("customer exists\n");
               break;
             case 'B':   //Add Bank
               System.out.print("Please enter the bank information to add:\n");
               inputInfo = stdin.readLine().trim();

               operation = bankSystem1.addBank(inputInfo); //Bank object
               
               if (operation == true)
                 System.out.print("bank added\n");
               else
                 System.out.print("bank exists\n");
               break;
             case 'D':   //Search for Customer
               System.out.print("Please enter the customerID of a customer to search:\n");
               inputInfo = stdin.readLine().trim();

               operation2 = bankSystem1.customerExists(inputInfo); //Check existence of Customer object
               
               if (operation2 < 1)
                 System.out.print("customer found\n");
               else
                 System.out.print("customer not found\n");
               break;
             case 'E':  //Search for Bank
               System.out.print("Please enter the bank's name to search:\n");
               inputInfo = stdin.readLine().trim();
               System.out.print("Please enter the bank's id to search:\n");
               inputInfo2 = stdin.readLine().trim();
               bankID = Integer.parseInt(inputInfo2);
               System.out.print("Please enter the bank's city to search:\n");
               inputInfo3 = stdin.readLine().trim();
               System.out.print("Please enter the bank's state to search:\n");
               inputInfo4 = stdin.readLine().trim();

               operation2 = bankSystem1.bankExists(inputInfo, bankID, inputInfo3, inputInfo4); //checks existence of Bank object
               
               if (operation2 > -1)
                 System.out.print("bank found\n");
               else
                 System.out.print("bank not found\n");
               break;
             case 'L':   //List Customers

            	 bankSystem1.listCustomers(); //prints list of Customers
               break;
             case 'M':   //List Banks

            	 bankSystem1.listBanks(); //prints out list of Banks
               break;
             case 'O':  // Sort Customers

               bankSystem1.sortCustomers(); //calls sort, sorts Customers
               System.out.print("customers sorted\n");
               break;
             case 'P':  // Sort Banks

               bankSystem1.sortBanks(); //calls sort, sorts Banks
               System.out.print("banks sorted\n");
               break;
             case 'Q':   //Quit
               break;
             case 'R':  //Remove Customer
               System.out.print("Please enter the customerID to remove:\n");
               inputInfo = stdin.readLine().trim();

               operation = bankSystem1.removeCustomer(inputInfo); //removes Customer
               
               if (operation == true)
                 System.out.print("customer removed\n");
               else
                 System.out.print("customer not found\n");
               break;
             case 'S':  //Remove Bank
               System.out.print("Please enter the bank's name to remove:\n");
               inputInfo = stdin.readLine().trim();
               System.out.print("Please enter the bank's id to remove:\n");
               inputInfo2 = stdin.readLine().trim();
               bankID = Integer.parseInt(inputInfo2);
               System.out.print("Please enter the bank's city to remove:\n");
               inputInfo3 = stdin.readLine().trim();
               System.out.print("Please enter the bank's state to remove:\n");
               inputInfo4 = stdin.readLine().trim();

               operation = bankSystem1.removeBank(inputInfo, bankID, inputInfo3, inputInfo4); //removes a bank
               
               if (operation == true)
                 System.out.print("bank removed\n");
               else
                 System.out.print("bank not found\n");
               break;
             case 'T':  //Close BankSystem

               bankSystem1.closeBankSystem(); //closes the BankSystem
            	 
               System.out.print("bank system closed\n");
               break;
             case 'U':  //Write Text to a File
               System.out.print("Please enter a file name to write:\n");
               filename = stdin.readLine().trim();

              String fileName = "test.txt";
              
              System.out.print("Please enter a string to write in the file:\n");
              
              FileWriter fw = new FileWriter(fileName);
              BufferedWriter bw = new BufferedWriter(fw);
              PrintWriter outFile = new PrintWriter(bw);
              for(int i=0; i<=10;i++){
            	  outFile.println("The value is \n" + i);
              }
               
               break;
             case 'V':  //Read Text from a File
               System.out.print("Please enter a file name to read:\n");
               filename = stdin.readLine().trim();

               FileReader fr=null;
               BufferedReader inFile=null;
               String aline;
               filename="input.txt";

               try
                 {
                     fr = new FileReader (filename);
                    inFile = new BufferedReader (fr);

                    aline = inFile.readLine();
                    while (aline != null)
                    {
                      System.out.println(line + "was read/n");
                      aline = inFile.readLine();
                      System.out.println("The first line of the file is:\n" + line + "/n");
                    }

                    inFile.close();
                  }
                 catch (FileNotFoundException exception)
                 {
                    System.out.println (filename + " was not found/n");
                 }
                 catch (IOException exception)
                 {
                    System.out.println (exception);
                 }
                 finally
                 {
                     try
                     {
                         if (inFile != null)
                             inFile.close();
                     }
                     catch (IOException ex)
                     {
                         System.out.println(ex);
                      }
                 }
               
               break;
             case 'W':  //Serialize BankSystem to a File
               System.out.print("Please enter a file name to write:\n");
               filename = stdin.readLine().trim();

               FileOutputStream file1 = null;
               ObjectOutputStream outStream = null;
               try
                {
                  file1 = new FileOutputStream (filename);
                  outStream = new ObjectOutputStream (file1);

                  // Serialize this above object to a file
                 outStream.writeObject(bankSystem1);
                 }
             catch (NotSerializableException exception)
                {
                   System.out.println("NotSerializableException");
                }
               catch (IOException exception)
                {
                   System.out.println("IOExceotion");
                 }
              finally
                {
                     try
                       { if (outStream != null) outStream.close(); }
                     catch (IOException exc)
                        { System.out.println(exc); }
                 }
               
               break;
              case 'X':  //Deserialize BankSystem from a File
               System.out.print("Please enter a file name to read:\n");
               filename = stdin.readLine().trim();

               FileInputStream file2 = null;
               ObjectInputStream inStream = null;
               try
                {
                  file2 = new FileInputStream (filename);
                  inStream = new ObjectInputStream (file2);

                  // Deserialize the objects
                  Object obj1 = inStream.readObject();

                  if (obj1 instanceof Bank)
                     {
                         bankSystem1 = (BankSystem) obj1;

                          // Print the object
                          System.out.println (filename+" was read");
                     }
                }
              catch (ClassNotFoundException exception)
                {
                 System.out.println("Class was not found");
                }
              catch (FileNotFoundException exception)
                {
                 System.out.println( filename + " was not found");
                }
              catch (IOException exception)
                {
                 System.out.println("IOException has occured.");
                }
              finally
                {
                   try
                     {
                         if (inStream != null)
                             inStream.close();
                     }
                   catch (IOException exc)
                     {
                         System.out.println(exc);
                     }
                }
               
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q' || line.length() != 1);
      }
     catch (IOException exception)
      {
        System.out.print("IO Exception\n");
      }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Customer\n" +
                      "B\t\tAdd Bank\n" +
                      "D\t\tSearch for Customer\n" +
                      "E\t\tSearch for Bank\n" +
                      "L\t\tList Customers\n" +
                      "M\t\tList Banks\n" +
                      "O\t\tSort Customers\n" +
                      "P\t\tSort Banks\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove Customer\n" +
                      "S\t\tRemove Bank\n" +
                      "T\t\tClose BankSystem\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize BankSystem to File\n" +
                      "X\t\tDeserialize BankSystem from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
} // end of Application class

