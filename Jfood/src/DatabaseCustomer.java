import java.util.*;

public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE;
    private static int lastId = 0;

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }

    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        for(Customer customer : CUSTOMER_DATABASE) {
            if(customer.getId() == id) {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException
    {
        for (Customer _customer : CUSTOMER_DATABASE) {
            if(_customer.getEmail().equals(customer.getEmail())) {
                throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for(Customer customer : CUSTOMER_DATABASE) {
            if(customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }
    
}
