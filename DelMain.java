package remove;
import java.io.*;

public class DelMain
{
    public void delfile(String filename) 
    {
        File f = new File(filename + ".txt");
        f.delete();        
    }
}