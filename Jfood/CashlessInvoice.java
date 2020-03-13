public class CashlessInvoice extends Invoice
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
        if (promo != null && super.getFood().getPrice() >= promo.getMinPrice() && promo.getActive() == true)
        {
            super.totalPrice = super.getFood().getPrice() - promo.getDiscount();
        }
        else
        {
            super.totalPrice = super.getFood().getPrice();
        }
    }
    
    public void printData()
    {
        System.out.println("===============INVOICE===============");
        System.out.println("ID       : "+super.getid());
        System.out.println("Makanan  : "+super.getFood().getName());
        System.out.println("Harga    : "+super.getFood().getPrice());
        System.out.println("Tanggal  : "+super.getDate());
        System.out.println("Customer : "+super.getCustomer().getName());
        setTotalPrice();
        if (promo != null)
        {
            System.out.println("Promo    : "+promo.getCode());
            System.out.println("Active   : "+promo.getActive());
            if (promo.getActive()==true)
            {
                if (super.getFood().getPrice() >= promo.getMinPrice())
                {
                    System.out.println("Discount : "+promo.getDiscount());
                }
                else
                {
                    System.out.println("Discount : Belum mencapai harga minimum");
                }
            }
        }
        System.out.println("Total    : "+totalPrice);
        System.out.println("Status   : "+super.getInvoiceStatus().toString());
        System.out.println("Pay Type : "+PAYMENT_TYPE.toString());
    }

}
