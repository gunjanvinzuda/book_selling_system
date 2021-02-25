package implogin;
import java.io.IOException;
import loginsession.*;

public class ImpLogIn
{
    String filename = new String();
    String userName = new String();
    String userId = new String();
    String password = new String();

    //constructor to assign value to varaiable
    public ImpLogIn(String userId, String userName, String password)
    {
        filename = userId + userName;
        this.userId  = userId;
        this.userName = userName;
        this.password = password;
    } 
    public void runLogIn()
    {
        LogIn obj = new LogIn();
        boolean check = obj.validUser(filename, password);
        //if account exist check is true and will print all details of user
        if(check)
            check = obj.readFile(filename);
        else
            System.out.println("No account was found with given data.");
        // if data is successfully printed open session       
        if(check)
        {
            try
            {
                obj.openSession(userId, userName);
            }
            catch(IOException e) {}
        }
    }
}