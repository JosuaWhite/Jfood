import java.util.*;
import java.text.SimpleDateFormat;

public class CashInvoice extends Invoice
{

    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private Promo promo;
    private int deliveryFee = 0;

    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
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
    

    public void setTotalPrice() {
        super.totalPrice = 0;
        for (Food foods : getFoods()) {
            super.totalPrice = foods.getPrice();
        }

        if (deliveryFee != 0) {
            super.totalPrice += deliveryFee;
        }

    }
    
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(getDate().getTime());
        StringBuilder sss = new StringBuilder();

        setTotalPrice();
        if (deliveryFee!=0)
        {
            sss.append("===============INVOICE===============\n" + "ID             : ").append(super.getid()).append("\n").append("Makanan        : \n");

            for (Food foods : getFoods()) {
                sss.append(foods.getName()).append(" ").append(foods.getPrice()).append("\n");
            }
            sss.append("Tanggal        : ").append(date).append("\n").append("Customer       : ").append(super.getCustomer().getName()).append("\n").append("Biaya antar    : ").append(deliveryFee).append("\n").append("Total          : ").append(totalPrice).append("\n").append("Status         : ").append(super.getInvoiceStatus().toString()).append("\n").append("Pay Type       : ").append(PAYMENT_TYPE.toString()).append("\n");
            return sss.toString();
    }
    else
    {
        sss.append("===============INVOICE===============\n" + "ID             : ").append(super.getid()).append("\n").append("Makanan        : \n");

        for (Food foods : getFoods()) {
            sss.append(foods.getName()).append(" ").append(foods.getPrice()).append("\n");
        }
        sss.append("Tanggal        : ").append(date).append("\n").append("Customer       : ").append(super.getCustomer().getName()).append("\n").append("Total          : ").append(totalPrice).append("\n").append("Status         : ").append(super.getInvoiceStatus().toString()).append("\n").append("Pay Type       : ").append(PAYMENT_TYPE.toString()).append("\n");
        return sss.toString();
    }
    }

}
