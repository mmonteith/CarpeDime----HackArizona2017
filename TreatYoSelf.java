import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* TREAT YO'SELF
 * 
 * Authors: Michelle Monteith
 * 			Victor Gomes
 * 			Griffin Stiller
 * 			Amanda Chesin
 * 
 * 
 * 
 * 
 * 
 */


public class TreatYoSelf {
	
	private User user;
	private static Scanner inFile;
	
	public static void main(String[] args){
		
			String fileName = "UserData.txt";
			FileWriter writer = null;
			
			try{
				writer = new FileWriter(fileName);
			} catch(IOException ioex){
				System.out.println("Unable to create new file: "+ ioex);
			}
			
			
			
	}
}
