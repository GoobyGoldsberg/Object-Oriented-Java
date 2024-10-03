
/**
 * Write a description of class TenantList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TenantList extends ObjectList
{
    public TenantList(int size) {
        super(size);
    }
    
    public Tenant getTenant(int index) {
        return (Tenant)object[index];
        
    }
    // I'm assuming that the search method is supposed to search for
    // A tenant using the room number
    public Tenant search(int roomNum) {
        for (int i=0; i < object.length;i++) {
            if (((Tenant)object[i]).getRoom() == roomNum) {
                return ((Tenant)object[i]);
            }
        }
        return null;
    }
    
    public boolean removeTenant(int index) {
        return remove(index);
    }
}
