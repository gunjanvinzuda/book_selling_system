package session;
import java.io.IOException;
import java.util.*;
import implogin.ImpLogIn;
import loginsession.*;
import validation.*;

//interface to get details of user
interface Details
{
    Scanner so = new Scanner(System.in);
    public void getDetails();
}

public class ForLogIn implements Details
{
    public void getDetails()
    {
        String userId = new String();
        String userName = new String();
        String password = new String();

        boolean check = false;
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("                                                     LOGIN PAGE");
        Valid obj = new Valid(); 

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
                check = obj.Password(password);//check if password does contains any white spaces.
                if(check)
                    throw new Exception("");
            }
            catch(Exception e)
            {
                System.out.println("-----)) Please re-enter the password");
            }
        }while(check);

        ImpLogIn obj2 = new ImpLogIn(userId, userName, password);
        obj2.runLogIn();
        
    }
}