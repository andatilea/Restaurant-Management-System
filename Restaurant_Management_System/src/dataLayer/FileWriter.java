package dataLayer;

import java.io.*;

		//This Class is responsible for generating the bill, when requested.
	public class FileWriter {
	
		//The implemented method assures the fact that the output text file will contain an established String message containing all the order's needed information;
	public static void createBill(int orderID,String location, int Table, String date, int price) {

			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bill" + orderID + ".txt")));
				bw.write("Order " + orderID + " has been processed and is going to be served in the " + location + " area, at the table: " + Table
						+ "\n\n Bill computed at the date:" + date  +  "\n\n Total amount to pay: " + price);
				bw.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}
		}	
	}
