package purchase;
import java.io.*;
import java.util.*;
import updatedata.*;
import forpursell.ForPurSell;

public class Purchase
{
    //print the list of selling book form BookList file
    public boolean printList(String userId, String userName) throws IOException
    {
        Scanner so = new Scanner(System.in);
        int count = 0 ;
        String line = new String();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("BookList.txt"));
            count = 1;
            while((line = br.readLine()) != null)
            {
                System.out.println((count++) + ")" + line);
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Oop! Sorry! There is no book available for purchase");
            return false;
        }

        count--;
        //choose the book from list
        BufferedReader fr = new BufferedReader(new FileReader("BookList.txt"));
        System.out.print("Enter the book-number: ");
        int lineNum = so.nextInt();

        while(lineNum < 1 || lineNum > count)
        {
            System.out.print("------>> Please enetr correct choice: ");
            lineNum = so.nextInt();
        }
        count = 1;

        //storing the respective book's line 
        while(count != (lineNum + 1))
        {
            line = fr.readLine();
            count++;
        }
        fr.close();
        
        String line2 = new String();
        String data[] = line.split(" ");
        String filename = data[0] + data[1] + " " + data[2];//filename for user's account
        for (int i = 3; i < data.length; i++)
        {
            line2 += data[i] + " ";
        }
        line2 = line2.trim();

        //updating data in BookList and user's file
        UpdateData obj  = new UpdateData(line, "BookList");
        UpdateData obj2 = new UpdateData(line2, (filename + "Sell"));
        new ForPurSell(line2, (filename + "Sold"));
        new ForPurSell(line2, (userId + userName + "Pur"));
        return true;
    }
}