package remove;
import java.io.*;

public class DelPur
{
    public DelPur(String filename) throws IOException
    {
        filename += "Pur";
        new DelMain().delfile(filename);
    }
}