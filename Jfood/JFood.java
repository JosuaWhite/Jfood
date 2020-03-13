public class JFood
{
    public static void main(String[] args)
    {
        Location Loca1 = new Location("Medan","Sumut","Tempatlahir");
        
        Seller Sell1 = new Seller(2850,"Joshua","Josua.white2@gmail.com","081329598039",Loca1);
        
        Food Food1 = new Food(101,"Nasgor",Sell1,17000,FoodCategory.Rice);
        Food Food2 = new Food(104,"Sushi",Sell1,28000,FoodCategory.Japanese);
        
        
        Customer Cust1 = new Customer(2851,"Budi","Budimail@gmail.com","Budi123","20200402");
        Customer Cust2 = new Customer(1234,"Jorgi","Jorgihandsome@gmail.com","jorgi122","20200610");
        
        Promo Prom1 = new Promo(107,"Berkah2020",3000,10000,true);
        
        CashlessInvoice Cashiv1 = new CashlessInvoice(103,Food1,"6 Maret 2020",Cust1,InvoiceStatus.Finished,Prom1);
        
        
        CashInvoice Cashiv2 = new CashInvoice(103,Food1,"6 Maret 2020",Cust1,InvoiceStatus.Finished);
        CashInvoice Cashiv3 = new CashInvoice(103,Food2,"10 Feb 2020",Cust2,InvoiceStatus.Finished,5000);
        
        
        Cashiv2.printData();
        Cashiv3.printData();
    }
    
    
}
