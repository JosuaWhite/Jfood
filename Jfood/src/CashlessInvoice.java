import java.util.*;
import java.text.SimpleDateFormat;

public class CashlessInvoice extends Invoice
{

    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods,customer);
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


    public void setTotalPrice() {
        super.totalPrice = 0;
        for (Food foods : getFoods()) {
            super.totalPrice = foods.getPrice();
        }

        if (promo != null && super.totalPrice >= promo.getMinPrice() && promo.getActive() == true) {
            super.totalPrice -= promo.getDiscount();
        }

    }

    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(getDate().getTime());
        StringBuilder sss = new StringBuilder();

        setTotalPrice();
        if (promo != null && super.totalPrice >= promo.getMinPrice() && promo.getActive() == true)
        {
            sss.append("===============INVOICE===============\n" + "ID             : ").append(super.getid()).append("\n").append("Makanan        : \n");

            for (Food foods : getFoods()) {
                sss.append(foods.getName()).append(" ").append(foods.getPrice()).append("\n");
            }
            sss.append("Tanggal        : ").append(date).append("\n").append("Customer       : ").append(super.getCustomer().getName()).append("\n").append("Promo code     : ").append(promo.getCode()).append("\n").append("Diskon         : ").append(promo.getDiscount()).append("\n").append("Total          : ").append(totalPrice).append("\n").append("Status         : ").append(super.getInvoiceStatus().toString()).append("\n").append("Pay Type       : ").append(PAYMENT_TYPE.toString()).append("\n");
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
