import java.util.*;

public class DatabaseSeller
{
    public ArrayList<Seller> SELLER_DATABASE;
    public int lastId = 0;


    public DatabaseSeller() {
    }

    public ArrayList<Seller> getSellerDatabase()
    {
        return SELLER_DATABASE;
    }

    public int getLastId()
    {
        return lastId;
    }

    public Seller getSellerById(int id)
    {
        if (SELLER_DATABASE.get(id)!=null) {
            return SELLER_DATABASE.get(id);
        }
        else
        {
            return null;
        }
    }

    public boolean addSeller(Seller seller)
    {
        SELLER_DATABASE.add(lastId,seller);
        lastId++;
        return true;
    }

    public boolean removeSeller(int id)
    {
        SELLER_DATABASE.remove(id);
        lastId--;
        return true;
    }

}
