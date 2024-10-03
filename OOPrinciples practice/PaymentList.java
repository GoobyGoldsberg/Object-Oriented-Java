
/**
 * Write a description of class PaymentList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PaymentList extends ObjectList
{   
    public PaymentList(int size) {
        super(size);
    }
    
    public Payment getPayment(int index) {
        return (Payment)object[index];
    }
    
    public double calculateTotalPaid() {
        double totalPaid = 0;
        
        for (int i=0; i < getTotal();i++) {
            totalPaid += this.getPayment(i).getAmount();
        }
        return totalPaid;
    }
}
