import java.util.Arrays;

/**
 * An LSArray is an array data structure that is specially
 * designed to work for the 'LSArrayApp.java' program.
 *
 * For simplicity; LSArray only stores String data items.
 *
 * @author Thomas Baloyi
 * @version 1
 * 28.02.2020
 */
public class LSArray {

    /* Size of the LSArray data structure. */
    private int size;
    
    /* Array for this LSArray. */
    private String[] array;
    
    /**
     * Keeps track of how many data items are in the index.
     * Used to add with the add method. This is not to be
     * confused with opCount.
     */
    private int count;
    
    /* Keeps count of the number of comparisons. */
    private int opCount;
    
    /* Constructor. */    
    public LSArray(int size) {
        this.size = size;
        array = new String[size];
        count = 0;
    }
    
    /* Returns the size of the array. */
    public int getSize() {
        return (this.size);
    }
    
    /* Returns the number of comparison operation. */
    public int getOpCount() {
        return (this.opCount);
    }

    /* Adds dataItem to this LSArray. */
    public void add(String dataItem) {
        array[count] = dataItem;
        count++;
    } 
    
    /**
     * Returns a string of data item that match with the parameter.
     * This method is specialised to handle constraints given by the
     * dataset provided by the LSArrayApp.
     *
     * @param 	dataItem the 'key'.
     * @returns match a string of areas that matches with key.
     * @see 	LSArrayApp
     */
    public String getDataItem(String dataItem) {
        String match = null;
        for (int i=0; i<size; i++) {
            opCount++;
            if (array[i].substring(0,7).trim().equals(dataItem)) {
                match = array[i].substring(7).trim();
                break;
            }
        }
        return match;
    }
    
    /**
     * Returns an array of all data items.
     */
    public String[] getAllDataItems() {
        String[] allDataItems = new String[size];
        opCount = 0;
        for (int i=0; i<size; i++) {
            allDataItems[i] = array[i].substring(7).trim();
        }
        return allDataItems;
    }
}