import java.util.*;
import java.text.SimpleDateFormat;

public class CashInvoice extends Invoice
{

    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private Promo promo;
    private int deliveryFee = 0;

    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }
    
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    public void setTotalPrice()
    {
        if (deliveryFee != 0)
        {
            super.totalPrice = super.getFood().getPrice() + deliveryFee;
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
        if (deliveryFee!=0)
        {
        return(
        "===============INVOICE===============\n"+
        "ID             : "+super.getid()+"\n"+
        "Makanan        : "+super.getFood().getName()+"\n"+
        "Harga          : "+super.getFood().getPrice()+"\n"+
        "Tanggal        : "+date+"\n"+
        "Customer       : "+super.getCustomer().getName()+"\n"+
        "Biaya antar    : "+deliveryFee+"\n"+
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
