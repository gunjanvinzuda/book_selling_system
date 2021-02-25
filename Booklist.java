package appending;
import java.io.*;

//append the details of book in BookList
public class Booklist 
{
    public Booklist(String userId, String userName, String bookName, int price) throws IOException
    {
        BufferedWriter fw = new BufferedWriter(new FileWriter("BookList.txt",true));

        fw.write(userId + " " + userName + " " + bookName + " " + price + "\n");
        fw.close();
    }

}