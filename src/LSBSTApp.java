import java.io.File;
import java.util.Scanner;

/**
 * Loadshedding is the systematic shutdown of power to households
 * and organisations by Eskom. It occurs at different stages, times,
 * and days for different areas.
 * 
 * This program provides an interactive way of accessing the loadshedding
 * schedule. The user will key in the stage, time, and day; the program
 * will then output a list of areas affected given the input. If one or more of
 * the three parameters are not entered, the program will print out the entire
 * schedule. 
 * 
 * @author Thomas Baloyi
 * @version 1
 * 01.03.2020
 */
public class LSBSTApp {
    
    /** File containing loadshedding schedule. */
    private static File schedule;
    
    /** Binary Search Tree of all data items collected from 'schedule' file. */
    private static BinarySearchTree tree;
    
    public static void main(String[] args) throws Exception {
        tree = new BinarySearchTree();
        schedule = new File("../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner fileScan = new Scanner(schedule);
        
        // Add all data items into BST
        while (fileScan.hasNextLine()) {
            tree.insert(fileScan.nextLine());
        }
        fileScan.close();
        
        if (args.length==3) {
            printAreas(args[0], args[1], args[2]);
        }
        else if (args.length==0) {
            printAllAreas();
        }
        else if (args.length==1) {
            printAreas(args[0]);
        }
        
       System.out.println("The number of comparison operations for find is: " + tree.getFindOpCount());
       System.out.println("The number of comparison operations for insert is: " + tree.getInsertOpCount());        
    }
    
    /**
     * Search for and print out list of areas affected by loadshedding given parameters.
     *
     * @param stage Loadshedding occurs from stages ranging from one to eight.
     * @param day a particular day during which loadshedding may occur.
     * @param startTime the time when loadshedding is expected to begin.
     */
    public static void printAreas(String stage, String day, String startTime) {
        String param = stage + "_" + day + "_" + startTime;
        tree.printNodeData(param);        
    }
    
    public static void printAreas(String key) {
        tree.printNodeData(key);
    }
    
    /** Prints out all areas affected by loadshedding. */
    public static void printAllAreas() {
       tree.printInOrder();
    }     
}