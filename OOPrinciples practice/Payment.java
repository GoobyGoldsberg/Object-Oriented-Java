
/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment
{
    private String month;
    private double amount;
    
    public Payment(String month, double amount) {
        this.month = month;
        this.amount = amount;
    }
    
    public String getMonth() {
        return month;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String toString() {
        return "Month: " + month + "\n Amount:" + amount;
    }
    
    public void print() {
        System.out.println(this.toString());
    }
    
}