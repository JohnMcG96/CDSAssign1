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
import java.util.concurrent.*;

//MageeSemaphore.java
//This is an implementation of the traditional (counting) Semaphore with P() and V() operations
class MageeSemaphore 
{
   private Semaphore sem;
	
   public MageeSemaphore (int initialCount) 
   {
	sem = new Semaphore(initialCount);
   } // end constructor
	
   public void P() 
   {
	try {
	    sem.acquire();
	} catch (InterruptedException ex) {System.out.println("Interrupted when waiting");}
   } // end P()
	
   public void V() 
   {
	sem.release();
   } // end V()
	
} // end MageeSemaphore

