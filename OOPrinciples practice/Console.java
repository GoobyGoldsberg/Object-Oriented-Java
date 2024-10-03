
/**
 * Write a description of class Console here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Console
{   
    private static TenantList tenantList = new TenantList(10);
    private static PaymentList paymentList = new PaymentList(12);
    
    // This method display's the user menu, takes in the user input and returns it as char
    public static char displayMenu() {
            System.out.println();
            System.out.println("=================================");
            System.out.println("1. Add a Tenant");
            System.out.println("2. List all Tenants");
            System.out.println("3. Add a payment");
            System.out.println("4. List all payments");
            System.out.println("5. Remove a Tenant");
            System.out.println("6. Get number of payments made(Per Tenant)");
            System.out.println("7. Get total payments made(Per Tenant)");
            System.out.println("8. Get total payments made for the entire hostel");
            System.out.println("9. Quit");
            System.out.println("==================================");
            
            System.out.println("Please enter your choice: ");
            
            Scanner scanner = new Scanner(System.in);
            char choice = scanner.next().charAt(0);
            return choice;
    }
        
        
     
    
    // This method allows the user to create a new tenant by inputting the name and room number of the new tenant
    public static void option1() {
        System.out.println("Adding a new tenant to the hostel.");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter new tenant's name: ");
        String newTenantName = scanner.nextLine();
        System.out.println("Please enter new tenant's room: ");
        int newTenantRoom = scanner.nextInt();
                
        Tenant newTenant = new Tenant(newTenantName, newTenantRoom);
        tenantList.add(newTenant);
        System.out.println("==================================");
    }
    
    // This method prints out the list of all tenants starting the list with '1.' as opposed to '0.'
    
    // Important Note: +1 and -1 in the loops are to compensate for the fact that the user does not enter '0' but '1' as the lowest index
    // therefore we need to decrement index by 1 to correctly iterate over the paymentList and tenantList
    // also to make the list more pleasant by making it start the first entry with '1.' instead of '0.'
    //  ^ this is used in Options: 2, 4, 5, 6, 7
    public static void option2() {
        System.out.println();
        System.out.println("Listing all the tenants in the hostel");
        for (int i=1; i < tenantList.total+1;i++) {
            if (tenantList.getTenant(i-1) == null) {
                if (tenantList.getTenant(i) == null) {
                    break;
                }
                System.out.println(i + ". " + tenantList.getTenant(i).toString());
                continue;
            }
            System.out.println(i + ". " + tenantList.getTenant(i-1).toString());
        }
        System.out.println("==================================");
    }
    
    // This method allows the user to add a new payment to the tenant by asking for the month and amount, if there are no tenants on the list, it returns to the menu
    public static void option3() {
        System.out.println();
        System.out.println("Adding a new payment.");

        if (tenantList.getTotal() == 0) {
            System.out.println("There are no tenants!");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        
        option2();
        System.out.println("Please enter the tenant's index which to add payment to: ");
        int tenIndex = scanner.nextInt();
        // Decrementing the index because the user does not enter '0' as an index because the list starts with '1'
        tenIndex--;
        
        System.out.println("Please enter new payment's month: ");
        String newPaymentMonth = scanner.next();
        System.out.println("Please enter new payment's amount: ");
        double newPaymentAmount = scanner.nextInt();
                        
        Payment newPayment = new Payment(newPaymentMonth, newPaymentAmount);
                
        tenantList.getTenant(tenIndex).makePayment(newPayment);
        System.out.println("=================================");

    }
    
    // This method lists all the payments made in the hostel
    
    public static void option4() {
        System.out.println();
        System.out.println("Printing all the payments made in the hostel.");
        for (int i=1; i < tenantList.total+1;i++) {
            for (int j=1; j < tenantList.getTenant(i-1).getPayments().total+1; j++) {
                System.out.println("Payment: €" + tenantList.getTenant(i-1).getPayments().getPayment(j-1).getAmount());
            }
        }
        System.out.println("=================================");

    }
    
    
    // This method shows the user a list of tenants and requires the user to enter the index corresponding 
    // to the tenant that he wishes to remove from the list
    public static void option5() {
        System.out.println();
        System.out.println("Removing a tenant from the hostel.");
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        
        option2();
        System.out.println("Please enter the tenant's index that you want to remove: ");
        input = scanner.nextInt();
        
        tenantList.removeTenant(input-1);
        System.out.println("=================================");
    }
    
    // This method prints out all the tenants in the hostel and the tenants' payments
    
    public static void option6() {
        System.out.println();
        System.out.println("Printing all the tenants in the hostel and all their payments made.");
        for (int i=1; i < tenantList.total+1;i++) {
            System.out.println(i + ". " + tenantList.getTenant(i-1).toString());
            for (int j=1; j < tenantList.getTenant(i-1).getPayments().total+1; j++) {
                System.out.println("Payment " + j + "." + ": €" + tenantList.getTenant(i-1).getPayments().getPayment(j-1).getAmount());
            }
        }
        System.out.println("=================================");
    }
    
    // This method prints all the tenants in the hostel to the user and requests the index of the tenant
    // for which the user wishes to see the total amount paid from all the payments
    public static void option7() {
        System.out.println();
        System.out.println("Printing the total amount paid from one chosen tenant in the hostel.");
        Scanner scanner = new Scanner(System.in);
        option2();
        System.out.println("Please enter the tenant's index of which to get the total payments made: ");
        int index = scanner.nextInt();
        index--;
            
        System.out.println("Total Paid for tenant: " + tenantList.getTenant(index).getName() + " = €" + 
                                    tenantList.getTenant(index).getPayments().calculateTotalPaid());
        
        System.out.println("=================================");
    }
    
    // This method prints out the total amount paid by all the tenants in the hostel altogether
    public static void option8() {
        System.out.println();
        System.out.println("Printing the total amount paid by all the tenants in the hostel altogether.");
        double totalPaid = 0;
        
        for (int i=0; i < tenantList.total; i++) {
            totalPaid += tenantList.getTenant(i).getPayments().calculateTotalPaid();
        }
        
        System.out.println("Total amount of Payments made for the entire hostel: €" + totalPaid);
        System.out.println("=================================");
    }
}
