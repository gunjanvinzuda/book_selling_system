package remove;
import java.io.*;

public class DelSold
{
    public DelSold(String filename) throws IOException
    {
        filename += "Sold";
        new DelMain().delfile(filename);
    }
}