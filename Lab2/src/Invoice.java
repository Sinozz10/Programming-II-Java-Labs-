import java.util.*;

public class Invoice {
    //Attributes
    private int invoiceNumber;
    private String customerName;
    private double[] prices;

    //Getters and Setters
    public int getInvoiceNumber() {
        return invoiceNumber;
    }
    public void setInvoiceNumber(int invoiceNumber) {this.invoiceNumber = invoiceNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {this.customerName = customerName;
    }
    public double[] getPrices() { return prices;
    }
    public void setPrices(double[] prices) {
        this.prices = prices;
    }

    @Override
    public String toString()  {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", customerName='" + customerName + '\'' +
                ", prices=" + Arrays.toString(prices) +
                '}';
    }

    //Constructor
    public Invoice(int invoiceNumber, String customerName, double[] prices){
        this.invoiceNumber=invoiceNumber;
        this.customerName=customerName;
        this.prices=prices;
    }

    //Methods ->report(void) & ->CalculateInvoice(double)
    public void report(){
        System.out.println("Account number: "+ this.invoiceNumber);
        System.out.println("Name: "+this.customerName);
        double total=0 ;
        for (int i = 0; i < prices.length; i++) {
            total+=prices[i];
        }
        double discounted=calculateInvoice();
        System.out.println("Total Cost: " + total);
        System.out.println("The total cost after discount %: " + discounted);
    }
    public double calculateInvoice(){
        double totalCost=0;
        for (int i = 0; i < prices.length; i++) {
            totalCost+=prices[i];
        }
        double discount=0;
        if (totalCost >= 10000) {
            discount = 8;
        } else if (totalCost >= 8000) {
            discount = 6;
        } else if (totalCost >= 5000) {
            discount = 4;
        } else if (totalCost >= 1000) {
            discount = 1;
        }
        double discountAmount = totalCost * (discount/100);
        return totalCost - discountAmount;
    }

}
