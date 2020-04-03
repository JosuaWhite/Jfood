import java.util.*;

public class DatabaseInvoice {

    public static ArrayList<Invoice> INVOICE_DATABASE;
    public static int lastId = 0;


    public DatabaseInvoice() {
    }

    public ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    public int getLastId()
    {
        return lastId;
    }

    public Invoice getInvoiceById(int id)
    {
        if (INVOICE_DATABASE.get(id)!=null) {
            return INVOICE_DATABASE.get(id);
        }
        else
        {
            return null;
        }
    }

    public ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> list = new ArrayList<>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == customerId)
            {
                list.add(invoice);
            }
        }
        return list;
    }

    public boolean addInvoice(Invoice invoice)
    {
        if (!invoice.getInvoiceStatus().toString().equals("Ongoing")) {
            INVOICE_DATABASE.add(lastId, invoice);
            lastId++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        boolean found = false;
        for (Invoice invoice : INVOICE_DATABASE) {
            if(invoice.getId() == id && invoice.getInvoiceStatus().toString().equals("Ongoing")){
                if (INVOICE_DATABASE.get(id) != null) {
                    INVOICE_DATABASE.get(id).setInvoiceStatus(invoiceStatus);
                    found = true;
                }
            }
        }
        return found;
    }

    public boolean removeInvoice (int id)
    {
        int index = 0;
        boolean found = false;
        for (Invoice invoice : INVOICE_DATABASE){
            if(invoice.getId()==id)
            {
                INVOICE_DATABASE.remove(index);
                lastId--;
                found = true;
                return found;
            }
            index++;
        }
        return found;
    }

}
