import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

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
 * @see java.util.Arrays
 * @version 4 This program was rewritten four times - four times :(.
 * 28.02.2020
 */
 public class LSArrayApp {
     
    /** File containing loadshedding schedule. */
    private static File schedule;
    
    /** LSArray of all data items collected from 'schedule' file. */
    private static LSArray dataItems;
    
    /** The number of data items to be fed into LSarray. */
    private static int lsArraySize = 2976;
    
    /* Data item that matches with key */
    private static String areaAffected;
   
    private static boolean notFound;
    
    public static void main(String[] args) throws Exception {
        dataItems = new LSArray(lsArraySize);
        schedule = new File("../data/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner fileScan = new Scanner(schedule);
        
        // Add all data items into LSArray
        while (fileScan.hasNextLine()) {
            dataItems.add(fileScan.nextLine());
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
        if (notFound) {
            System.out.println("Areas not found");
        }
        
        printOpCount();
        
    }
    
    /**
     * Search for and print out list of areas affected by loadshedding given parameters.
     *
     * @param stage Loadshedding occurs in stages ranging from one to eight.
     * @param day a particular day during which loadshedding may occur.
     * @param startTime the time when loadshedding is expected to begin.
     */
     public static void printAreas(String stage, String day, String startTime) {
         String param = stage + "_" + day + "_" + startTime;
         areaAffected = dataItems.getDataItem(param);
         int i=0;
         if (areaAffected==null) {
             notFound = true;
         } 
         else {
             System.out.println(areaAffected);
         }
     }
     
     public static void printAreas(String key) {
         areaAffected = dataItems.getDataItem(key);
         if (areaAffected==null) {
             notFound = true;
         }
         else {
             System.out.println(areaAffected);
         }
     }
     
     /**
      * Prints out all areas affected by loadsheddinng.
      */
     public static void printAllAreas() {
         String[] allAreas = dataItems.getAllDataItems();
         for (int i=0; i<allAreas.length; i++) {
             System.out.println(allAreas[i]);
         }
     }
     
     /* Prints the number of comparison operations involving keys. */
     public static void printOpCount() {
         System.out.println("Number of comparison operations: " + dataItems.getOpCount());
     }
 }