import java.util.*;
import java.text.SimpleDateFormat;

public class CashInvoice extends Invoice
{

    private static final PaymentType PAYMENT_TYPE = PaymentType.Cash;
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

    @Override
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
    
    @Override
    public void setTotalPrice() {
        super.totalPrice = 0;
        for (Food foods : getFoods()) {
            super.totalPrice += foods.getPrice();
        }
        if (deliveryFee != 0) {
            super.totalPrice += deliveryFee;
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

        return "============INVOICE CASH============"+
                "\nID :" + super.getId()+
                "\nFoods :"  + foods+
                "\nDate :" + date+
                "\nCustomer :" + super.getCustomer().getName()+
                "\nDelivery Fee :" + getDeliveryFee()+
                "\nTotal price :" + totalPrice+
                "\nStatus :" + super.getInvoiceStatus()+
                "\nPayment Type :" + getPaymentType();
    }

}
