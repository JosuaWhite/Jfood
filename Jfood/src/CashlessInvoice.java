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

    @Override
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
            super.totalPrice += foods.getPrice();
        }

        if (promo != null && super.totalPrice >= promo.getMinPrice() && promo.getActive()) {
            super.totalPrice -= promo.getDiscount();
        }

    }

    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String date = sdf.format(super.getDate().getTime());
        String foods = "";
        for(Food foodList : getFoods())
        {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);

        if(promo != null && promo.getActive()) {
            return "============INVOICE CASHLESS============"+
                    "\nID :" + super.getId()+
                    "\nFoods :"  + foods+
                    "\nDate :" + date+
                    "\nCustomer :" + super.getCustomer().getName()+
                    "\nPromo Code:" + promo.getCode()+
                    "\nTotal price :" + totalPrice+
                    "\nStatus :" + super.getInvoiceStatus()+
                    "\nPayment Type :" + getPaymentType();
        }else {
            return "============INVOICE CASHLESS============"+
                    "\nID :" + super.getId()+
                    "\nFoods :"  + foods+
                    "\nDate :" + date+
                    "\nCustomer :" + super.getCustomer().getName()+
                    "\nTotal price :" + totalPrice+
                    "\nStatus :" + super.getInvoiceStatus()+
                    "\nPayment Type :" + getPaymentType();
        }

    }


}
