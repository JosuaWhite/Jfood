import java.util.*;
import java.text.SimpleDateFormat;

public class CashlessInvoice extends Invoice
{

    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food,customer, invoiceStatus);
        this.promo = promo;
    }
    
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo()
    {
        return promo;
    }
    
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }
    
    public void setTotalPrice()
    {
        if (promo != null && super.getFood().getPrice() >= promo.getMinPrice() && promo.getActive() == true)
        {
            super.totalPrice = super.getFood().getPrice() - promo.getDiscount();
        }
        else
        {
            super.totalPrice = super.getFood().getPrice();
        }
    }
    
    
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(getDate().getTime());
        
        setTotalPrice();
        if (promo!=null&&getPromo().getActive()==true&&super.getFood().getPrice() >= promo.getMinPrice())
        {
        return(
        "===============INVOICE===============\n"+
        "ID             : "+super.getid()+"\n"+
        "Makanan        : "+super.getFood().getName()+"\n"+
        "Harga          : "+super.getFood().getPrice()+"\n"+
        "Tanggal        : "+date+"\n"+
        "Customer       : "+super.getCustomer().getName()+"\n"+
        "Promo          : "+promo.getCode()+"\n"+
        "Total          : "+totalPrice+"\n"+
        "Status         : "+super.getInvoiceStatus().toString()+"\n"+
        "Pay Type       : "+PAYMENT_TYPE.toString()+"\n"
        );
    }
    else
    {
        return(
        "===============INVOICE===============\n"+
        "ID             : "+super.getid()+"\n"+
        "Makanan        : "+super.getFood().getName()+"\n"+
        "Harga          : "+super.getFood().getPrice()+"\n"+
        "Tanggal        : "+date+"\n"+
        "Customer       : "+super.getCustomer().getName()+"\n"+
        "Total          : "+totalPrice+"\n"+
        "Status         : "+super.getInvoiceStatus().toString()+"\n"+
        "Pay Type       : "+PAYMENT_TYPE.toString()+"\n"
        );
    }
    }

}
