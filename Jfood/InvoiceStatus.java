public enum InvoiceStatus
{
    Ongoing("Ongoing"),Finished("Finished"),Cancelled("Cancelled");
    
    private String invoiceStatus;
    
    InvoiceStatus(String invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }

    public String toString()
    {
        return invoiceStatus;
    }
}

