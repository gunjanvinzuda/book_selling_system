package session;
import java.io.*;
import java.util.*;
import loginsession.LogIn;
import register.Register;
import validation.*;


public class ForRegister implements Details
{
    public void getDetails()
    {
     
        String userId = new String();
        String userName = new String();
        String branch = new String();
        String password = new String();
        String filename = new String();
        int sem = 0;
        boolean check = true ;
        char ch = 'N';
        Valid obj = new Valid(); 

        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             REGISTRATION PAGE"); 

        outer :
        {
            do
            {
                System.out.print("Enter username: ");
                do
                {
                    try
                    {
                        userName = so.nextLine();
                        check = obj.UserName(userName);//check if input string in not empty or not contains any special characters.
                        
                        if(check)
                            throw new Exception("");
                    }
                    catch(Exception e)
                    {
                        System.out.println("-----)) Please re-enter the username");
                    }
                }while(check);
                so.nextLine();
                System.out.print("Enter userid: ");
                do
                {
                    try
                    {
                        userId = so.nextLine();
                        check = obj.UserId(userId);//check if userid is correct roll number or not.
                        if(check)
                            throw new Exception("");
                    }
                    catch(Exception e)
                    {
                        System.out.println("-----)) Please re-enter the userid");
                    }
                }while(check);
                so.nextLine();
                System.out.print("Enter password: ");
                do
                {
                    try
                    {
                        password = so.nextLine();
                        check = obj.Password(password);//check if pass does not contains any white spaces.
                        if(check)
                            throw new Exception("");
                    }
                    catch(Exception e)
                    {
                        System.out.println("-----)) Please re-enter the password");
                    }
                }while(check);
            
                filename = userId + userName;
                File f = new File(filename + ".txt");
                check = f.exists();
                if(check)//if file is already exist.
                {
                    System.out.println("Account is already exist!!");
                    System.out.println("Do you want to re-enter the details or exit\n\tEnter: Y(Re-enter) or N(Exit)");
                    ch = so.next().charAt(0);
                    ch = Character.toLowerCase(ch);
                    if(ch == 'n')
                        break outer;
                    while(ch != 'n' || ch != 'y')
                    {
                        System.out.println("----->> Please enter correct choice");
                        ch = so.next().charAt(0);
                        ch = Character.toLowerCase(ch);
                    }
                }
            }while(check == true && (ch == 'y'));
            
            check = true;
            so.nextLine();
            System.out.print("Enter semester: ");
            do
            {
                try
                {
                    sem = so.nextInt();
                    check = obj.Sem(sem);//check if entered semester is between 1 to 8.
                    if(check)
                        throw new Exception("");
                }
                catch(Exception e)
                {
                    System.out.println("-----)) Please re-enter semester.");
                    so.nextLine();
                }
            }while(check);

            so.nextLine();
            System.out.print("\nEnter branch: ");
            do
            {
                try
                {
                    branch = so.nextLine();
                    check = obj.Branch(branch);//check if input string in not empty or not contains any special characters.
                    if(check)
                        throw new Exception("");
                }
                catch(Exception e)
                {
                    System.out.println("-----)) Please re-enter branch.");
                }
            }while(check);

            try
            {
                //create new account and register user
                new Register().createUser(password, userName, userId, sem, branch);
                new LogIn().readFile(userId + userName);
                new LogIn().openSession(userId, userName);
            } 
            catch(IOException e){}   
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------");
    }
}