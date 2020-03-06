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
public class Trains {
// Note. You can assuming that trains approaching the track will 
// adhere to normal protocol.

    static final int NUM_OF_A_TRAINS = 10;
    static final int NUM_OF_B_TRAINS = 10;
    static TrainTrack theTrainTrack;

    public static void main(String[] args) {

        // create a train track
        theTrainTrack = new TrainTrack();

        System.out.println("STARTED");

        // create arrays to hold the trains 
        TrainA[] trainA = new TrainA[NUM_OF_A_TRAINS];
        TrainB[] trainB = new TrainB[NUM_OF_B_TRAINS];

        // create trains to enter the track
        for (int i = 0; i < NUM_OF_A_TRAINS; i++) {
            CDS.idleQuietly((int) (Math.random() * 500));
            trainA[i] = new TrainA("A" + i, theTrainTrack);
        }
        for (int i = 0; i < NUM_OF_B_TRAINS; i++) {
            CDS.idleQuietly((int) (Math.random() * 500));
            trainB[i] = new TrainB("B" + i, theTrainTrack);
        }

        // set the train processes running
        for (int i = 0; i < NUM_OF_A_TRAINS; i++) {
            trainA[i].start();
        } // end for 
        for (int i = 0; i < NUM_OF_B_TRAINS; i++) {
            trainB[i].start();
        } // end for 

	       // trains now travelling    
        //  wait for all the train threads to finish before printing out final message. 
        for (int i = 0; i < NUM_OF_A_TRAINS; i++) {
            try {
                trainA[i].join();
            } catch (InterruptedException ex) {
            }
        } // end for 

        for (int i = 0; i < NUM_OF_B_TRAINS; i++) {
            try {
                trainB[i].join();
            } catch (InterruptedException ex) {
            }
        } // end for    

        // Display all the train activity that took place
        theTrainTrack.theTrainActivity.printActivities();

        // Final message
        System.out.println("All trains have successfully travelled 1 circuits of their track loop ");
    } // end main     

} // end Trains class
