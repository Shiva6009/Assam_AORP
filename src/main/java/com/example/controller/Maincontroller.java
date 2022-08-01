package com.example.controller;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.lang.model.util.Elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.hibernate.annotations.AccessType;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.model.ApplyPost;
import com.example.model.ApplyPostFinalData;
import com.example.model.ApplyPostUserData;
import com.example.model.ApplyPostWorkExperienceDetails;
import com.example.model.CasteMaster;
import com.example.model.Check;
import com.example.model.DocumentUpload;
import com.example.model.DownloadDetails;
import com.example.model.EducationalQualifications;
import com.example.model.OTRdocuments;
import com.example.model.PaymentDetails;
import com.example.model.PaymentPendingDetails;
import com.example.model.PhotoandSignatureObj;
import com.example.model.ProfileData;
import com.example.model.Schoolingdetails;
import com.example.model.TestClass;
import com.example.model.UserRegistrationData;
import com.example.model.UserRegistrationDataInput;
import com.example.model.WorkExperience;
import com.example.model.workexp;
import com.example.service.EncryptandDecrypt;
import com.example.service.MasterServiceInterface;
import com.example.storedprocedure.AdmitCard;
import com.example.storedprocedure.Advertistment;
import com.example.storedprocedure.AdvertistmentInterface;
import com.example.storedprocedure.ApplyPostDynamicDropdown;
import com.example.storedprocedure.DocumentUploadforPost;
import com.example.storedprocedure.DynamicOptionsforApplyPostInterface;
import com.example.storedprocedure.EducationalQualificationMaster;
import com.example.storedprocedure.EducationalQualificationforPostInterface;
import com.example.storedprocedure.EducationalQualificationforPostInterface1;
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


@CrossOrigin(origins = "*")
@RestController
public class Maincontroller {

	@Autowired(required = true)
	private MasterServiceInterface masterServiceInterface;

	@Autowired(required = true)
	private EncryptandDecrypt encdec;

	@GetMapping("/testAPI")
	public String testAPI() {
		return "API's are Working Fine";
	}

	
	// API 127.0.0.1:9090/Assam_Online_Recruitement_Portal/save  username : , fathername : 
	@RequestMapping(value = "/fetchstate", method = RequestMethod.GET)
	public List<String> fetchState() {
		return masterServiceInterface.fetchState();
	}

	@RequestMapping(value = "/fetchdistrict", method = RequestMethod.GET)
	public List<String> fetchDistrict(@RequestParam String statename) {
		return masterServiceInterface.fetchDistrict(statename);
	}

	@RequestMapping(value = "/fetchUGdetails", method = RequestMethod.GET)
	public List<String> fetchUGdetails() {
		return masterServiceInterface.fetchUGdetails();
	}

	@RequestMapping(value = "/fetchcaste", method = RequestMethod.GET)
	public List<String> fetchCaste() {
		return masterServiceInterface.fetchCaste();
	}

	@RequestMapping(value = "/fetchbenchmarkcategory", method = RequestMethod.GET)
	public List<String> fetchBenchmarkCategory() {
		return masterServiceInterface.fetchBenchmarkCategory();
	}

	@RequestMapping(value = "/fetchbenchmarkdisabilitysubcategory", method = RequestMethod.GET)
	public List<String> fetchBenchmarkCategorysubcategory(@RequestParam String category) {
		return masterServiceInterface.fetchBenchmarkCategorySubCategory(category);
	}

	@RequestMapping(value = "/fetchPGdetails", method = RequestMethod.GET)
	public List<String> fetchPGdetails() {
		return masterServiceInterface.fetchPGdetails();
	}

	@RequestMapping(value = "/fetchDiplomadetails", method = RequestMethod.GET)
	public List<String> fetchDiplomadetails() {
		return masterServiceInterface.fetchDiplomaDetails();
	}

