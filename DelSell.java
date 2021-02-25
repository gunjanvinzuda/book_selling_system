package remove;
import java.io.*;
import updatedata.*;

public class DelSell
{
    public DelSell(String filename) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filename + "Sell.txt"));
        String line2 = filename.substring(0,8) + " " + filename.substring(8);
        String line;
        while((line = br.readLine()) != null)
        {
            line = line2 + " " + line;
            new UpdateData(line, "BookList");
        }
        br.close();
        filename += "Sell";
        new DelMain().delfile(filename);
    }
}