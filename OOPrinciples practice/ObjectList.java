
/**
 * Write a description of class ObjectList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ObjectList
{
    protected Object[] object;
    protected int total = 0;
    
    public ObjectList(int size) {
        object = new Object[size];
    }
    
    public boolean add(Object newObject) {
        if (this.isFull()) {
            return false;
        }
        object[total] = newObject;
        total++;
        return true;
    }
    
    public boolean remove(int number) {
        if (number > object.length) {
            return false;
        }
        object[number] = null;
        total--;
        return object[number] == null;
    }
    
    public boolean isEmpty() {
        return total < object.length;
    }
    
    public boolean isFull() {
        return total == object.length;
    }
    
    public Object getObject(int index) {
        return object[index];
    }
    
    public int getTotal() {
        return total;
    }
}
