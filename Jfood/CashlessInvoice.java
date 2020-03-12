
public abstract class CashlessInvoice extends Invoice
{

    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, date, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food, date, customer, invoiceStatus);
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
        if (promo != null && getFood().getPrice() >= promo.getMinPrice() && promo.getActive() == true)
        {
            super.totalPrice = getFood().getPrice() - promo.getDiscount();
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    
    public void printData()
    {

    }

}
