package sell;
import java.io.*;
import java.util.*;
import appending.*;
import validation.*;

//exception for negative integer input
class NegativeAmount extends Exception
{
    NegativeAmount(String s)
    {
        super(s);
    }
}

public class Sell
{
    public void getBookDetails(String userId,String userName) throws IOException
    {
        Scanner so = new Scanner(System.in);
        int ch = 0; 
        String bookName = new String(); 
        boolean b = false;
        int price = 0;
        System.out.println("----------------------------------------------");
        System.out.println("\n---->Enter your books details.... ");
        // so.nextLine();
        System.out.print("      Name: ");
        do
        {
            try
            {
                bookName = so.nextLine();
                b = new Valid().Book(bookName);
                if(b)
                    throw new Exception("");
            }
            catch(Exception e)
            {
                System.out.println("Please re-enter the book name.");
            }
        }while(b);
       
        do
        {
            try
            {
                System.out.print("      Price: ");
                price = so.nextInt();
                ch = 1;
                if(price < 0)
                {
                    try
                    {
                        throw new NegativeAmount(" ");
                    }
                    catch(NegativeAmount e)
                    {
                        System.out.println("Negative amount of price!! Please re-enter the price");
                        ch = 0;
                    }                    
                }
                
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid data!! Please re-enter the price");
                ch = 0;
            }
        }while(ch != 1);
        System.out.println("----------------------------------------------");

        Booklist obj = new Booklist(userId, userName, bookName, price); 
        UserAcc obj2 = new UserAcc(userId, userName, bookName, price);
    }
}