package client;

import java.awt.EventQueue;

/**
 * <pre> GUI Test for Further Programming assignment 2, 2019
 * <b>NOTE:</b> This code will not compile until you have implemented code for the supplied interfaces!
 * 
 * You must be able to compile your code WITHOUT modifying this class.
 * Additional testing should be done by copying and adding to this class while ensuring this class still works.
 * 
 * The provided Validator.jar will check if your code adheres to the specified interfaces!</pre>
 * 
 * @author Caspar Ryan
 * 
 */
public class GUITest
{
   public static void main(String args[])
   {
	   EventQueue.invokeLater(new Runnable()
	   {
	       public void run()
	       {
	    	   new MainPanel(); 
	       }
	   });
	   
   }
}