	@RequestMapping(value = "fetchemailandphonenumber", method = RequestMethod.GET)
	public boolean[] fetchemailandphonenumber(@RequestParam String emailid, String phonenumber) {
		return masterServiceInterface.fetchemailandphonenumber(emailid, phonenumber);
	}

	@RequestMapping(value = "/generateotp", method = RequestMethod.GET)
	public String generateOTP(@RequestParam String mobilenumber) {
		try {
			String otp = masterServiceInterface.generateOTP(mobilenumber);

			System.out.println(" OTP " + otp);
			return otp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/savepersonaldetails", method = RequestMethod.POST)
	public int savePersonalDetails(@RequestBody UserRegistrationDataInput userRegistrationData) {
		return masterServiceInterface.savePersonalDetails(userRegistrationData);
	}

	@RequestMapping(value = "/saveeducationaldetails", method = RequestMethod.POST)
	public int saveEducationalDetails(@RequestBody EducationalQualifications educationalQualifications) {
		masterServiceInterface.saveEducationalDetails(educationalQualifications);
		return 0;
	}

	@RequestMapping(value = "/saveworkexperience", method = RequestMethod.POST)
	public int saveWorkExperience(@RequestBody WorkExperience workExperience) {
		masterServiceInterface.saveWorkExperience(workExperience);
		return 0;
	}

	@RequestMapping(value = "/loginverification", method = RequestMethod.GET)
	public JSONObject loginVerification(@RequestParam String emailid, String password) {
		return masterServiceInterface.loginVerification(emailid, password);
	}

	@RequestMapping(value = "/fetchpersonaldetails", method = RequestMethod.GET)
	public UserRegistrationDataInput fetchPersonalDetails(@RequestParam String employeeid) {
		return masterServiceInterface.fetchPersonalDetails(Integer.parseInt(employeeid));
	}

	@RequestMapping(value = "/updatepersonalDetails", method = RequestMethod.PUT)
	public String updatePersonalDetails(@RequestBody UserRegistrationDataInput updateUserRegistrationData) {
		return masterServiceInterface.updateUserPersonalDetails(updateUserRegistrationData);
	}

//	@RequestMapping(value = "/uploadphotoandsignature", method = RequestMethod.POST)
//	public String uploadPhotoandSignature(@RequestParam("employeeid") String employeeid,
//			@RequestParam("file") MultipartFile imagesphoto, @RequestParam("files") MultipartFile imagessign) {
//		try {
//			masterServiceInterface.savePhotoandSignature(employeeid, imagesphoto, imagessign);
//		} catch (Exception e) {
//
//		}
//		return null;
//	}

	@RequestMapping(value = "/uploadphotoandsignature", method = RequestMethod.POST)
	public String uploadPhotoandSignature(@RequestBody PhotoandSignatureObj object) {

//		
//		System.out.println(" PHOtO " + photo.toString());
//		System.out.println(" SIGN " + sign);
//		
		try {
			masterServiceInterface.savePhotoandSignature(object.getEmployeeid(), object.getPhotourl(),
					object.getSignurl());
		} catch (Exception e) {

		}
		return "Hai";
	}

	@RequestMapping(value = "/savedocument", method = RequestMethod.POST)
	public String saveDocument(@RequestBody OTRdocuments details) throws IOException {

		return masterServiceInterface.saveDocuments(details);

	}

	@RequestMapping(value = "/generatecaptcha", method = RequestMethod.GET)
	public String generateCaptcha() {
		String res = masterServiceInterface.generateCaptcha();
		return res;
	}

	@RequestMapping(value = "/fetcheducationaldetails", method = RequestMethod.GET)
	public EducationalQualifications fetchEducationalDetails(@RequestParam String employeeid) {
		return masterServiceInterface.fetchEducationalDetails(employeeid);
	}

	@RequestMapping(value = "/fetchworkexperiences", method = RequestMethod.GET)
	public WorkExperience fetchWorkExperiences(@RequestParam String employeeid) {
		return masterServiceInterface.fetchWorkExpeience(employeeid);
	}

	@RequestMapping(value = "/fetchphotoandsignature", method = RequestMethod.GET)
	public UserRegistrationData fetchPhotoandSignature(@RequestParam String employeeid) throws IOException {
		return masterServiceInterface.fetchPhotoandSignature(employeeid);
	}

	@RequestMapping(value = "/fetcholdpassword", method = RequestMethod.GET)
	public String fetchOldPassword(@RequestParam String employeeid) {
		return masterServiceInterface.fetchOldPassword(employeeid);
	}

	@RequestMapping(value = "/setnewpassword", method = RequestMethod.GET)
	public String setNewPassword(@RequestParam("employeeid") String employeeid,
			@RequestParam("password") String password) {
		return masterServiceInterface.setNewPassword(employeeid, password);
	}

	@RequestMapping(value = "/fetchprofiledata", method = RequestMethod.GET)
	public ProfileData fetchProfileData(@RequestParam String employeeid) {
		return masterServiceInterface.fetchAllData(employeeid);
	}

	@RequestMapping(value = "/fetchpost", method = RequestMethod.GET)
	public List<PostMasterInterface> fetchPost(@RequestParam String employeeid) {
		return masterServiceInterface.fetchpost(employeeid);
	}

	@RequestMapping(value = "/fetchExaminationzone", method = RequestMethod.GET)
	public List<ExaminationZoneInterface> fetchExamination(@RequestParam int postid) {
		return masterServiceInterface.fetchExaminationZone(postid);
	}

	@RequestMapping(value = "fetchAllPost", method = RequestMethod.GET)
	public List<AdvertistmentInterface> fetchAllPost() {
		return masterServiceInterface.fetchAllPost();
	}

	@RequestMapping(value = "fetchEducationalqulificationsforpost", method = RequestMethod.GET)
	public List<EducationalQualificationforPostInterface> fetchEducationQualificationattributes(
			@RequestParam int postid) {
		return masterServiceInterface.fetchEducationalqualificationattributes(postid);
	}

	@RequestMapping(value = "fetchEducationalqulificationsforpostone", method = RequestMethod.GET)
	public List<EducationalQualificationforPostInterface1> fetchEducationQualificationattributesforflag1(
			@RequestParam int postid, @RequestParam String[] selectedvaluearray) {
		return this.masterServiceInterface.fetchEducationalqualificationattributesforflagone(postid,
				selectedvaluearray);
	}

	@RequestMapping(value = "fetchdynamicoptions", method = RequestMethod.GET)
	public List<DynamicOptionsforApplyPostInterface> fetchdynaicoptionsforpost(@RequestParam String employeeid,
			String postid) {
		return masterServiceInterface.fetchdynamicoptionsforpost(employeeid, postid);
	}

	@RequestMapping(value = "fetchdocumentuploadforpost", method = RequestMethod.GET)
	public List<DocumentUploadforPost> fetchDocumentUploadforPost(@RequestParam int postid) {
		return masterServiceInterface.fetchDocumentuploadforPost(postid);
	}

	@RequestMapping(value = "fetchworkexperienceforpost", method = RequestMethod.GET)
	public List<WorkExperienceforPost> fetchWorkExperienceforPost(@RequestParam int postid) {
		return masterServiceInterface.fetchWorkexperienceforPost(postid);
	}

	@RequestMapping(value = "savepersonaldetailsforpost", method = RequestMethod.POST)
	public String savePersonalforPost(@RequestBody ApplyPost detailsforapplypost) throws IOException {
		return masterServiceInterface.savepersonaldetailsforapplypost(detailsforapplypost);

	}

	@RequestMapping(value = "fetchcastefordocument", method = RequestMethod.GET)
	public int fetchcastefordocument(@RequestParam String employeeid) throws IOException {
		return masterServiceInterface.fetchcastefordocument(employeeid);
	}

	@RequestMapping(value = "apicallfromegrass", method = RequestMethod.POST)
	public RedirectView APIcallfromegrass(@RequestParam String DEPARTMENT_ID) {
		return new RedirectView("http://localhost:4200/#/dashboard/paymentreceipt/?name=siva&password=6009", true);
	}

	@RequestMapping(value = "/fetchactivityseaction", method = RequestMethod.GET)
	public ApplyPostFinalData[] fetchActivitySeaction(@RequestParam String employeeid) {
		return masterServiceInterface.fetchActivitySeaction(employeeid);
	}

	@RequestMapping(value = "/finaldownloaddetails", method = RequestMethod.GET)
	public DownloadDetails finaldownloaddetails(@RequestParam String employeeid, String postid) {
		return masterServiceInterface.finaldownloaddetails(employeeid, postid);
	}

	@RequestMapping(value = "/fetchpayementdata", method = RequestMethod.GET)
	public PaymentSuccessDetails fetchpaymentsuccessdetails(@RequestParam String postid, String employeeid) {
		return masterServiceInterface.fetchpaymentsuccessdetails(postid, employeeid);
	}

	@RequestMapping(value = "/fetchpayementdetails", method = RequestMethod.GET)
	public PayementModuleInterface fetchPayementmodule(String employeeid, String postid) {
		return masterServiceInterface.fetchpaymentdetails(postid, employeeid);
	}

	@RequestMapping(value = "cancelapplication", method = RequestMethod.GET)
	public void CancelApplication(@RequestParam String postid, @RequestParam String employeeid,
			@RequestParam String otp) {
		masterServiceInterface.cancelApplication(postid, employeeid, otp);
		// return "Failed";
	}

	@RequestMapping(value = "deleteeducationqualification", method = RequestMethod.GET)
	public String deleteEducationqualifiication(@RequestParam String slnooftable, @RequestParam String tablename) {
		masterServiceInterface.deleteEducationqualifiication(slnooftable, tablename);
		return "Success";

	}

	@RequestMapping(value = "applypostdynamicdropdownvalues", method = RequestMethod.GET)
	public ApplyPostDynamicDropdown fetchdynamicdropdownvalues(@RequestParam String postid) {
		return masterServiceInterface.fetchapplypostdynamicdropdownvalues(postid);
	}

	@RequestMapping(value = "generatepassword", method = RequestMethod.GET)
	public String generatePassword(@RequestParam String mobilenumber) {
		masterServiceInterface.generatePassword(mobilenumber);
		return "Success";
	}

	@RequestMapping(value = "cancelapplicationotp", method = RequestMethod.GET)
	public String confirmmessage(@RequestParam String mobilenum) throws IOException {
		return masterServiceInterface.generateOTPforcancelapplication(mobilenum);
	}

	@RequestMapping(value = "fetchpayslip", method = RequestMethod.GET)
	public PayslipDetails fetchpayslipdetails(@RequestParam String postid, String employeeid) {
		return masterServiceInterface.fetchpayslipdetails(postid, employeeid);
	}

	@RequestMapping(value = "paymentpendingdetails", method = RequestMethod.GET)
	public PaymentPendingDetails testAPI(@RequestParam String postid, @RequestParam String employeeid) {
		return masterServiceInterface.paymentpendingstatus(postid, employeeid);
	}

	@RequestMapping(value = "updatefrompendingtopaid", method = RequestMethod.GET)
	public String updatependingtopaidstatus(@RequestParam String postid, @RequestParam String employeeid) {
		return masterServiceInterface.updatependingtopaid(postid, employeeid);
	}

	@RequestMapping(value = "fetchpendingattributes", method = RequestMethod.GET)
	public PaymentPendingDetailsAttributes fetchpendingattributs(@RequestParam String postid,
			@RequestParam String employeeid) {
		return masterServiceInterface.fetchpendingpaymentattributes(postid, employeeid);
	}

	@RequestMapping(value = "checkphonepresentornot", method = RequestMethod.GET)
	public boolean CheckPhonepresentornot(@RequestParam String mobilenum) {
		return masterServiceInterface.checkphonenumberpresentornot(mobilenum);
	}

	@RequestMapping(value = "updatetable", method = RequestMethod.GET)
	public String updatetable(@RequestParam String employeeid) {
		return masterServiceInterface.updatetable(employeeid);
	}

	@RequestMapping(value = "fetchworkexperiencebasedondynamicdropdown", method = RequestMethod.GET)
	public List<WorkExperienceforPost> fetchworkexperiecefordyamicdropdown(String postid, String selectedvalue) {
		return masterServiceInterface.fetchworkexperiecefordyamicdropdown(postid, selectedvalue);
	}

	@RequestMapping(value = "splitpaymentdetails", method = RequestMethod.GET)
	public SpliupPayment fetchpaymentsplitup(@RequestParam String postid, String employeeid) {
		return masterServiceInterface.fetchpayemntsplitup(postid, employeeid);
	}

	@RequestMapping(value = "egrasscheck", method = RequestMethod.POST)
	public ResponseEntity<String> egrasscheck() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("DEPARTMENT_ID", "PSC");
		map.add("OFFICE_CODE", "000");
		map.add("AMOUNT", "250.0");

		String url = "https://uatgras.assam.gov.in/challan/views/frmgrnfordept.php";

		RestTemplate res = new RestTemplate();
		return res.postForEntity(url, map, String.class);

	}

	@RequestMapping(value = "dynamicheadingforpost", method = RequestMethod.GET)
	public List<String> fetchdynamicheadingforapplypost(@RequestParam String postid) {
		return masterServiceInterface.fetchdynamicheadingforapplypost(postid);
	}

	@RequestMapping(value = "fetchuploadeddocumnetduringotr", method = RequestMethod.GET)
	public DocumentUpload[] fetchdocumentuplodedduringotr(@RequestParam String employeeid) {
		return masterServiceInterface.fetchdocumentuplodedduringotr(employeeid);
	}

	@RequestMapping(value = "decyprtpassword", method = RequestMethod.GET)
	public String decyprtPassword(String password) {
		System.out.println(" Password : " + password);
		String up = password.replace(' ', '+');
		String output =  encdec.decrypt(up);
		System.out.println(" Output " + output);
		return output;
	}

	@RequestMapping(value = "dropdownvaluesfordynamicquestions", method = RequestMethod.GET)
	public List<String> dropdownvlauesfordynamicquestions(String postid, String employeeid) {
		return masterServiceInterface.dropdownvaluesfordynamicquestions(postid, employeeid);
	}

	@RequestMapping(value = "verifygrnnumber", method = RequestMethod.GET)
	public int verifyGRNnumber(@RequestParam String grnnumber) {
		System.out.println(" GRN " + grnnumber);
		int result = masterServiceInterface.verifyGRNnumber(grnnumber);
		return result;
	}

	@RequestMapping(value = "verifypaymentformvi", method = RequestMethod.GET)
	public int verifypaymentforMVI(@RequestParam String employeeid, String postid) {
		System.out.println(" Inside MVO CONtroller ");
		return masterServiceInterface.verifypaymentforMVI(employeeid, postid);
	}
	
	@RequestMapping(value = "fetchadmitcard" ,  method = RequestMethod.GET)
	public AdmitCard fetchAdmitCard(@RequestParam String applicationid , String dob)
	{
		System.out.println(" Application ID " + applicationid  + " DOB " + dob);
		return masterServiceInterface.fetchAdmitCard(applicationid, dob);
	}
	
	@RequestMapping(value = "fetchexamzones" , method = RequestMethod.GET)
	public List<ExamZones> fetchExamZones(@RequestParam String applicationid , String dob)
	{
		return masterServiceInterface.fetchExamsZones(applicationid, dob);
	}
	
	
	
	@RequestMapping(value = "pagesetup" , method = RequestMethod.GET)
	public List<PageSetup> pageSetUp(@RequestParam String data)
	{
		return masterServiceInterface.pagesetup(data);
	}

} 