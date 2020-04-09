import java.util.ArrayList;

public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE;
    private static int lastId = 0;

    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }

    public static Promo getPromoById(int id) throws PromoNotFoundException
    {
        for(Promo promo : PROMO_DATABASE) {
            if(promo.getId() == id) {
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }

    public static Promo getPromoByCode(String code)
    {
        for(Promo promo : PROMO_DATABASE) {
            if(promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistsException
    {
        for (Promo _promo : PROMO_DATABASE) {
            if (_promo.getCode().equals(promo.getCode())){
                throw new PromoCodeAlreadyExistsException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }

    public static boolean activePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE) {
            if(promo.getId() == id) {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivePromo(int id)
    {
        for(Promo promo : PROMO_DATABASE) {
            if(promo.getId() == id) {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }

    public static boolean removePromo (int id) throws PromoNotFoundException
    {
        for(Promo promo : PROMO_DATABASE) {
        if(promo.getId() == id) {
            PROMO_DATABASE.remove(promo);
            return true;
        }
    }
        throw new PromoNotFoundException(id);
    }
    
}
