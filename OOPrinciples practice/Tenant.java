
/**
 * Write a description of class Tenant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tenant
{
    private final int maxNoOfPayments = 12;
    private String name;
    private int room;
    private PaymentList payments = new PaymentList(maxNoOfPayments);
    
    
    public Tenant(String name, int room) {
        this.name = name;
        this.room = room;
    }
    
    public String getName() {
        return name;
    }
    
    public int getRoom() {
        return room;
    }
    
    public void makePayment(Payment payment) {
        payments.add(payment);
    }
    
    public PaymentList getPayments() {
        return payments;
    }
    
    public String toString() {
        return "" + name + " is in room " + room;
    }
    
    public void print() {
        System.out.println(this.toString());
    }
    
}
