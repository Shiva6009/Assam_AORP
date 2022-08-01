/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Rakesh.ks
 */
public class FilePaths {

    static String FileCreationFolderName1 = "CityToPostExcelDowload";
    static String FileCreationPath1 = "H:\\MP";
	static String FileCreationPath = "H:\\BANGAL_GAS";
	
	/*static String FileCreationFolderName1 = "CityToPostExcelDowload";
    static String FileCreationPath1 = "C:\\MP";
	static String FileCreationPath = "C:\\BANGAL_GAS";*/
	
	static String FileCreationFolderName = "BGCLFilecreation\\SpotBilling\\TO_SBM";
	static String FileUploadFolderName = "SpotBilling\\FROM_SBM";
	static String ECSFileCreation = "ECS_Data";
	static String RegistrationFileCreationPath = "H:\\Registration Form";
	
	//static String RegistrationFileCreationPath = "C:\\Registration Form";
	
	static String ReportFileDownloadName = "Dispatch";
	static String AppLogPath = "AppLogs";
	static String TempPath = "tmp";
	static String today, year, month;
	static String GetLedgerReportFolder = "LedgerReports";
	static String mpUploadPDF = "H:\\MPForm\\MP Upload PDF";
	static String mpExamResultsUpload = "H:\\MPForm\\MP Exam Reults Upload";
	static String examSchedulePDF = "H:\\MPForm\\Exam Schedule PDF";
	static String mpModeAnswerUploadPDF = "H:\\MPForm\\Model Answer Papers";
	
	/*static String mpUploadPDF = "C:\\MPForm\\MP Upload PDF";
	static String mpExamResultsUpload = "C:\\MPForm\\MP Exam Reults Upload";
	static String examSchedulePDF = "C:\\MPForm\\Exam Schedule PDF";
	static String mpModeAnswerUploadPDF = "C:\\MPForm\\Model Answer Papers";
	//static String mpAdvertisementPDFS = "D:\\MPForm\\Advertisements";
	static String mpAdvertisementPDFS = "C:\\MPForm\\Advertisements";*/
	static String mpAdvertisementPDFS = "H:\\APSC\\Advertisement\\";
	//static String APSCdownloadZIPDocuments = "H:\\APSC\\CandidateDocumentDownload\\";
	//static String APSCdownloadZIPDocuments = "H:\\APSC\\CandidateDocumentDownload\\";
	static String APSCdownloadZIPDocuments = "H:\\APSC\\CandidateDocumentDownload\\";

	// for gas new connection
	public static String gasFileCreationPath = FileCreationPath + "\\GAS Connection";
	// for User Creation
	public static String userFileCreationPath = FileCreationPath + "\\BGCL";
	public static String MPUploadPDF = mpUploadPDF;
	public static String AdvertisementPDFS = mpAdvertisementPDFS;
	public static String MPExamResultsUpload = mpExamResultsUpload;
	public static String ExamSchedulePDF = examSchedulePDF;
	public static String MPModeAnswerUploadPDF = mpModeAnswerUploadPDF;
	static String CityToPostExcelImport = "ExcelImport\\CityToPostExcel";
	
	public static String registrationFileCreationPath = RegistrationFileCreationPath + "\\Registration Form";
	public static String apscDownloadZIP = APSCdownloadZIPDocuments;

	public static File GetFileCreationPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath1 + File.separator + FileCreationFolderName1 + File.separator + getYear()
				+ File.separator + getMonth());
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}
	
	/**
	 * JV Excel Import Path
	 * 
	 * @return
	 */
	public static File GetJVExcelImportPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath1 + File.separator + CityToPostExcelImport + File.separator + getYear()
				+ File.separator + getMonth());
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}
	
	public static File GetFileCreationPathForCityToPostExcelDownload() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath1 + File.separator + FileCreationFolderName1 + File.separator + getYear()
				+ File.separator + getMonth());
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	/**
	 * to Get Merge Download TempFiles path
	 * 
	 * @return
	 */
	public static File GetSBMMergeDownloadPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + FileCreationFolderName + File.separator + getYear()
				+ File.separator + getMonth() + File.separator + "MergeDownloadTempFiles");
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	public static File getECSFileCreationPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + ECSFileCreation + File.separator + getYear()
				+ File.separator + getMonth() + File.separator + getToday());
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	public static File getTempFilePath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + TempPath);
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	public static File GetFileUploadPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + FileUploadFolderName + File.separator + getYear()
				+ File.separator + getMonth());
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	public static File GetAppLogsPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + AppLogPath);
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	public static File GetPaymentFilePath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + "PaymentFilePath");
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	/**
	 * To get Report File Download Path
	 * 
	 * @return
	 */
	public static File GetReportFileDownloadPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + ReportFileDownloadName);
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	/**
	 *
	 * Year
	 *
	 * @return
	 */
	public static String getYear() {
		year = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
		return year;

	}

	/**
	 * Month
	 *
	 * @return
	 */
	public static String getMonth() {
		month = new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
		switch (month) {
		case "01":
			month = "January";
			break;
		case "02":
			month = "February";
			break;
		case "03":
			month = "March";
			break;
		case "04":
			month = "April";
			break;
		case "05":
			month = "May";
			break;
		case "06":
			month = "June";
			break;
		case "07":
			month = "July";
			break;
		case "08":
			month = "August";
			break;
		case "09":
			month = "September";
			break;
		case "10":
			month = "October";
			break;
		case "11":
			month = "November";
			break;
		case "12":
			month = "December";
			break;
		default:
			break;
		}
		return month;

	}

	/**
	 *
	 * Get Today
	 *
	 * @return
	 */
	public static String getToday() {

		today = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
		return today;

	}

	public static String getCurrentTime() {
		month = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a").format(Calendar.getInstance().getTime());

		return month;

	}

	public static String FileUploadTime() {
		month = new SimpleDateFormat("ddMMyyyy_hh-mm-ss-SS_a").format(Calendar.getInstance().getTime());

		return month;

	}

	public static File GetLedgerReportPath(String filePath) {

		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + GetLedgerReportFolder + File.separator + filePath);
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

	/**
	 * MS Excel Import Path added by bhanuprakash.c for master data excel upload
	 * 
	 * @return
	 */
	static String MSExcelImportFolderName = "ExcelImport\\Master Data";

	public static File GetMasterDateExcelImportPath() {
		File file;
		// + File.separator + getToday()
		file = new File(FileCreationPath + File.separator + MSExcelImportFolderName + File.separator + getYear()
				+ File.separator + getMonth());
		if (!file.exists()) {
			file.mkdirs();
		} else {

		}
		return file;
	}

}
