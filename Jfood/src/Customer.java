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
        this.joinDate = joinDate;
        this.joinDate.add(Calendar.MONTH,-1);
        setEmail(email);
        setPassword(password);
    }
    
    public Customer(int id, String name, String email, String password, int year, int month, int day)
    {
        this.id = id;
        this.name = name;
        this.joinDate = new GregorianCalendar(year,month-1,day);
        setEmail(email);
        setPassword(password);
    }
    
    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.joinDate = Calendar.getInstance();
        setEmail(email);
        setPassword(password);
    }

    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
        
    public String getEmail()
    {
        return email;
    }
        
    public String getPassword()
    {
        return password;
    }
        
    public Calendar getJoinDate()
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
        String pattern =    "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if (m.matches())
        {
            this.email = email;
        }
        else
        {
            this.email = "";
        }
    }
            
    public void setPassword(String password)
    {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if (m.matches())
        {
            this.password = password;
        }
        else
        {
            this.password = "";
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
    
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(getJoinDate().getTime());
        return "===Customer==="+
                "\nId: "+id+
                "\nNama: "+name+
                "\nEmail: "+email+
                "\nJoinDate :"+date+
                "\nPassword: "+password;

    }
}
