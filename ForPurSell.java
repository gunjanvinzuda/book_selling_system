package forpursell;
import java.io.*;

public class ForPurSell
{
    public ForPurSell(String line, String filename) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".txt",true));

        bw.write(line + "\n");
        bw.close();
    }
}