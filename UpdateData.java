package updatedata;
import java.io.*;
import java.util.*;

//class for updating data in BookList file and user's file

public class UpdateData
{
    public UpdateData(String line, String filename) throws IOException
    {

        String data[] = line.split(" ");
        String dataLine[];

        //copy data from main file to copy-file
        BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename + "1.txt"));
        PrintWriter pw = new PrintWriter(bw);

        while((line = br.readLine()) != null)
        {
            boolean flag = true;
            dataLine = line.split(" ");

            int min = data.length < dataLine.length ? data.length : dataLine.length;

            for(int i = 0 ; i < min; i++)
            {
                if(data[i].equals(dataLine[i]))
                    flag = false;
                else 
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                pw.println(line);
            }
        }
        
        pw.flush();
        pw.close();
        br.close();
        bw.close();

        //copy data from copy-file to main file 
        File f1 = new File(filename + "1.txt");
        if(f1.length() != 0)
        {
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(filename + ".txt"));
            BufferedReader br2 = new BufferedReader(new FileReader(filename + "1.txt"));
            PrintWriter pw2 = new PrintWriter(bw2);

            while((line = br2.readLine()) != null)
            {
                pw2.println(line);
            }

            br2.close();
            bw2.close();
            pw2.flush();
            pw2.close();

            //deleting the copy-file
            File f = new File(filename + "1.txt");
            f.delete();
        }
        else
        {
            //if file is empty then delete the files.
            File f = new File(filename + ".txt");
            f.delete();
            f1.delete();
            
        }     
    }
}