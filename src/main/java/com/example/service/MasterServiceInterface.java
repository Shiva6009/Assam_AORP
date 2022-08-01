package com.example.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.ApplyPost;
import com.example.model.ApplyPostFinalData;
import com.example.model.ApplyPostUserData;
import com.example.model.CasteMaster;
import com.example.model.DocumentUpload;
import com.example.model.DownloadDetails;
import com.example.model.EducationalQualifications;
import com.example.model.OTRdocuments;
import com.example.model.PaymentPendingDetails;
import com.example.model.ProfileData;
import com.example.model.TestClass;
import com.example.model.UserRegistrationData;
import com.example.model.UserRegistrationDataInput;
import com.example.model.WorkExperience;
import com.example.storedprocedure.AdmitCard;
import com.example.storedprocedure.Advertistment;
import com.example.storedprocedure.AdvertistmentInterface;
import com.example.storedprocedure.ApplyPostDynamicDropdown;
import com.example.storedprocedure.DocumentUploadforPost;
import com.example.storedprocedure.DynamicOptionsforApplyPostInterface;
import com.example.storedprocedure.EducationalQualificationMaster;
import com.example.storedprocedure.EducationalQualificationforPostInterface;
import com.example.storedprocedure.EducationalQualificationforPostInterface1;
import com.example.storedprocedure.EducationalQualificationforPostInterface2;
import com.example.storedprocedure.ExamZones;
import com.example.storedprocedure.ExaminationZoneInterface;
import com.example.storedprocedure.PageSetup;
import com.example.storedprocedure.PayementModuleInterface;
import com.example.storedprocedure.PaymentPendingDetailsAttributes;
import com.example.storedprocedure.PaymentSuccessDetails;
import com.example.storedprocedure.PayslipDetails;
import com.example.storedprocedure.PostMaster;
import com.example.storedprocedure.PostMasterInterface;
import com.example.storedprocedure.SpliupPayment;
import com.example.storedprocedure.WorkExperienceforPost;


public interface MasterServiceInterface {

	public String generateOTP(String toMobileNo) throws IOException;

	public int savePersonalDetails(UserRegistrationDataInput userRegistrationData);

	List<String> fetchDistrict(String statename);

	List<String> fetchState();

	public int saveEducationalDetails(EducationalQualifications educationalQualifications);

	public JSONObject loginVerification(String emailid, String password);

	UserRegistrationDataInput fetchPersonalDetails(Integer employeeid);

	public String updateUserPersonalDetails(UserRegistrationDataInput updateUserRegistrationData);

	int saveWorkExperience(WorkExperience workexperience);

	void savePhotoandSignature(String employeeid, String photoFile, String signatureFile)
			throws Exception;

	String saveDocuments(OTRdocuments details) throws IOException;

	public String generateCaptcha();

	public EducationalQualifications fetchEducationalDetails(String employeeid);

	public WorkExperience fetchWorkExpeience(String employeeid);

	public UserRegistrationData fetchPhotoandSignature(String employeeid) throws IOException;

	public String fetchOldPassword(String employeeid);

	public String setNewPassword(String employeeid, String newpassword);

	public ProfileData fetchAllData(String employeeid);

	public boolean[] fetchemailandphonenumber(String email, String password);

	public String getByteArrayFromImageURL(String url) throws IOException;

	List<String> fetchUGdetails();

	List<String> fetchPGdetails();

	List<String> fetchDiplomaDetails();

	List<String> fetchCaste();
	
	List<String> fetchBenchmarkCategory();
	
	List<String> fetchBenchmarkCategorySubCategory(String categoryselected);
	
	List<ExaminationZoneInterface> fetchExaminationZone(int postid);

	List<PostMasterInterface> fetchpost(String employeeid);
	
	List<AdvertistmentInterface> fetchAllPost();
	
	List<EducationalQualificationforPostInterface> fetchEducationalqualificationattributes(int postid);
	
	List<EducationalQualificationforPostInterface1> fetchEducationalqualificationattributesforflagone(int postid ,  String[] selectedvalues);
	
	//List<EducationalQualificationforPostInterface2> fetchEducationalqualificationattributesforflagtwo(int postid);
	
	List<DynamicOptionsforApplyPostInterface> fetchdynamicoptionsforpost(String employeeid , String postid);
	
	List<DocumentUploadforPost> fetchDocumentuploadforPost(int postid);
	
	List<WorkExperienceforPost> fetchWorkexperienceforPost(int postid);
	
	String savepersonaldetailsforapplypost(ApplyPost detailsforapplypost) throws IOException;
	
	int fetchcastefordocument(String employeeid);
	
	 ApplyPostFinalData[] fetchActivitySeaction(String employeeid);
	 
	 public DownloadDetails finaldownloaddetails(String emoloyeeid , String postid);
	 
	 public PayementModuleInterface fetchpaymentdetails(String postid , String employeeid);
	 
	 void cancelApplication(String postid , String employeeid , String otp);
	 
	 void deleteEducationqualifiication(String slnoftable , String tablename);
	 
	 public void generatePassword(String mobileno);
	 
	 public ApplyPostDynamicDropdown fetchapplypostdynamicdropdownvalues(String postid);
	 
	public String generateOTPforcancelapplication(String toMobileNo) throws IOException;
	
	PayslipDetails fetchpayslipdetails(String postid , String employeeid); 
	
	PaymentPendingDetails paymentpendingstatus(String postid , String employeeid);
	
	String updatependingtopaid(String postid , String employeeid);
	
	PaymentPendingDetailsAttributes fetchpendingpaymentattributes(String postid , String employeeid);
	
	boolean checkphonenumberpresentornot(String mobilenum);
	
	String updatetable(String employeeid);

	List<WorkExperienceforPost> fetchworkexperiecefordyamicdropdown(String postid , String selectedvalue);
	
    PaymentSuccessDetails fetchpaymentsuccessdetails(String postid , String employeeid);
    
    SpliupPayment fetchpayemntsplitup(String postid , String employeeid);
    
    List<String> fetchdynamicheadingforapplypost(String postid);
    
    DocumentUpload[] fetchdocumentuplodedduringotr(String employeeid);
    
    List<String> dropdownvaluesfordynamicquestions(String postid , String employeeid);
    
    int verifyGRNnumber(String grnnumber);
    
    int verifypaymentforMVI(String employeeid , String postid);
    
    AdmitCard fetchAdmitCard(String applicatioid , String dob);
    
    List<ExamZones> fetchExamsZones(String applicatioid , String dob);
    
    List<PageSetup> pagesetup(String data);

}
