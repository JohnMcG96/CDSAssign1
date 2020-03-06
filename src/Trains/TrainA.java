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
public class TrainA extends Thread {
    // Note This process is used to emulate a train as it proceeds around the track

    String trainName;
    TrainTrack theTrack;
    //initialise (constructor)   
    public TrainA(String trainName, TrainTrack theTrack) {
        this.trainName = trainName;
        this.theTrack = theTrack;
    }

    @Override
    public void run() {   // start train Process
        // wait for clearance before moving on to the track
        theTrack.trainA_MoveOnToTrack(trainName); // move on to track A
        int circuitCount = 0;
        while (circuitCount < 1) { // keep cycling the A track loop 
            theTrack.trainA_MoveAroundToSharedTrackPart1(trainName);
            theTrack.trainA_MoveAlongSharedTrackPart1(trainName);
            theTrack.trainA_MoveAroundToSharedTrackPart2(trainName);
            theTrack.trainA_MoveAlongSharedTrackPart2(trainName);
            theTrack.trainA_MoveAroundToSharedTrackPart3(trainName);
            circuitCount++;
        }
        theTrack.trainA_MoveOffTrack(trainName); // move off the track */
    } // end run  

} // end trainAProcess
