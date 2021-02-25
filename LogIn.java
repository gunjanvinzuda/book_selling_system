package loginsession;
import java.io.*;
import java.util.*;
import sell.*;
import purchase.*;
import remove.*;

public class LogIn
{
    Scanner so = new Scanner(System.in);

    public boolean validUser(String filename, String password)
    {
        try
        {
            File f = new File(filename + ".txt");
            if(!f.exists())//if file not exist throw exception
                throw new IOException(" ");
            else
            {
                BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"));
                if(!(br.readLine().equals(password)))//check if the user entered correct password.
                {
                    br.close();
                    throw new IOException(" ");
                }
                br.close();                
            }
        }
        //if account not found return false 
        catch(IOException e)
        {
            return false;
        }
        return true;
    }

    public boolean readFile(String filename)
    {
        int ch = '0';
        try
        {     
            BufferedReader br;  
            String line ;
            int count = 0;
            System.out.println("_______________________________________________________________________________");
            System.out.println("\n-------->> Your details...");
            //read data in file upto end
            br = new BufferedReader(new FileReader(filename + ".txt"));
            count = 0;
            while((line = br.readLine()) != null)
            {
                if(count == 0)
                    count++;
                else
                    System.out.println(line);
            }
            br.close();

            try
            {
                //read content of file which has list of books for selling
                System.out.println("_______________________________________________________________________________");
                System.out.println("\n\n----->> Your books for selling\n");  
                br = new BufferedReader(new FileReader(filename + "Sell.txt"));
                while((ch = br.read()) != -1)
                    System.out.print((char)ch);
                System.out.println();
                br.close();
            }
            catch(IOException e)
            {
                System.out.println("*** You do not have any record for book sellings. ***");
            }
            System.out.println("_______________________________________________________________________________");
            try
            {
                //print all book sold by the user
                System.out.println("_______________________________________________________________________________");
                System.out.println("\n\n----->> The books you have sold\n");                
                br = new BufferedReader(new FileReader(filename + "Sold.txt"));
                while((ch = br.read()) != -1)
                    System.out.print((char)ch);
                System.out.println();
                br.close();
            }
            catch(IOException e)
            {
                System.out.println("*** You do not have any record of sold books. ***");
            }
            System.out.println("_______________________________________________________________________________");

            try
            {    
                //print all book purchased by the user
                System.out.println("_______________________________________________________________________________");
                System.out.println("\n\n\n----->> The books you have purchased\n");
                br= new BufferedReader(new FileReader(filename + "Pur.txt"));
                while((ch = br.read()) != -1)
                    System.out.print((char)ch);
                System.out.println();
                br.close();
            }  
            catch(IOException e)
            {
                System.out.println("*** You do not have any record of purchased books. ***");
            }
            System.out.println("_______________________________________________________________________________");
        }
        catch(IOException e)
        {
            return false;
        }
        return true;
    }
    
    //gives further option to sell book, purchase book or logout once logged in
    public void openSession(String userId, String userName) throws IOException
    {
        String filename = userId + userName;
        int choice = 0;
        char c = '0';
        outer: 
        {
            do
            {
                System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------\n");
                System.out.println("\n\t1. Add books for selling\n\t2. Purchase book\n\t3. Delete record\n\t4. Display record\n\t5. LogOut");
                choice = so.nextInt();
                switch(choice)
                {   
                    //print the book to be sold in user account
                    case 1: new Sell().getBookDetails(userId, userName);
                            System.out.println("------>> Your data is successfully entered.");
                            break;
                    
                    //print purchased book to user account and remove from user who want to sell 
                    case 2: boolean b = new Purchase().printList(userId, userName);
                            if(b)
                                System.out.println("----->> You have perchased book successfully.");                    
                            break;
                    
                    case 3: System.out.println("\n\t1. Delete account\n\t2. Delete Record of selling books\n\t3. Delete record of sold books\n\t4. Delete record of purchased books");
                            int ch = so.nextInt();
                            switch(ch)
                            {                            
                                case 1: System.out.println("~~~~~)) Are you sure you want to delete your account: Y(yes) or N(No)");
                                        
                                        do
                                        {               
                                            c = so.next().charAt(0);                     
                                            if(c == 'Y' || c == 'y' || c == 'N' || c == 'n')
                                            {
                                                if(c == 'Y' || c == 'y')
                                                {
                                                    new DelAcc(filename);
                                                    System.out.println("*** Your account has deleted successfully. ***");
                                                    break outer;
                                                }  
                                                else
                                                    c = '0';                                      
                                            }
                                            else
                                                System.out.println("------)) Please enter valid choice.");
                                        }while(c !='0');                                    
                                        break;
                                
                                case 2: new DelSell(filename);
                                        break;
    
                                case 3: new DelSold(filename);
                                        break;
                                
                                case 4: new DelPur(filename);
                                        break;
    
                                default: System.out.println("=====>> Please enter valid choice.");
                            }
                            if(c == '0')
                                System.out.println("*** Your record has successfully deleted. ***");
                            break;
                    case 4: readFile(filename);
                            break;
    
                    case 5: break;
    
                    default: System.out.println("=====>> Please enetr valid choice..!!");
                }
            }while(choice != 5 || c != '0');
    
        } 
    }                  
    
}