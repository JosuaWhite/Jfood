public class Customer
{
    private int id;
    private String name;
    private String email;
    private String password;
    private String joinDate;
    

    public Customer(int id, String name, String email, String password, String joindDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        
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
        return email;
    }
        
    public String getPassword()
    {
        return password;
    }
        
    public String JoinDate()
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
        this.email = email;
    }
            
    public void setPassword(String password)
    {
        this.password = password;
    }
        
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    public void printData()
    {
        System.out.println("Nama pembeli : "+name);
    }
}
