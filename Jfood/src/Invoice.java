import java.util.*;
import java.text.SimpleDateFormat;

public abstract class Invoice
{

    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoicestatus;

    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {   
        this.id = id;
        this.foods = foods;
        this.customer = customer;
        this.date = Calendar.getInstance();
        

    }
    
    public int getId()
    {
        return id;
    }
    
    public ArrayList<Food> getFoods()
    {
        return foods;
    }
        
    public Calendar getDate()
    {
        return date;
    }
        
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public abstract PaymentType getPaymentType();
    
    public InvoiceStatus getInvoiceStatus()
    {
        return invoicestatus;
    }
        
    public void setId(int id)
    {
        this.id = id;
    }
            
    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }
            
    public Calendar setDate(Calendar date)
    {
        return date;
    }
    
    public Calendar setDate(int year, int month, int day)
    {
        date = new GregorianCalendar(year,month,day);
        return date;
    }
            
    public abstract void setTotalPrice();
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public void setInvoiceStatus(InvoiceStatus invoicestatus)
    {
        this.invoicestatus = invoicestatus;
    }
    
    public abstract String toString();
    
}
