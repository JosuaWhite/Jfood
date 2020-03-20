import java.util.*;
import java.text.SimpleDateFormat;

public abstract class Invoice
{

    private int id;
    private Food food;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoicestatus;

    public Invoice(int id, Food food, Customer customer, InvoiceStatus invoicestatus)
    {   
        this.id = id;
        this.food = food;
        this.customer = customer;
        this.invoicestatus = invoicestatus;
        this.date = Calendar.getInstance();
        

    }
    
    public int getid()
    {
        return id;
    }
    
    public Food getFood()
    {
        return food;
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
            
    public void setFood(Food food)
    {
        this.food = food;
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
