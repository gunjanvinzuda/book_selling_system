package appending;
import java.io.*;

public class UserAcc 
{
    public UserAcc(String userId, String userName, String bookName, int price) throws IOException
    {
        String filename = userId + userName;
        BufferedWriter fw = new BufferedWriter(new FileWriter(filename + "Sell.txt",true));

        fw.write(bookName + " " + price + "\n");
        fw.close();
    }
}