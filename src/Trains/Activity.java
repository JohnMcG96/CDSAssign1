/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trains;

/**
 *
 * @author John
 */
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

// - Represents the train track activity in a thread-safe CopyOnWriteArrayList<String>
// - called theActivities
// - addMovementTo(<Integer>) adds a train movement (destination) activity to the record
// - addMessage(<String>) adds a message to the record 
// - printActivities() display all the activity history of the train movement
// - trackString() takes a snapshot of the traintrack (with trains) for printing
public class Activity {

    private final CopyOnWriteArrayList<String> theActivities;

    private final String[] trainTrack;

    // Constructor for objects of class Activity
    // A reference to the track is passed as a parameter
    public Activity(String[] trainTrack) {
        theActivities = new CopyOnWriteArrayList<>();
        this.trainTrack = trainTrack;
    }

    public void addMovedTo(int section) {
        // add an activity message to the activity history
        String tempString1 = "Train " + trainTrack[section] + " moving/moved to [" + section + "]";
        theActivities.add(tempString1);
        // add the current state of the track to the activity history
        theActivities.add(trackString());
    }// end addMovedTo  
    
    public void addMovedOff(String trainName) {
        // add an activity message to the activity history
        String tempString1 = "Train " + trainName + " has left the track";
        theActivities.add(tempString1);
        // add the current state of the track to the activity history
        theActivities.add(trackString());
    }// end addMovedTo  

    public void addMessage(String message) {
        // add an activity message to the activity history
        String tempString1 = message;
        theActivities.add(tempString1);
    }// end addMessage  

    public void printActivities() {
        // print all the train activity history	
        System.out.println("TRAIN TRACK ACTIVITY(Tracks [0..18])");
        Iterator<String> iterator = theActivities.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }// end printActivities

    // Utility method to represent the track as a string for printing/display
    public String trackString() {
        String trackStateAsString = "           " + trainTrack[5] + "\n"
                + "        " + trainTrack[4] + "  " + trainTrack[6] + "\n"
                + "      " + trainTrack[3] + "      " + trainTrack[7] + "\n"
                + "      " + trainTrack[2] + "      " + trainTrack[8] + "\n"
                + "        " + trainTrack[1] + "  " + trainTrack[9] + "\n"
                + "           " + trainTrack[0] + "\n"
                + "        " + trainTrack[10] + "  " + trainTrack[18] + "\n"
                + "      " + trainTrack[11] + "      " + trainTrack[17] + "\n"
                + "      " + trainTrack[12] + "      " + trainTrack[16] + "\n"
                + "        " + trainTrack[13] + "  " + trainTrack[15] + "\n"
                + "           " + trainTrack[14] + "\n";
        return trackStateAsString;
    }// end trackString

} // end Activity
