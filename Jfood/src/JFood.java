public class JFood
{
    public static void main(String[] args)
    {
        Promo prom1 = new Promo(1,"RumahAja", 10000, 50000,true);
        Promo prom2 = new Promo(2,"RumahAja", 20000, 100000,true);
        DatabasePromo.addPromo(prom1);
        DatabasePromo.addPromo(prom2);
        for (Promo promo : DatabasePromo)
        {
            System.out.println(promo.toString());
        }




        
    }
    
    
}
