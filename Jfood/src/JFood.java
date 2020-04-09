public class JFood
{
    public static void main(String[] args)
    {
        try {
            DatabasePromo.addPromo(new Promo(DatabaseCustomer.getLastId() + 1, "HaleluyaFood", 10000, 50000, true));
            DatabasePromo.addPromo(new Promo(DatabaseCustomer.getLastId() + 1, "HaleluyaFood", 20000, 80000, true));
        }catch (PromoCodeAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
        }

        // Exception in thread "main" java.lang.NullPointerException
        //Tidak bisa try dan catch exception
    }
    
    
}
