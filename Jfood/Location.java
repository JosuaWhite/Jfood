
public class Location
{

    public String province;
    public String description;
    public String city;


    public Location(String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;

    }
    
    public String getProvince()
    {
        return province;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setProvince()
    {
        this.province = province;
    }
    
    public void setCity()
    {
        this.city = city;
    }
    
    public void setDescription()
    {
        this.description = description;
    }
    
    public void printData()
    {
        System.out.println("Provinsi : "+province);
    }
}
