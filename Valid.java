package validation;
import java.util.regex.*;
import java.io.*;

class InvalidName extends Exception
{
    InvalidName(String s)
    {
        super(s);
    }
}

class InvalidId extends Exception
{
    InvalidId(String s)
    {
        super(s);
    }
}

class InvalidSem extends Exception
{
    InvalidSem(String s)
    {
        super(s);
    }
}

class InvalidBranch extends Exception
{
    InvalidBranch(String s)
    {
        super(s);
    }
}

class InvalidPassword extends Exception
{
    InvalidPassword(String s)
    {
        super(s);
    }
}

class InvalidBook extends Exception
{
    InvalidBook(String s)
    {
        super(s);
    }
}

public class Valid
{
    public boolean UserName(String name)
    {
        boolean b = false;
        try
        {
            if(name.isEmpty())
            {
                throw new InvalidName("");
            }
        }
        catch(InvalidName e)
        {
            System.out.println("----->> Oops!! Username field is empty.");
            return true;
        }

        b = true;
        char data[] = name.toCharArray();
        for(int i = 0; i< data.length; i++)
        {
            if(!(data[i] == ' '))
            {
                b = false;
                break; 
            }
        }
        try
        {
            if(b)
                throw new InvalidName("");
        }
        catch(InvalidName e)
        {
            System.out.println("----->> Oops!! Username field is empty.");
            return true;
        }

        name = name.trim();
        Pattern p = Pattern.compile("[^A-Za-z ]");
        Matcher m = p.matcher(name);
        b = m.find();
        try
        {
            if(b)
                throw new InvalidName("");
            
        }
        catch(InvalidName e)
        {
            System.out.println("----->> No special characters or digits are allow in name");
            return true;
        }

        String data1[] = name.split(" ");
        try
        {
            if(data1.length > 2)
                throw new InvalidName("");
        }
        catch(InvalidName e)
        {
            System.out.println("----->> Enter your username as (First_Name<space>Last_Name) formate.");
            return true;
        }        

        return false;
    }

    public boolean UserId(String id)
    {
        boolean b = false;
        try
        {
            if(id.isEmpty())
            {
                throw new InvalidId("");
            }
        }
        catch(InvalidId e)
        {
            System.out.println("----->> Oops!! Userid field is empty.");
            return true;
        }

        b = true;
        char data[] = id.toCharArray();
        for(int i = 0; i < data.length; i++)
        {
            if(!(data[i] == ' '))
            {
                b = false;
                break; 
            }
        }
        try
        {
            if(b)
                throw new InvalidId("");
        }
        catch(InvalidId e)
        {
            System.out.println("----->> Oops!! Userid field is empty.");
            return true;
        }
        
        id = id.trim();
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(id);
        b = m.find();
        
        try
        {
            char c[] = id.toCharArray();

            if(!b)
            {
                if(c.length == 8)
                {
                    if(!((c[0] > 47 && c[0] < 58) && (c[1] > 47 && c[1] < 58) && (c[5] > 47 && c[5] < 58) && (c[6] > 47 && c[6] < 58) && (c[7] > 47 && c[7] < 58)))
                    {
                        throw new InvalidId("");                    
                    }

                    if(!b)
                    {
                        String s = new String();
                        s = Character.toString(c[2]) + Character.toString(c[3]) + Character.toString(c[4]);
                        p = Pattern.compile("[^A-Za-z]");
                        m = p.matcher(s);
                        b = m.find();
    
                        if(b)
                            throw new InvalidId("");
                    }                                    
                }
                else
                {
                    throw new InvalidId("");
                }
            }
            else
            {
                throw new InvalidId("");
            }
        }
        catch(InvalidId e)
        {
            System.out.println("----->> Enter your correct roll number as userid.");
            return true;
        }
        return false;
    }

    public boolean Sem(int sem)
    {
        try
        {
            if(!(sem < 9 && sem > 0))
                throw new InvalidSem(""); 
        }
        catch(InvalidSem e)
        {
            System.out.println("----->> Enter the semester between 1 to 8.");
            return true;
        }
        return false;
    }

    public boolean Branch(String brc)
    {
        boolean b = false;
        try
        {
            if(brc.isEmpty())
            {
                throw new InvalidBranch("");
            }
        }
        catch(InvalidBranch e)
        {
            System.out.println("----->> Oops!! Branch field is empty.");
            return true;
        }

        b = true;
        char data[] = brc.toCharArray();
        for(int i = 0; i< data.length; i++)
        {
            if(!(data[i] == ' '))
            {
                b = false;
                break; 
            }
        }

        try
        {
            if(b)
                throw new InvalidBranch("");
        }
        catch(InvalidBranch e)
        {
            System.out.println("----->> Oops!! Branch field is empty.");
            return true;
        }

        brc = brc.trim();
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(brc);
        b = m.find();

        try
        {
            if(b)
            throw new InvalidBranch("");
        }
        catch(InvalidBranch e)
        {
            System.out.println("----->> No special characters, digits or white space is allow.");
            return true;
        }
        return false;
    }

    public boolean Password(String pass)
    {
        try
        {
            if(pass.isEmpty())
            {
                throw new InvalidBranch("");
            }
        }
        catch(InvalidBranch e)
        {
            System.out.println("----->> Oops!! Password field is empty.");
            return true;
        }
        
        try
        {
            if(pass.contains(" "))
            {
                throw new InvalidPassword("") ;
            }
        }
        catch(InvalidPassword e)
        {
            System.out.println("----->> No white spaces are allow.");
            return true;
        }

        boolean b = true;
        char data[] = pass.toCharArray();
        for(int i = 0; i< data.length; i++)
        {
            if(!(data[i] == ' '))
            {
                b = false;
                break; 
            }
        }

        try
        {
            if(b)
                throw new InvalidPassword("");
        }
        catch(InvalidPassword e)
        {
            System.out.println("----->> Oops!! Password field is empty.");
            return true;
        }
        return false;
    }

    public boolean Book(String book)
    {
        boolean b = false;
        try
        {
            if(book.isEmpty())
            {
                throw new InvalidBook("");
            }
        }
        catch(InvalidBook e)
        {
            System.out.println("----->> Oops!! Book name field is empty.");
            return true;
        }

        b = true;
        char data[] = book.toCharArray();
        for(int i = 0; i< data.length; i++)
        {
            if(!(data[i] == ' '))
            {
                b = false;
                break; 
            }
        }

        try
        {
            if(b)
                throw new InvalidBook("");
        }
        catch(InvalidBook e)
        {
            System.out.println("----->> Oops!! Book name field is empty.");
            return true;
        }

        book = book.trim();
        Pattern p = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher m = p.matcher(book);
        b = m.find();
        
        try
        {
            if(b)
                throw new InvalidBook("");
        }
        catch(InvalidBook e)
        {
            System.out.println("----->> No special characters are allow.");
            return true;
        }

        return false;
    }
}