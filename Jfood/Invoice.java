public abstract class Invoice
{

    private int id;
    private Food food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoicestatus;

    public Invoice(int id, Food food, String date, Customer customer, InvoiceStatus invoicestatus)
    {
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.invoicestatus = invoicestatus;

    }
    
    public int getid()
    {
        return id;
    }
    
    public Food getFood()
    {
        return food;
    }
        
    public String getDate()
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
            
    public void setDate(String date)
    {
        this.date = date;
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
    
    public abstract void printData();
    
}
