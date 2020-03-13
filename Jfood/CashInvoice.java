public class CashInvoice extends Invoice
{

    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private Promo promo;
    private int deliveryFee = 0;

    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, date, customer, invoiceStatus);
    }
    
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, date, customer, invoiceStatus);
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
    
    public void printData()
    {
        System.out.println("===============INVOICE===============");
        System.out.println("ID             : "+super.getid());
        System.out.println("Makanan        : "+super.getFood().getName());
        System.out.println("Harga          : "+super.getFood().getPrice());
        System.out.println("Tanggal        : "+super.getDate());
        System.out.println("Customer       : "+super.getCustomer().getName());
        setTotalPrice();
        if (deliveryFee != 0)
        {
            System.out.println("Biaya antar    : "+deliveryFee);
        }
        System.out.println("Total          : "+totalPrice);
        System.out.println("Status         : "+super.getInvoiceStatus().toString());
        System.out.println("Pay Type       : "+PAYMENT_TYPE.toString());
    }

}
