package homepage;
import java.util.*;
import java.io.*;
import session.*;


class Homepage
{
    public static void main(String args[]) throws IOException
    {
        System.out.println("_______________________________________________WELCOME TO______________________________________________________________");
        System.out.println();
        System.out.println("         #####   #######  #######  ##   ##  ######  #####    #######  ####     ######       ##      ");
        System.out.println("         #    ## ##   ##  ##   ##  ##  ##     ##    ##   ##  ##       ##   ##    ##        ####     ");  
        System.out.println("         #####   ##   ##  ##   ##  ####       ##    ##   ##  #######  ##    ##   ##       ##  ##    ");
        System.out.println("         #####   ##   ##  ##   ##  ####       ##    ## ###   #######  ##    ##   ##      ########   ");
        System.out.println("         #    ## ##   ##  ##   ##  ##  ##     ##    ##       ##       ##  ##     ##     ##      ##  ");
        System.out.println("         ######  #######  #######  ##   ##  ######  ##       #######  ####     ######  ##        ## ");
        System.out.println();
        System.out.println("________________________________________________________________________________________________________________________");
        

        Scanner so = new Scanner(System.in);
        
        int choice;
        do
        { 
            // print menu for appropriate action
            System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("                                                  MAIN MENU");
            System.out.print("\n\t1. Log in\n\t2. Register\n\t3. Exit\n----->> ");
            choice = so.nextInt();
            System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------\n");
            switch(choice)
            {
                case 1: new ForLogIn().getDetails();  //open login section             
                        break;
                case 2: new ForRegister().getDetails(); // open register section
                        break;
                case 3: break;

                default: System.out.println("=====> Please enter valid choice.");
            }
        }while(choice != 3);
        
    }
}