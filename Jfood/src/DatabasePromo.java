import java.util.ArrayList;

public class DatabasePromo
{

    public static ArrayList<Promo> PROMO_DATABASE;
    public static int lastId = 0;


    public DatabasePromo() {
    }

    public ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    public int getLastId()
    {
        return lastId;
    }

    public Promo getPromoById(int id)
    {
        if (PROMO_DATABASE.get(id)!=null) {
            return PROMO_DATABASE.get(id);
        }
        else
        {
            return null;
        }
    }

    public ArrayList<Promo> getPromoByCode(String code)
    {
        ArrayList<Promo> list = new ArrayList<>();
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getCode() == code)
            {
                list.add(promo);
            }
        }
        return list;
    }

    public static boolean addPromo(Promo promo)
    {
        PROMO_DATABASE.add(lastId,promo);
        lastId++;
        return true;
    }

    public boolean activePromo(int id)
    {
        if (PROMO_DATABASE.get(id)!=null) {
            PROMO_DATABASE.get(id).setActive(true);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean deactivePromo(int id)
    {
        if (PROMO_DATABASE.get(id)!=null) {
            PROMO_DATABASE.get(id).setActive(false);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean removePromo (int id)
    {
        PROMO_DATABASE.remove(id);
        lastId--;
        return true;
    }
    
}
