package register;
import java.io.*;

public class Register
{
    public void createUser(String password,String userName, String userId, int sem, String branch) throws IOException
    {
        String filename = userId + userName;

        File f = new File(filename + ".txt");
    
        if(f.createNewFile())
        {
            //creating a new file and storing all the data
            BufferedWriter fw = new BufferedWriter(new FileWriter(filename + ".txt"));
            fw.write(password + "\n");
            fw.write("Name: " + userName + "\n");
            fw.write("Roll number: " + userId + "\n");
            fw.write("Semester: " + sem + "\n");
            fw.write("Branch: " + branch + "\n\n");
            fw.close();

            System.out.println("\n----->> Registered successfully");
            System.out.println("+++++)) Remember your data for further reference");
        }
        else 
        {
            System.out.println("Sorry!! Error in registration.");
        }
    }
}