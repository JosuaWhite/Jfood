import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer
{
    private int id;
    private String name;
    private String email;
    private String password;
    private Calendar joinDate;
    
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    public Customer(int id, String name, String email, String password, int year, int month, int day)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = new GregorianCalendar(year,month,day);   
    }
    
    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = null;   
    }

    public int getid()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
        
    public String getEmail()
    {
        setEmail(email);
        return email;
    }
        
    public String getPassword()
    {
        setPassword(password);
        return password;
    }
        
    public Calendar JoinDate()
    {
        return joinDate;
    }
        
    public void setId(int id)
    {
        this.id = id;
    }
            
    public void setName(String name)
    {
        this.name = name;
    }
            
    public void setEmail(String email)
    {
        Pattern p = Pattern.compile("^[a-zA-Z0-9&*_~]+(?:\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)*$");
        Matcher m = p.matcher(email);
        if (m.matches()==true)
        {
            this.email = email;
        }
        else
        {
            this.email = null;
        }
    }
            
    public void setPassword(String password)
    {
        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,})");
        Matcher m = p.matcher(email);
        if (m.matches()==true)
        {
            this.password = password;
        }
        else
        {
            this.password = null;
        }
    }
        
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
    public void setJoinDate(int year, int month, int day)
    {
        this.joinDate = new GregorianCalendar(year,month,day);
    }
    
    public String toString()
    {
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String tanggal = format1.format(joinDate);            
        
        return (
        "ID        : "+id+"\n"+
        "Nama      : "+name+"\n"+
        "Email     : "+email+"\n"+
        "Password  : "+password+"\n"+
        "Join date : "+tanggal+"\n"
        );
    }
}
