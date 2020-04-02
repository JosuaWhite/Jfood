import java.util.*;

public class DatabaseCustomer
{
    public ArrayList<Customer> CUSTOMER_DATABASE;
    public int lastId = 0;


    public DatabaseCustomer() {
    }

    public ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public int getLastId()
    {
        return lastId;
    }

    public Customer getCustomerById(int id)
    {
        if (CUSTOMER_DATABASE.get(id)!=null) {
            return CUSTOMER_DATABASE.get(id);
        }
        else
        {
            return null;
        }
    }

    public boolean addCustomer(Customer customer)
    {
        CUSTOMER_DATABASE.add(lastId,customer);
        lastId++;
        return true;
    }

    public boolean removeCustomer(int id)
    {
        CUSTOMER_DATABASE.remove(id);
        lastId--;
        return true;
    }
    
}
