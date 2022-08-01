
package com.example.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author nagarjuna.y
 */
public class LoggerClass {

	public static void WriteintoFile(Exception ex, int UserId, String UserName) {
		 //String FilePath = "E:\\DD_User\\Rakesh\\AppLogs\\JavaText.txt";
		File FilePath = FilePaths.GetAppLogsPath();
		String CurretTime = FilePaths.getCurrentTime();
	
		File file = new File(FilePath + File.separator + "JavaText.txt");
		// File file = new File(FilePath);

		try {
			FileWriter filewriter = new FileWriter(file, true);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			bufferwriter.newLine();
			// bufferwriter.append("--------------------------------------------------------------------------------------------------------");
			bufferwriter.append("Query " + UserName + " " + CurretTime);
			bufferwriter.newLine();
			bufferwriter.append(
					"--------------------------------------------------------------------------------------------------------");
			// bufferwriter.append("--------------------------------------------------------------------------------------------------------");
			bufferwriter.newLine();

			StackTraceElement[] aa = ex.getStackTrace();
			bufferwriter.append(ex.toString());
			bufferwriter.newLine();
			// for (int j = 0; j < aa.length; j++) {
			// bufferwriter.append(aa[j].toString());
			// bufferwriter.newLine();
			// }

			bufferwriter.append(
					"--------------------------------------------------------------------------------------------------------");
			bufferwriter.newLine();
			bufferwriter.close();
			filewriter.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	}

	/**
	 * Method to write User Login Details
	 * 
	 * @param objDetails
	 */
	/*public static void writeApplicationTracker(ApplicationTrackerBean objDetails) {

		File FilePath = FilePaths.GetAppLogsPath();
		String CurretTime = FilePaths.getCurrentTime();

		File file = new File(FilePath + File.separator + "UserLogDetails.txt");

		try {
			FileWriter filewriter = new FileWriter(file, true);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			bufferwriter.newLine();

			bufferwriter.append("Ip Address : " + objDetails.getIpAddress() + " Host Name : "
					+ objDetails.getIpHostName() + " MAC : " + objDetails.getMacAddress() + " Login UserName : "
					+ objDetails.getUsername() + " Login Time :  " + objDetails.getStartTime());
			bufferwriter.newLine();
			bufferwriter.append(
					"--------------------------------------------------------------------------------------------------------");
			bufferwriter.newLine();
			bufferwriter.close();
			filewriter.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	}*/
	
	/***
	 * OtherLogDetails
	 * @param rawData
	 */
	public static void OtherLogDetails(String rawData) {

		File FilePath = FilePaths.GetAppLogsPath();
		String CurretTime = FilePaths.getCurrentTime();

		File file = new File(FilePath + File.separator + "OthersErro.txt");

		try {
			FileWriter filewriter = new FileWriter(file, true);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			bufferwriter.newLine();

			bufferwriter.append(rawData);
			bufferwriter.newLine();
			bufferwriter.append(
					"--------------------------------------------------------------------------------------------------------");
			bufferwriter.newLine();
			bufferwriter.close();
			filewriter.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	}
	// Added By Rekha
	public static void WriteintoFiles(Exception ex, String QueryName,Object... args) {
		// String FilePath = "E:\\DD_User\\Rakesh\\AppLogs\\JavaText.txt";
		File FilePath = FilePaths.GetAppLogsPath();
		String CurretTime = FilePaths.getCurrentTime();
	
		File file = new File(FilePath + File.separator + "JavaText.txt");
		// File file = new File(FilePath);

		try {
			FileWriter filewriter = new FileWriter(file, true);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			bufferwriter.newLine();
			// bufferwriter.append("--------------------------------------------------------------------------------------------------------");
			bufferwriter.append("Query " + QueryName +"[");
			for(Object o : args){
				bufferwriter.append(QueryName +",");
			}
			bufferwriter.append("]"+CurretTime);
			
			bufferwriter.newLine();
			bufferwriter.append(
					"--------------------------------------------------------------------------------------------------------");
			// bufferwriter.append("--------------------------------------------------------------------------------------------------------");
			bufferwriter.newLine();

			StackTraceElement[] aa = ex.getStackTrace();
			bufferwriter.append(ex.toString());
			bufferwriter.newLine();
			// for (int j = 0; j < aa.length; j++) {
			// bufferwriter.append(aa[j].toString());
			// bufferwriter.newLine();
			// }

			bufferwriter.append(
					"--------------------------------------------------------------------------------------------------------");
			bufferwriter.newLine();
			bufferwriter.close();
			filewriter.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	}

}
