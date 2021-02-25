package remove;
import java.io.*;

public class DelAcc
{
    public DelAcc(String filename) throws IOException
    {
        
        DelMain obj = new DelMain();       
        obj.delfile(filename);
        new DelSell(filename);
        obj.delfile(filename + "Sold");
        obj.delfile(filename + "Pur");
    }
}