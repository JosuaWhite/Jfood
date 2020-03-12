public class JFood
{
    public static void main(String[] args)
    {
        Location Loca1 = new Location("Medan","Sumut","Tempatlahir");
        Seller Sell1 = new Seller(2850,"Joshua","Josua.white2@gmail.com","081329598039",Loca1);
        Food Food1 = new Food(101,"Nasgor",Sell1,12000,FoodCategory.Rice);
        Customer Cust1 = new Customer(2851,"Budi","Budimail@gmail.com","Budi123","20200402");

    }
    
    
}
