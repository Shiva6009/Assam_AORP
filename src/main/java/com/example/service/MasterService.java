package com.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;
//import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

//
import org.json.simple.JSONObject;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.dao.JPASaveApplypostFinalData;
import com.example.dao.JPASaveDocuments;
import com.example.dao.JPASaveDocumentsforApplyPost;
import com.example.dao.JPASaveDynamicOptionsforApplyPOst;
import com.example.dao.JPASaveEducationalDetailsforPost;
import com.example.dao.JPASaveEducationalOtherQualificationsDetails;
import com.example.dao.JPASaveEducationalPostgraduationDetails;
import com.example.dao.JPASaveEducationalResearchPaperDetails;
import com.example.dao.JPASaveEducationalSchoolingDetails;
import com.example.dao.JPASaveEducationalUndergraduationDetails;
import com.example.dao.JPASavePayementPendingDetails;
import com.example.dao.JPASavePersonalDetailsInterface;
import com.example.dao.JPASavePersonalDetailsSpecialCategory;
import com.example.dao.JPASavePersonalDetailsforApplyPost;
import com.example.dao.JPASaveWorkExperienceDetails;
import com.example.dao.JPASaveWorkexperienceforApplyPost;
import com.example.dao.OldPaymentDetailsReposistory;
import com.example.dao.OtpSavedReposistory;
import com.example.model.ApplyPost;
import com.example.model.ApplyPostDocumentUpload;
import com.example.model.ApplyPostDynamicOptions;
import com.example.model.ApplyPostEducationalQualification;
import com.example.model.ApplyPostFinalData;
import com.example.model.ApplyPostUserData;
import com.example.model.ApplyPostWorkExperienceDetails;
import com.example.model.DocumentUpload;
import com.example.model.DownloadDetails;
import com.example.model.EducationalQualifications;
import com.example.model.OTRdocuments;
import com.example.model.OldPaymentDetails;
import com.example.model.OtherQualificationDetails;
import com.example.model.OtpSavedTable;
import com.example.model.PaymentPendingDetails;
import com.example.model.PostGraduationDetails;
import com.example.model.ProfileData;
import com.example.model.ResearchPapersDetails;
import com.example.model.Schoolingdetails;
import com.example.model.UnderGradutionDetails;
import com.example.model.UserRegistrationData;
import com.example.model.UserRegistrationDataInput;
import com.example.model.UserRegistrationDataSpecialCategory;
import com.example.model.WorkExperience;
import com.example.model.Workexperiences;
import com.example.storedprocedure.AdmitCard;
import com.example.storedprocedure.AdvertistmentInterface;
import com.example.storedprocedure.ApplyPostDynamicDropdown;
import com.example.storedprocedure.DocumentUploadforPost;
import com.example.storedprocedure.DynamicOptionsforApplyPostInterface;
import com.example.storedprocedure.EducationalQualificationforPostInterface;
import com.example.storedprocedure.EducationalQualificationforPostInterface1;
import com.example.storedprocedure.ExamZones;
import com.example.storedprocedure.ExaminationZoneInterface;
import com.example.storedprocedure.PageSetup;
import com.example.storedprocedure.PayementModuleInterface;
import com.example.storedprocedure.PaymentPendingDetailsAttributes;
import com.example.storedprocedure.PaymentSuccessDetails;
import com.example.storedprocedure.PayslipDetails;
import com.example.storedprocedure.PostMasterInterface;
import com.example.storedprocedure.SpliupPayment;
import com.example.storedprocedure.StoredProcedureReposistory;
import com.example.storedprocedure.WorkExperienceforPost;

@Service
public class MasterService implements MasterServiceInterface {

//	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MasterService.class);

	@Autowired
	JPASavePersonalDetailsInterface jpaSavePersonalDetailsInterface;

	@Autowired
	JPASaveEducationalSchoolingDetails jpaSaveEducationalSchoolingDetails;

	@Autowired
	JPASaveEducationalUndergraduationDetails jpaSaveEducationalUndergraduationDetails;

	@Autowired
	JPASaveEducationalPostgraduationDetails jpaSaveEducationalPostgraduationDetails;

	@Autowired
	JPASaveEducationalOtherQualificationsDetails jpaSaveEducationalOtherQualificationsDetails;

	@Autowired
	JPASaveEducationalResearchPaperDetails jpaSaveEducationalResearchPaperDetails;

	@Autowired
	JPASaveWorkExperienceDetails jpaSaveWorkExperienceDetails;

	@Autowired
	JPASaveDocuments jpaSaveDocuments;

	@Autowired
	EncryptandDecrypt encryptanddecrypt;

	@Autowired
	private EntityManager em;

	@Autowired
	StoredProcedureReposistory storedProcedureReposistory;

	@Autowired
	JPASavePersonalDetailsforApplyPost jpaSavePersonalDetailsforApplyPost;

	@Autowired
	JPASaveWorkexperienceforApplyPost jpaSaveWorkexperienceforApplyPost;

	@Autowired
	JPASaveEducationalDetailsforPost jpaSaveEducationalDetailsforPost;

	@Autowired
	JPASavePersonalDetailsSpecialCategory jpaSavePersonalDetailsSpecialCategory;

	@Autowired
	JPASaveApplypostFinalData jpaSaveApplypostFinalData;

	@Autowired
	JPASaveDocumentsforApplyPost jpaSaveDocumentsforApplypost;

	@Autowired
	JPASavePersonalDetailsforApplyPost personaldetailsforapplypost;

	@Autowired
	JPASaveDynamicOptionsforApplyPOst jpaSaveDynamicOptionsforApplyPOst;

	@Autowired
	JPASavePayementPendingDetails jpaSavePayementPendingDetails;

	@Autowired
	OldPaymentDetailsReposistory oldPaymentDetailsReposistory;

	@Autowired
	OtpSavedReposistory otpSavedReposistory;

	@Override
	public int savePersonalDetails(UserRegistrationDataInput userRegistrationData) {
		try {
			String password = encryptanddecrypt.encrypt(userRegistrationData.getPassword());
			UserRegistrationData obj = new UserRegistrationData();
			obj.setFull_name(userRegistrationData.getFull_name().toUpperCase());
			obj.setFathers_name(userRegistrationData.getFathers_name().toUpperCase());
			obj.setMothers_name(userRegistrationData.getMothers_name().toUpperCase());
			// obj.setGender(userRegistrationData.getGender());
			obj.setGender(userRegistrationData.getGender());
			obj.setD_o_b(userRegistrationData.getD_o_b());
			obj.setMobile(userRegistrationData.getMobile());
			obj.setAlternative_Mobie_number(userRegistrationData.getAlternative_Mobie_number());
			obj.setEmail(userRegistrationData.getEmail());
			obj.setNationality(userRegistrationData.getNationality());
			obj.setPermanent_resident_of_assam(userRegistrationData.getPermanent_resident_of_assam());
			obj.setCaste(jpaSavePersonalDetailsInterface.fetchCasteIdfromCasteName(userRegistrationData.getCaste()));

			if (!userRegistrationData.getSpecial_category().equals("0")) {
				obj.setSpecial_category(Integer
						.parseInt(jpaSavePersonalDetailsInterface.fetchBenchmarkdisabilityIdfromBenchmarkdisabilityName(
								userRegistrationData.getSpecial_category())));

			}

			obj.setDegree_of_dis(userRegistrationData.getDegree_of_dis());
			obj.setPermanent_address(userRegistrationData.getPermanent_address().toUpperCase());
			obj.setCountry(userRegistrationData.getCountry());
			obj.setState(jpaSavePersonalDetailsInterface.fetchStateIdfromStateName(userRegistrationData.getState()));
			obj.setDistrict(jpaSavePersonalDetailsInterface.fetchDistrictIdfromDistrictName(
					userRegistrationData.getDistrict(), Integer.parseInt(obj.getState())));
			obj.setPincode(userRegistrationData.getPincode());
			obj.setPassword(password);

			jpaSavePersonalDetailsInterface.save(obj);

			for (String elements : userRegistrationData.getSpecial_category_sub_category()) {
				UserRegistrationDataSpecialCategory objspecialcategory = new UserRegistrationDataSpecialCategory();
				objspecialcategory.setEmployeeid(obj.getEmployeeid());
				objspecialcategory.setSpecialcategoryid(jpaSavePersonalDetailsInterface
						.fetchBenchmarkdisabilitysubcategoryidfromname(elements, obj.getSpecial_category()));
				jpaSavePersonalDetailsSpecialCategory.save(objspecialcategory);
			}
			return 200;
		} catch (Exception e) {
			System.out.println(" Error " + e);
			return 500;
		}

	}

	@Override
	public List<String> fetchDistrict(String statename) {
		return jpaSavePersonalDetailsInterface.fetchDistrict(statename);

	}

	@Override
	public List<String> fetchState() {
		return jpaSavePersonalDetailsInterface.fetchState();

	}

	@Override
	public String generateOTP(String mobilenumber) throws IOException {

		Random random = new Random();
		String otp = String.format("%06d", random.nextInt(1000000));
		StringBuffer otpstringbuffer = new StringBuffer(otp);

		if (otpstringbuffer.charAt(0) == '0') {
			otpstringbuffer.replace(0, 1, "7");
		}

		String sucess = "";
		String SenderName = "NSOFTI";
		String Password = "A0386ca7ec69a504c32f5bdd1125c6567";
		String Mobileno = mobilenumber;

		String message = "You have successfully generated OTP for registration process. Your OTP is " + otpstringbuffer
				+ ". Do not share this OTP with anyone to avoid misuse of your account.OTP valid for 1 min.--APSC";

		String MessageUrl = "https://bulksmsapi.vispl.in/?username=cscotpapi&password=cscotpapi@123&messageType=text&mobile="
				+ Mobileno
				+ "&senderId=APSCRC&ContentID=1707160762003315515&EntityID=1301157363501533886&message=You have successfully generated OTP for registration process. Your OTP is "
				+ otpstringbuffer
				+ ". Do not share this OTP with anyone to avoid misuse of your account.OTP valid for 1 mins.--APSC";

		try {

			URLConnection myURLConnection = null;
			URL myURL = null;
			BufferedReader reader = null;

			// encoding message
			String encoded_message = URLEncoder.encode(message);
			try {
				MessageUrl = MessageUrl.replace(" ", "%20");
				// prepare connection

				reader = new BufferedReader(new InputStreamReader(
						((HttpURLConnection) (new URL(MessageUrl)).openConnection()).getInputStream(),
						Charset.forName("UTF-8")));

				String response;
				while ((response = reader.readLine()) != null)
					// print response
					// LoggerClass.OtherLogDetails(response);

					// finally close connection
					reader.close();
			} catch (IOException ex) {
				// e.WriteintoFile(ex, 10, "Tester");
				// LoggerClass.WriteintoFile(ex, 1, null);
				ex.printStackTrace();
			}
			sucess = "success";

		} catch (Exception ex) {
		}
		return otpstringbuffer.toString();
	}

	@Override
	public int saveEducationalDetails(EducationalQualifications educationalQualifications) {
		for (Schoolingdetails details : educationalQualifications.getSchoolingdetails()) {
			jpaSaveEducationalSchoolingDetails.save(details);
		}
		for (UnderGradutionDetails details : educationalQualifications.getUndergraduationdetails()) {
			jpaSaveEducationalUndergraduationDetails.save(details);
		}
		for (PostGraduationDetails details : educationalQualifications.getPostgraduation()) {
			jpaSaveEducationalPostgraduationDetails.save(details);
		}
		for (OtherQualificationDetails details : educationalQualifications.getOtherqualification()) {
			jpaSaveEducationalOtherQualificationsDetails.save(details);
		}
		for (ResearchPapersDetails details : educationalQualifications.getResearchpapers()) {
			jpaSaveEducationalResearchPaperDetails.save(details);
		}
		return 0;
	}

	@Override
	public int saveWorkExperience(WorkExperience workexperience) {
		for (Workexperiences details : workexperience.getWorkexperience()) {
			jpaSaveWorkExperienceDetails.save(details);
		}
		return 0;
	}

	@Override
	public JSONObject loginVerification(String emailid, String password) {

//		logger.info("log4j is work");
		JSONObject obj = new JSONObject();

		UserRegistrationData res;

		int temp = 1;
		for (int i = 0; i < emailid.length(); i++) {

			if (emailid.charAt(i) == '@') {
				temp = 1;
				break;
			} else {
				temp = 0;
			}
		}

		if (temp == 1) {
			res = jpaSavePersonalDetailsInterface.findByEmail(emailid);
		} else {
			res = jpaSavePersonalDetailsInterface.findByMobile(emailid);
		}

		if (res == null) {
			obj.put("employeeid", null);
			return obj;
		} else {

			if (res.getPassword() == null) {
				obj.put("employeeid", "Passwordnull");
				{
					return obj;
				}
			}
			String decrptedpassword = encryptanddecrypt.decrypt(res.getPassword());
			if (password.equals(decrptedpassword)) {
				obj.put("employeeid", res.getEmployeeid());
				obj.put("otrstatus", res.isOtrfinished());
				obj.put("fullname", res.getFull_name());
				obj.put("emailid", res.getEmail());
				obj.put("phonenumber", res.getMobile());
				return obj;
			} else {
				obj.put("employeeid", "0");
				return obj;
			}

		}
	}

	@Override
	public UserRegistrationDataInput fetchPersonalDetails(Integer employeeid) {

		UserRegistrationData fetcheduserregistrationdate = jpaSavePersonalDetailsInterface.findByemployeeid(employeeid);

		UserRegistrationDataInput obj = new UserRegistrationDataInput();

		obj.setFull_name(fetcheduserregistrationdate.getFull_name());
		obj.setFathers_name(fetcheduserregistrationdate.getFathers_name());
		obj.setMothers_name(fetcheduserregistrationdate.getMothers_name());
		obj.setGender(fetcheduserregistrationdate.getGender());
		obj.setD_o_b(fetcheduserregistrationdate.getD_o_b());
		obj.setMobile(fetcheduserregistrationdate.getMobile());
		obj.setAlternative_Mobie_number(fetcheduserregistrationdate.getAlternative_Mobie_number());
		obj.setEmail(fetcheduserregistrationdate.getEmail());
		obj.setNationality(fetcheduserregistrationdate.getNationality());
		obj.setPermanent_resident_of_assam(fetcheduserregistrationdate.getPermanent_resident_of_assam());
		obj.setCaste(jpaSavePersonalDetailsInterface.fetchCasteNamefromCasteId(fetcheduserregistrationdate.getCaste()));

		int nullornot = fetcheduserregistrationdate.getSpecial_category();

		if (nullornot != 0) {
			obj.setSpecial_category(
					jpaSavePersonalDetailsInterface.fetchBenchMarkdisabilityNamefromBenchMarkdisabilityId(
							fetcheduserregistrationdate.getSpecial_category()));

			int[] specialcategory_subcategory = jpaSavePersonalDetailsSpecialCategory
					.fetchspecailcategoryidfromemployeeid(employeeid);
			String specialcategory_sub[] = new String[specialcategory_subcategory.length];
			for (int i = 0; i < specialcategory_subcategory.length; i++) {
				specialcategory_sub[i] = jpaSavePersonalDetailsInterface
						.fetchBenchMarkdisabilitySubcategoryNamefromBenchMarkdisabilitysubcategoryId(
								specialcategory_subcategory[i]);

			}
			obj.setSpecial_category_sub_category(specialcategory_sub);
		}
		obj.setDegree_of_dis(fetcheduserregistrationdate.getDegree_of_dis());
		obj.setPermanent_address(fetcheduserregistrationdate.getPermanent_address());
		obj.setCountry(fetcheduserregistrationdate.getCountry());
		obj.setState(jpaSavePersonalDetailsInterface.fetchStateNamefromStateId(fetcheduserregistrationdate.getState()));
		obj.setDistrict(jpaSavePersonalDetailsInterface
				.fetchDistrictNamefromDistrictId(fetcheduserregistrationdate.getDistrict()));

		try {

			obj.setPhoto(getByteArrayFromImageURL(fetcheduserregistrationdate.getPhoto()));
			obj.setSignature(getByteArrayFromImageURL(fetcheduserregistrationdate.getSignature()));
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obj.setOtrfinished(fetcheduserregistrationdate.isOtrfinished());

		obj.setPincode(fetcheduserregistrationdate.getPincode());
		return obj;
	}

	@Override
	public String updateUserPersonalDetails(UserRegistrationDataInput userRegistrationData) {
		try {

			UserRegistrationData obj = jpaSavePersonalDetailsInterface.getById(userRegistrationData.getEmployeeid());
			obj.setEmployeeid(userRegistrationData.getEmployeeid());
			obj.setFathers_name(userRegistrationData.getFathers_name().toUpperCase());
			obj.setMothers_name(userRegistrationData.getMothers_name().toUpperCase());
			obj.setGender(userRegistrationData.getGender());
			obj.setD_o_b(userRegistrationData.getD_o_b());
			obj.setAlternative_Mobie_number(userRegistrationData.getAlternative_Mobie_number());
			obj.setPermanent_resident_of_assam(userRegistrationData.getPermanent_resident_of_assam());
			obj.setCaste(jpaSavePersonalDetailsInterface.fetchCasteIdfromCasteName(userRegistrationData.getCaste()));

			if (userRegistrationData.getSpecial_category().equals("no")) {
				obj.setSpecial_category(0);
			} else {
				obj.setSpecial_category(Integer
						.parseInt(jpaSavePersonalDetailsInterface.fetchBenchmarkdisabilityIdfromBenchmarkdisabilityName(
								userRegistrationData.getSpecial_category())));
			}

			obj.setDegree_of_dis(userRegistrationData.getDegree_of_dis());
			obj.setPermanent_address(userRegistrationData.getPermanent_address().toUpperCase());
			obj.setState(jpaSavePersonalDetailsInterface.fetchStateIdfromStateName(userRegistrationData.getState()));
			obj.setDistrict(jpaSavePersonalDetailsInterface.fetchDistrictIdfromDistrictName(
					userRegistrationData.getDistrict(), Integer.parseInt(obj.getState())));
			obj.setPincode(userRegistrationData.getPincode());

			jpaSavePersonalDetailsInterface.save(obj);

			try {
				jpaSavePersonalDetailsInterface.deleteemployeeidinbenchmarkdisabilitysubacategory(obj.getEmployeeid());
			} catch (Exception e) {

			}

			for (String elements : userRegistrationData.getSpecial_category_sub_category()) {
				UserRegistrationDataSpecialCategory objspecialcategory = new UserRegistrationDataSpecialCategory();
				objspecialcategory.setEmployeeid(obj.getEmployeeid());
				objspecialcategory.setSpecialcategoryid(jpaSavePersonalDetailsInterface
						.fetchBenchmarkdisabilitysubcategoryidfromname(elements, obj.getSpecial_category()));
				jpaSavePersonalDetailsSpecialCategory.save(objspecialcategory);
			}
			return "200";
		} catch (Exception e) {
			return "500";
		}
	}
//
//	@Override
//	public void savePhotoandSignature(String employeeid, String photoFile, String signatureFile)
//			throws Exception {
//
//		String[] temp = employeeid.split(",");
//		employeeid = temp[0];
//		String folder = "D:/APSC/PHOTOANDSIGNATURE/" + employeeid + "/";
//		File file = new File(folder);
//
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//
//		byte[] bytes = photoFile.getBytes();
//		String profilefilename = folder + employeeid + "_profileimage.jpg";
//		Path path = Paths.get(profilefilename);
//		Files.write(path, bytes);
//		byte[] bytes1 = signatureFile.getBytes();
//		String signfilename = folder + employeeid + "_signimage.jpg";
//		Path path1 = Paths.get(signfilename);
//		Files.write(path1, bytes1);
//
//		UserRegistrationData userRegistrationData = jpaSavePersonalDetailsInterface
//				.getById(Integer.parseInt(employeeid));
//
//		userRegistrationData.setPhoto(profilefilename);
//		userRegistrationData.setSignature(signfilename);
//
//		jpaSavePersonalDetailsInterface.save(userRegistrationData);
//
//		folder = null;
//
//	}

	@Override
	public void savePhotoandSignature(String employeeid, String photoFile, String signatureFile) throws Exception {

//		String[] temp = employeeid.split(",");
//		employeeid = temp[0];

		System.out.println(" Inside Service ");

		System.out.println(" PHOTO FILE " + photoFile);

		String updatedstring = photoFile.replaceAll(" ", "+");
		String updtedstring1 = signatureFile.replaceAll(" ", "+");

		System.out.println(" UPDATED STRING  " + updatedstring.toString());

		System.out.println(" SIGNATURE FILE " + signatureFile);

		String folder = "D:/APSC/PHOTOANDSIGNATURE/" + employeeid + "/";
		File file = new File(folder);

		if (!file.exists()) {
			file.mkdirs();
		}

		String profilefilename = folder + employeeid + "_profileimage.jpg";
		File file1 = new File(profilefilename);
		try (FileOutputStream fos = new FileOutputStream(file1);) {

			String[] decrypt = updatedstring.split(",");
			byte[] decoder = Base64.getDecoder().decode(decrypt[1]);
			fos.write(decoder);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String signaturefilename = folder + employeeid + "_signimage.jpg";
		File file2 = new File(signaturefilename);
		try (FileOutputStream fos = new FileOutputStream(file2);) {

			String[] decrypt = updtedstring1.split(",");
			byte[] decoder = Base64.getDecoder().decode(decrypt[1]);

			fos.write(decoder);
		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRegistrationData userRegistrationData = jpaSavePersonalDetailsInterface
				.getById(Integer.parseInt(employeeid));

		userRegistrationData.setPhoto(profilefilename);
		userRegistrationData.setSignature(signaturefilename);

		jpaSavePersonalDetailsInterface.save(userRegistrationData);

		System.out.println(" Succesfully Saved ");

		folder = null;
	}

	@Override
	public String saveDocuments(OTRdocuments details) throws IOException {

		int employeeid = 0;

		for (DocumentUpload obj : details.getDetails()) {

			employeeid = obj.getEmployeeid();
			String folder = "D:/APSC/DOCUMENT/" + employeeid + "/";
			File files = new File(folder);

			if (!files.exists()) {
				files.mkdirs();
			}

			String documentname = obj.getDocumenttype();
			String updateddocuemntname = documentname.replace('/', '-');

			String constructFilePath = folder + obj.getEmployeeid() + "_" + updateddocuemntname + ".pdf";

			File file = new File(constructFilePath);

			try (FileOutputStream fos = new FileOutputStream(file);) {

				String[] decrypt = obj.getDocument().split(",");
				byte[] decoder = Base64.getDecoder().decode(decrypt[1]);

				fos.write(decoder);
				long lengthOfFile = file.length();
				System.out.println(" Length of File " + lengthOfFile);
				obj.setDocument(constructFilePath);
			} catch (Exception e) {

				e.printStackTrace();

			}

			jpaSaveDocuments.save(obj);

		}

		UserRegistrationData obj = jpaSavePersonalDetailsInterface.getById(employeeid);
		obj.setOtrfinished(true);
		jpaSavePersonalDetailsInterface.save(obj);

		return null;
	}

	@Override
	public String generateCaptcha() {
		char data[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9' };
		StringBuffer captcha = new StringBuffer();
		Random r = new Random();
		for (int i = 0; i < 7; i++) {
			int ran = r.nextInt(data.length);
			captcha.append(data[ran]);
		}
		return captcha.toString();

	}

	@Override
	public EducationalQualifications fetchEducationalDetails(String employeeid) {

		Schoolingdetails schoolingDetails[] = jpaSaveEducationalSchoolingDetails
				.fetchDetails(Integer.parseInt(employeeid));
		UnderGradutionDetails underGraduationDetails[] = jpaSaveEducationalUndergraduationDetails
				.fetchDetails(Integer.parseInt(employeeid));
		PostGraduationDetails postGraduationDetails[] = jpaSaveEducationalPostgraduationDetails
				.fetchDetails(Integer.parseInt(employeeid));
		OtherQualificationDetails otherQualificationDetails[] = jpaSaveEducationalOtherQualificationsDetails
				.fetchDetails(Integer.parseInt(employeeid));
		ResearchPapersDetails researchPapersDetails[] = jpaSaveEducationalResearchPaperDetails
				.fetchDetails(Integer.parseInt(employeeid));

		EducationalQualifications educationalQulifications = new EducationalQualifications();
		educationalQulifications.setSchoolingdetails(schoolingDetails);
		educationalQulifications.setUndergraduationdetails(underGraduationDetails);
		educationalQulifications.setPostgraduation(postGraduationDetails);
		educationalQulifications.setOtherqualification(otherQualificationDetails);
		educationalQulifications.setResearchpapers(researchPapersDetails);

		return educationalQulifications;
	}

	@Override
	public WorkExperience fetchWorkExpeience(String employeeid) {

		Workexperiences workexperiencesresult[] = jpaSaveWorkExperienceDetails
				.fetchDetails(Integer.parseInt(employeeid));
		WorkExperience workexperienceobject = new WorkExperience();
		workexperienceobject.setWorkexperience(workexperiencesresult);
		return workexperienceobject;
	}

	@Override
	public UserRegistrationData fetchPhotoandSignature(String employeeid) throws IOException {

		UserRegistrationData personalDetails = jpaSavePersonalDetailsInterface
				.fetchDetails(Integer.parseInt(employeeid));

		personalDetails.setPhoto(getByteArrayFromImageURL(personalDetails.getPhoto()));
		personalDetails.setSignature(getByteArrayFromImageURL(personalDetails.getSignature()));
		return personalDetails;
	}

	@Override
	public String fetchOldPassword(String employeeid) {

		UserRegistrationData userRegistrationdata = jpaSavePersonalDetailsInterface
				.getById(Integer.parseInt(employeeid));

		String oldpassword = encryptanddecrypt.decrypt(userRegistrationdata.getPassword());
		return oldpassword;

	}

	@Override
	public String setNewPassword(String employeeid, String newpassword) {

		try {
			UserRegistrationData userRegistrationdata = jpaSavePersonalDetailsInterface
					.getById(Integer.parseInt(employeeid));
			String newencryptespassword = encryptanddecrypt.encrypt(newpassword);
			userRegistrationdata.setPassword(newencryptespassword);
			jpaSavePersonalDetailsInterface.save(userRegistrationdata);
			return "success";
		} catch (Exception e) {
			return "failed";
		}

	}

	@Override
	public ProfileData fetchAllData(String employeeid) {

		UserRegistrationDataInput personalDetails = fetchPersonalDetails(Integer.parseInt(employeeid));
		Schoolingdetails[] schoolingdetails = jpaSaveEducationalSchoolingDetails
				.fetchDetails(Integer.parseInt(employeeid));

		UnderGradutionDetails[] undergraduationDetails = jpaSaveEducationalUndergraduationDetails
				.fetchDetails(Integer.parseInt(employeeid));

		PostGraduationDetails[] postgraduationDetails = jpaSaveEducationalPostgraduationDetails
				.fetchDetails(Integer.parseInt(employeeid));

		OtherQualificationDetails[] otherqulificatinsDetails = jpaSaveEducationalOtherQualificationsDetails
				.fetchDetails(Integer.parseInt(employeeid));

		ResearchPapersDetails[] researchpaperDetails = jpaSaveEducationalResearchPaperDetails
				.fetchDetails(Integer.parseInt(employeeid));

		Workexperiences[] personworkexperience = jpaSaveWorkExperienceDetails
				.fetchDetails(Integer.parseInt(employeeid));

		DocumentUpload[] documentupload = jpaSaveDocuments.fetchDetails(Integer.parseInt(employeeid));

		ProfileData fullProfileData = new ProfileData();

		EducationalQualifications educationalqualifications = new EducationalQualifications();

		educationalqualifications.setSchoolingdetails(schoolingdetails);
		educationalqualifications.setUndergraduationdetails(undergraduationDetails);
		educationalqualifications.setPostgraduation(postgraduationDetails);
		educationalqualifications.setOtherqualification(otherqulificatinsDetails);
		educationalqualifications.setResearchpapers(researchpaperDetails);

		fullProfileData.setPersonaldetails(personalDetails);
		fullProfileData.setEducationalqualifications(educationalqualifications);

		WorkExperience wrks = new WorkExperience();
		wrks.setWorkexperience(personworkexperience);
		fullProfileData.setProfileworkexperience(wrks);
		OTRdocuments otrdoucments = new OTRdocuments();
		otrdoucments.setDetails(documentupload);
		fullProfileData.setOtrdocuments(otrdoucments);
		return fullProfileData;
	}

	@Override
	public boolean[] fetchemailandphonenumber(String email, String phonenumber) {

		boolean result[] = new boolean[2];

		if (this.jpaSavePersonalDetailsInterface.findByEmail(email) != null) {
			result[0] = true;
		} else {
			result[0] = false;
		}
		if (this.jpaSavePersonalDetailsInterface.findByMobile(phonenumber) != null) {
			result[1] = true;
		} else {
			result[1] = false;
		}
		return result;
	}

	@Override
	public String getByteArrayFromImageURL(String url) throws IOException {

		String base64image = "";
		File file = new File(url);

		try (FileInputStream imageInFile = new FileInputStream(file)) {
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64image = Base64.getEncoder().encodeToString(imageData);
			return base64image;
		} catch (Exception e) {
			return e.toString();
		}

	}

	@Override
	public List<String> fetchUGdetails() {
		return jpaSavePersonalDetailsInterface.fetchUGDetails();
	}

	@Override
	public List<String> fetchPGdetails() {

		return jpaSavePersonalDetailsInterface.fetchPGDetails();
	}

	@Override
	public List<String> fetchDiplomaDetails() {

		return jpaSavePersonalDetailsInterface.fetchDiplomaDetails();
	}

	@Override
	public List<String> fetchCaste() {
		return jpaSavePersonalDetailsInterface.fetchCaste();
	}

	@Override
	public List<String> fetchBenchmarkCategory() {
		return jpaSavePersonalDetailsInterface.fetchBenchmarkCategory();
	}

	@Override
	public List<PostMasterInterface> fetchpost(String employeeid) {

		List<PostMasterInterface> result = new ArrayList<PostMasterInterface>();
		result = storedProcedureReposistory.Candidate_DashBoard(Integer.parseInt(employeeid));
		return result;
	}

	@Override
	public List<ExaminationZoneInterface> fetchExaminationZone(int postid) {

		List<ExaminationZoneInterface> examinationzones = new ArrayList<ExaminationZoneInterface>();
		examinationzones = storedProcedureReposistory.Examinationzoneforapplypost(postid);
		return examinationzones;
	}

	@Override
	public List<AdvertistmentInterface> fetchAllPost() {
		return storedProcedureReposistory.whatsnew();
	}

	@Override
	public List<EducationalQualificationforPostInterface> fetchEducationalqualificationattributes(int postid) {
		return storedProcedureReposistory.EducationalQualification(postid);

	}

	@Override
	public List<DocumentUploadforPost> fetchDocumentuploadforPost(int postid) {
		return storedProcedureReposistory.DocumentUploadforPost(postid);
	}

	@Override
	public List<WorkExperienceforPost> fetchWorkexperienceforPost(int postid) {
		return storedProcedureReposistory.WorkExperienceforPost(postid);
	}

	public String saveDocuents(String base64string, String postid, String employeeid, int nooffiles, String type) {

		String folder = "D:/APSC/APPLYPOSTDOCUMENTS/" + employeeid + "/";
		File files = new File(folder);

		if (!files.exists()) {
			files.mkdirs();
		}

		String subfolder = folder + postid + "/";

		File files1 = new File(subfolder);

		if (!files1.exists()) {
			files1.mkdir();
		}

		String constructFilePath = subfolder + employeeid + "_Apply_post_doc " + type + "_" + nooffiles + ".pdf";

		File file = new File(constructFilePath);
		try (FileOutputStream fos = new FileOutputStream(file);) {

			byte[] decoder = Base64.getDecoder().decode(base64string);
			fos.write(decoder);
			return constructFilePath;
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	@Transactional
	@Override
	public String savepersonaldetailsforapplypost(ApplyPost detailsforapplypost) throws IOException {

		int i = 0;
		int j = 0;
		int k = 0;
		int temp = 1;

		ApplyPostUserData applypostuserdata = null;
		int employeeid = Integer.parseInt(detailsforapplypost.getPersonaldetails().getEmployeeid());
		int postid = Integer.parseInt(detailsforapplypost.getPersonaldetails().getPostid());
		if (jpaSavePersonalDetailsforApplyPost.takeCount(employeeid, postid) == 0
				&& jpaSaveEducationalDetailsforPost.takeCount(employeeid, postid) == 0
				&& jpaSaveDynamicOptionsforApplyPOst.takeCount(employeeid, postid) == 0
				&& jpaSaveWorkexperienceforApplyPost.takeCount(employeeid, postid) == 0
				&& jpaSaveDocumentsforApplypost.takeCount(employeeid, postid) == 0
				&& jpaSaveApplypostFinalData.takeCount(employeeid, postid) == 0) {

			// try {

			applypostuserdata = detailsforapplypost.getPersonaldetails();
			jpaSavePersonalDetailsforApplyPost.save(applypostuserdata);

			for (ApplyPostWorkExperienceDetails elements : detailsforapplypost.getWorkexperiences()) {
				String[] docs = elements.getDocumentupload().split(",");
				elements.setDocumentupload(
						saveDocuents(docs[1], elements.getPostid(), elements.getEmployeeid(), ++i, "WorkExperience"));
				jpaSaveWorkexperienceforApplyPost.save(elements); // 2 Table
			}

			for (ApplyPostDynamicOptions elements : detailsforapplypost.getDynamicoptionsarray()) {
				jpaSaveDynamicOptionsforApplyPOst.save(elements); // 3 Table
			}

			for (ApplyPostEducationalQualification elements : detailsforapplypost.getEducationqualification()) {

				String[] docs = elements.getDocumentupload().split(",");
				elements.setDocumentupload((saveDocuents(docs[1], elements.getPostid(), elements.getEmployeeid(), ++j,
						"EducQualification")));
				jpaSaveEducationalDetailsforPost.save(elements); // 4 Table
			}

			for (ApplyPostDocumentUpload elements : detailsforapplypost.getDocumentupload()) {

				String[] docs = elements.getFilelocation().split(",");
				elements.setFilelocation(
						(saveDocuents(docs[1], elements.getPostid(), elements.getEmployeeid(), ++k, "Documents")));
				jpaSaveDocumentsforApplypost.save(elements); // 5 Table
			}

			ApplyPostFinalData apsfinal = new ApplyPostFinalData();
			String applicationumber = "DRAPP20012022" + applypostuserdata.getEmployeeid()
					+ applypostuserdata.getPostid();
			apsfinal.setEmployeeid(Integer.parseInt(applypostuserdata.getEmployeeid()));
			apsfinal.setApplicationid(applicationumber);
			apsfinal.setPostid(Integer.parseInt(applypostuserdata.getPostid()));
			apsfinal.setPostname(applypostuserdata.getPostname());
			apsfinal.setPaymentstatus("Unpaid");

			jpaSaveApplypostFinalData.save(apsfinal); // 6 Table

			OldPaymentDetails obj = new OldPaymentDetails();
			obj.setEmployeeid(apsfinal.getEmployeeid());
			obj.setPostid(apsfinal.getPostid());
			obj.setBooleanforoldpayment(detailsforapplypost.getPreviouspayment());
			obj.setOldGRNnumber(detailsforapplypost.getGrnnumber());

			oldPaymentDetailsReposistory.save(obj);

			if (temp == 1) {
				return "Success".toString();
			} else {
				return "Pending".toString();
			}

			// } catch (DataIntegrityViolationException e) {

			// System.out.println(" Inside Exception ");

			// System.out.println(" Exception : " + e);

//				storedProcedureReposistory.DeleteApplicationForm(Integer.parseInt(applypostuserdata.getPostid()),
//					Integer.parseInt(applypostuserdata.getEmployeeid()));

//				if (jpaSavePersonalDetailsforApplyPost.takeCount(employeeid, postid) != 0) {
//					jpaSavePersonalDetailsforApplyPost.deletefromapplypostuserdata(
//							Integer.parseInt(applypostuserdata.getEmployeeid()),
//							Integer.parseInt(applypostuserdata.getPostid()));
//				}
//
//				if (jpaSaveEducationalDetailsforPost.takeCount(employeeid, postid) != 0) {
//					jpaSaveEducationalDetailsforPost.deletefromapplyposteducationdetails(
//							Integer.parseInt(applypostuserdata.getEmployeeid()),
//							Integer.parseInt(applypostuserdata.getPostid()));
//				}
//				if (jpaSaveDynamicOptionsforApplyPOst.takeCount(employeeid, postid) != 0) {
//					jpaSaveDynamicOptionsforApplyPOst.deletedynamicoptionfromapplypost(
//							Integer.parseInt(applypostuserdata.getEmployeeid()),
//							Integer.parseInt(applypostuserdata.getPostid()));
//				}
//				if (jpaSaveWorkexperienceforApplyPost.takeCount(employeeid, postid) != 0) {
//					jpaSaveWorkexperienceforApplyPost.deleteworkexperiencefromapplypost(
//							Integer.parseInt(applypostuserdata.getEmployeeid()),
//							Integer.parseInt(applypostuserdata.getPostid()));
//				}
//				if (jpaSaveDocumentsforApplypost.takeCount(employeeid, postid) != 0) {
//					jpaSaveDocumentsforApplypost.deletedocumentfromapplypost(
//							Integer.parseInt(applypostuserdata.getEmployeeid()),
//							Integer.parseInt(applypostuserdata.getPostid()));
//				}
//				if (jpaSaveApplypostFinalData.takeCount(employeeid, postid) != 0) {
//					jpaSaveApplypostFinalData.deletefromapplypostfinaldata(
//							Integer.parseInt(applypostuserdata.getEmployeeid()),
//							Integer.parseInt(applypostuserdata.getPostid()));
//				}
			// return "Pending".toString();

			// }

		} else {
			System.out.println(" Inside Else ");
			return "Failure".toString();
		}

	}

	@Override
	public List<String> fetchBenchmarkCategorySubCategory(String categoryselected) {
		return jpaSavePersonalDetailsInterface
				.fetchBenchmarkdisabilitySubcategory(Integer.parseInt(jpaSavePersonalDetailsInterface
						.fetchBenchmarkdisabilityIdfromBenchmarkdisabilityName(categoryselected)));
	}

	@Override
	public int fetchcastefordocument(String employeeid) {

		UserRegistrationData personalDetails = jpaSavePersonalDetailsInterface
				.fetchDetails(Integer.parseInt(employeeid));
		return Integer.parseInt(personalDetails.getCaste());
	}

	@Override
	public List<EducationalQualificationforPostInterface1> fetchEducationalqualificationattributesforflagone(int postid,
			String[] selectedvalues) {

		System.out.println(" POST ID  " + postid);

		String output = "";
		for (int i = 0; i < selectedvalues.length; i++) {
			output += selectedvalues[i] + ",";
			System.out.println(" SELECTED VALUES ARRAY " + selectedvalues[i]);
		}
		System.out.println(" OUTPUT  " + output);
		return storedProcedureReposistory.EducationalQualification1(postid, output);
	}

	@Override
	public ApplyPostFinalData[] fetchActivitySeaction(String employeeid) {
		return jpaSaveApplypostFinalData.fetchActivitySeaction(Integer.parseInt(employeeid));
	}

	@Override
	public DownloadDetails finaldownloaddetails(String employeeid, String postid) {

		UserRegistrationDataInput personalDetails = fetchPersonalDetails(Integer.parseInt(employeeid));

		Schoolingdetails[] schoolingdetails = jpaSaveEducationalSchoolingDetails
				.fetchDetails(Integer.parseInt(employeeid));

		UnderGradutionDetails[] undergraduationDetails = jpaSaveEducationalUndergraduationDetails
				.fetchDetails(Integer.parseInt(employeeid));

		PostGraduationDetails[] postgraduationDetails = jpaSaveEducationalPostgraduationDetails
				.fetchDetails(Integer.parseInt(employeeid));

		OtherQualificationDetails[] otherqulificatinsDetails = jpaSaveEducationalOtherQualificationsDetails
				.fetchDetails(Integer.parseInt(employeeid));

		ResearchPapersDetails[] researchpaperDetails = jpaSaveEducationalResearchPaperDetails
				.fetchDetails(Integer.parseInt(employeeid));

		Workexperiences[] personworkexperience = jpaSaveWorkExperienceDetails
				.fetchDetails(Integer.parseInt(employeeid));

		DocumentUpload[] documentupload = jpaSaveDocuments.fetchDetails(Integer.parseInt(employeeid));

		DownloadDetails fullProfileData = new DownloadDetails();

		EducationalQualifications educationalqualifications = new EducationalQualifications();

		educationalqualifications.setSchoolingdetails(schoolingdetails);
		educationalqualifications.setUndergraduationdetails(undergraduationDetails);
		educationalqualifications.setPostgraduation(postgraduationDetails);
		educationalqualifications.setOtherqualification(otherqulificatinsDetails);
		educationalqualifications.setResearchpapers(researchpaperDetails);

		fullProfileData.setPersonaldetails(personalDetails);
		fullProfileData.setEducationalqualifications(educationalqualifications);

		WorkExperience wrks = new WorkExperience();
		wrks.setWorkexperience(personworkexperience);
		fullProfileData.setProfileworkexperience(wrks);

		OTRdocuments otrdoucments = new OTRdocuments();
		otrdoucments.setDetails(documentupload);
		fullProfileData.setOtrdocuments(otrdoucments);

		OldPaymentDetails oldPaymentDetailsObj = oldPaymentDetailsReposistory
				.fetchOldPaymentDetails(Integer.parseInt(employeeid), Integer.parseInt(postid));

		ApplyPost applypost = new ApplyPost();
		applypost.setPersonaldetails(personaldetailsforapplypost.fetchapplypostuserdata(Integer.parseInt(employeeid),
				Integer.parseInt(postid)));
		applypost.setEducationqualification(jpaSaveEducationalDetailsforPost
				.fetchapplyposteducationdetails(Integer.parseInt(employeeid), Integer.parseInt(postid)));
		applypost.setWorkexperiences(jpaSaveWorkexperienceforApplyPost
				.fetchapplypostworkexperiencedetails(Integer.parseInt(employeeid), Integer.parseInt(postid)));
		applypost.setDynamicoptionsarray(jpaSaveDynamicOptionsforApplyPOst
				.fetchapplypostdynamicoptions(Integer.parseInt(employeeid), Integer.parseInt(postid)));
		applypost.setDocumentupload(jpaSaveDocumentsforApplypost
				.fetchapplypostdocumentupload(Integer.parseInt(employeeid), Integer.parseInt(postid)));
		fullProfileData.setApplypost(applypost);

		fullProfileData.setApplypostfinaldata(jpaSaveApplypostFinalData
				.fetchapplypostfinaldata(Integer.parseInt(employeeid), Integer.parseInt(postid)));

		fullProfileData.setOldpaymentdetails(oldPaymentDetailsObj);

		return fullProfileData;
	}

	@Override
	public PayementModuleInterface fetchpaymentdetails(String postid, String employeeid) {
		return storedProcedureReposistory.PaymentDetailsforPost(Integer.parseInt(postid), Integer.parseInt(employeeid));
	}

	@Override
	public void cancelApplication(String postid, String employeeid, String otp) {

		System.out.println(" Cancel Application ");

		ApplyPostFinalData obj = jpaSaveApplypostFinalData.fetchapplypostfinaldata(Integer.parseInt(employeeid),
				Integer.parseInt(postid));
		UserRegistrationData basicobj = jpaSavePersonalDetailsInterface.getById(Integer.parseInt(employeeid));
		ApplyPostUserData applypostuserdata = jpaSavePersonalDetailsforApplyPost
				.fetchapplypostuserdata(Integer.parseInt(employeeid), Integer.parseInt(postid));

		String postname = applypostuserdata.getAdvtno();
		String applicationId = obj.getApplicationid();
		String message = "You have successfully cancelled your application for " + postname
				+ " bearing application id is " + applicationId + ".--APSC";
		String MessageUrl = "https://bulksmsapi.vispl.in/?username=cscotpapi&password=cscotpapi@123&messageType=text&mobile="
				+ basicobj.getMobile()
				+ "&senderId=APSCRC&ContentID=1707160762038025073&EntityID=1301157363501533886&message=" + message;

		try {
			URLConnection myURLConnection = null;
			URL myURL = null;
			BufferedReader reader = null;
			String encoded_message = URLEncoder.encode(message);
			try {
				MessageUrl = MessageUrl.replace(" ", "%20");
				reader = new BufferedReader(new InputStreamReader(
						((HttpURLConnection) (new URL(MessageUrl)).openConnection()).getInputStream(),
						Charset.forName("UTF-8")));
				String response;
				while ((response = reader.readLine()) != null)
					System.out.println(response);

				OtpSavedTable tempObj = new OtpSavedTable();
				tempObj.setEmployeeid(Integer.parseInt(employeeid));
				tempObj.setPostid(Integer.parseInt(postid));
				tempObj.setOtp(Integer.parseInt(otp));

				otpSavedReposistory.save(tempObj);

				storedProcedureReposistory.DeleteApplicationForm(Integer.parseInt(postid),
						Integer.parseInt(employeeid));

				reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			// sucess = "success";

		} catch (Exception ex) {
		}

	}

	@Override
	public void deleteEducationqualifiication(String slnoftable, String tablename) {
		if (tablename == "school") {
			jpaSaveEducationalSchoolingDetails.deleteById(Integer.parseInt(slnoftable));
		}
		if (tablename.equals("graduation")) {
			jpaSaveEducationalUndergraduationDetails.deleteById(Integer.parseInt(slnoftable));
			System.out.println(" Deleted ");
		}
		if (tablename.equals("postGraduation")) {
			jpaSaveEducationalPostgraduationDetails.deleteById(Integer.parseInt(slnoftable));
		}

		if (tablename.equals("others")) {
			jpaSaveEducationalOtherQualificationsDetails.deleteById(Integer.parseInt(slnoftable));
		}

		if (tablename.equals("research")) {
			jpaSaveEducationalResearchPaperDetails.deleteById(Integer.parseInt(slnoftable));
		}

		if (tablename.equals("work")) {
			jpaSaveWorkExperienceDetails.deleteById(Integer.parseInt(slnoftable));
		}

	}

	@Override
	public void generatePassword(String mobileno) {

		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi" + "jklmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		String message = "Your request for resetting the password has been done. Please login to your account using the given credentials,UserId: "
				+ mobileno + ",Password: " + sb + ",APSC";
		String MessageBody = message;
		String MessageUrl = "https://bulksmsapi.vispl.in/?username=cscotpapi&password=cscotpapi@123&messageType=text&mobile="
				+ mobileno + "&senderId=APSCRC&ContentID=1707162003406121618&EntityID=1301157363501533886&message="
				+ MessageBody;

		System.out.println(" SB " + sb);

		System.out.println(" Mobile No " + mobileno);

		UserRegistrationData obj = jpaSavePersonalDetailsInterface.findByMobile(mobileno);
		String encrptedpassword = encryptanddecrypt.encrypt(sb.toString());
		obj.setPassword(encrptedpassword);
		jpaSavePersonalDetailsInterface.save(obj);
		System.out.println(" Password Saved ");

		try {
			URLConnection myURLConnection = null;
			URL myURL = null;
			BufferedReader reader = null;
			String encoded_message = URLEncoder.encode(message);
			try {
				MessageUrl = MessageUrl.replace(" ", "%20");
				// prepare connection
				reader = new BufferedReader(new InputStreamReader(
						((HttpURLConnection) (new URL(MessageUrl)).openConnection()).getInputStream(),
						Charset.forName("UTF-8")));

				String response;
				while ((response = reader.readLine()) != null)

					reader.close();

//				UserRegistrationData obj = jpaSavePersonalDetailsInterface.findByMobile(mobileno);
//				String encrptedpassword = encryptanddecrypt.encrypt(sb.toString());
//				obj.setPassword(encrptedpassword);
//				jpaSavePersonalDetailsInterface.save(obj);
//				System.out.println(" Password Saved ");

			} catch (IOException ex) {

				ex.printStackTrace();
			}

		} catch (Exception ex) {
		}

	}

	@Override
	public List<DynamicOptionsforApplyPostInterface> fetchdynamicoptionsforpost(String employeeid, String postid) {
		return storedProcedureReposistory.DynamicOPtions(Integer.parseInt(postid), Integer.parseInt(employeeid));
	}

	@Override
	public ApplyPostDynamicDropdown fetchapplypostdynamicdropdownvalues(String postid) {
		return storedProcedureReposistory.fetchapplypostdynamicdropdownvalues(Integer.parseInt(postid));
	}

	@Override
	public String generateOTPforcancelapplication(String toMobileNo) throws IOException {
		Random random = new Random();
		String otp = String.format("%06d", random.nextInt(1000000));
		StringBuffer otpstringbuffer = new StringBuffer(otp);
		if (otpstringbuffer.charAt(0) == '0') {
			otpstringbuffer.replace(0, 1, "6");
		}
		String sucess = "";

		System.out.println(" OTP for Cancel Application : " + otpstringbuffer);

		UserRegistrationData obj = jpaSavePersonalDetailsInterface.findByMobile(toMobileNo);
		String message = "Dear " + obj.getFull_name() + ", Please use OTP " + otpstringbuffer
				+ " to cancel your form submission. Do not share this OTP with anyone to avoid misuse of your account.OTP valid for 1mins.--APSC";

		String MessageUrl = "https://bulksmsapi.vispl.in/?username=cscotpapi&password=cscotpapi@123&messageType=text&mobile="
				+ toMobileNo + "&senderId=APSCRC&ContentID=1707160762034542862&EntityID=1301157363501533886&message="
				+ message;

		try {
			URLConnection myURLConnection = null;
			URL myURL = null;
			BufferedReader reader = null;
			String encoded_message = URLEncoder.encode(message);
			try {
				MessageUrl = MessageUrl.replace(" ", "%20");
				reader = new BufferedReader(new InputStreamReader(
						((HttpURLConnection) (new URL(MessageUrl)).openConnection()).getInputStream(),
						Charset.forName("UTF-8")));
				String response;
				while ((response = reader.readLine()) != null)
					System.out.println(response);
				reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			sucess = "success";

		} catch (Exception ex) {
		}
		return otpstringbuffer.toString();
	}

	@Override
	public PayslipDetails fetchpayslipdetails(String postid, String employeeid) {

		return storedProcedureReposistory.fetchpayslipdetails(Integer.parseInt(postid), Integer.parseInt(employeeid));
	}

	@Override
	public PaymentPendingDetails paymentpendingstatus(String postid, String employeeid) {
		PaymentPendingDetailsAttributes paymentpendingdetailsattributes = storedProcedureReposistory
				.paymentpendingdetailsattributes(Integer.parseInt(postid), Integer.parseInt(employeeid));

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("DEPARTMENT_ID", paymentpendingdetailsattributes.getdepatid());
		map.add("OFFICE_CODE", paymentpendingdetailsattributes.getofficecode());
		map.add("AMOUNT", paymentpendingdetailsattributes.getamount());

		String url = "https://uatgras.assam.gov.in/challan/models/frmgetgrn.php";

		RestTemplate res = new RestTemplate();
		ResponseEntity<String> result = res.postForEntity(url, map, String.class);
		String finalresult = result.toString();
		String[] outputresult = finalresult.split(",");
		String[] finalstring = outputresult[1].split("\\$");
		PaymentPendingDetails obj = new PaymentPendingDetails();

		obj.setEmployeeid(employeeid);
		obj.setPostid(postid);
		obj.setDEPARTMENT_ID(finalstring[2]);
		obj.setGRN(finalstring[4]);
		obj.setAMOUNT(finalstring[6]);
		obj.setBANKCODE(finalstring[8]);
		obj.setBANKCIN(finalstring[10]);
		obj.setPRN(finalstring[12]);
		obj.setTRANSCOMPLETIONDATETIME(finalstring[14]);
		obj.setSTATUS(finalstring[16]);
		obj.setPARTYNAME(finalstring[18]);
		obj.setTAXID(finalstring[20]);
		obj.setBANKNAME(finalstring[22]);
		obj.setENTRY_DATE(finalstring[24]);
		jpaSavePayementPendingDetails.save(obj);
		return obj;
	}

	@Override
	public String updatependingtopaid(String postid, String employeeid) {

		ApplyPostFinalData reterivedtext = jpaSaveApplypostFinalData
				.fetchapplypostfinaldata(Integer.parseInt(employeeid), Integer.parseInt(postid));
		reterivedtext.setPaymentstatus("Paid");
		jpaSaveApplypostFinalData.save(reterivedtext);
		return "Success";
	}

	@Override
	public PaymentPendingDetailsAttributes fetchpendingpaymentattributes(String postid, String employeeid) {

		return storedProcedureReposistory.paymentpendingdetailsattributes(Integer.parseInt(postid),
				Integer.parseInt(employeeid));
	}

	@Override
	public boolean checkphonenumberpresentornot(String mobilenum) {
		if (jpaSavePersonalDetailsInterface.findByMobile(mobilenum) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String updatetable(String employeeid) {
		String res = storedProcedureReposistory.validatepayment(Integer.parseInt(employeeid));
		return res;
	}

	@Override
	public List<WorkExperienceforPost> fetchworkexperiecefordyamicdropdown(String postid, String selectedvalue) {

		return storedProcedureReposistory.fetchworkexperiencefordynamicvalue(Integer.parseInt(postid), selectedvalue);

	}

	@Override
	public PaymentSuccessDetails fetchpaymentsuccessdetails(String postid, String employeeid) {
		return storedProcedureReposistory.fetchpaymentsuccessdetails(Integer.parseInt(postid),
				Integer.parseInt(employeeid));
	}

	@Override
	public SpliupPayment fetchpayemntsplitup(String postid, String employeeid) {
		return storedProcedureReposistory.fetchpaymentsplitup(Integer.parseInt(postid), Integer.parseInt(employeeid));

	}

	@Override
	public List<String> fetchdynamicheadingforapplypost(String postid) {
		return storedProcedureReposistory.fetchdynamicheadingforapplypost(Integer.parseInt(postid));
	}

	@Override
	public DocumentUpload[] fetchdocumentuplodedduringotr(String employeeid) {
		DocumentUpload[] doc = jpaSaveDocuments.fetchDetails(Integer.parseInt(employeeid));
		/*
		 * for(int i=0;i<=doc.length;i++) { String img=doc }
		 */
		for (DocumentUpload ele : doc) {
			String filePath = ele.getDocument();
			File file = new File(filePath);
			String encodedString = encodeFileToBase64(file);

			ele.setDocument("pdfconverted," + encodedString);
		}
		return doc;
		// return jpaSaveDocuments.fetchDetails(Integer.parseInt(employeeid));
	}

	private static String encodeFileToBase64(File file) {
		try {
			byte[] fileContent = Files.readAllBytes(file.toPath());
			return Base64.getEncoder().encodeToString(fileContent);
		} catch (IOException e) {
			throw new IllegalStateException("could not read file " + file, e);
		}
	}

	@Override
	public List<String> dropdownvaluesfordynamicquestions(String postid, String employeeid) {
		return storedProcedureReposistory.fetchdropdownvaluesfordynamicquestions(Integer.parseInt(postid),
				Integer.parseInt(employeeid));
	}

	@Override
	public int verifyGRNnumber(String grnnumber) {

		int maintable = jpaSavePersonalDetailsInterface.verifyGRNnumber(grnnumber);
		int newtable = oldPaymentDetailsReposistory.verifyGRNnumber(grnnumber);
		if (maintable != 0 && newtable == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int verifypaymentforMVI(String employeeid, String postid) {
		return storedProcedureReposistory.validateforMVI(Integer.parseInt(employeeid), Integer.parseInt(postid));
	}

	@Override
	public AdmitCard fetchAdmitCard(String applicatioid, String dob) {
		return storedProcedureReposistory.printAdmitCard(applicatioid, dob);
	}

	@Override
	public List<ExamZones> fetchExamsZones(String applicatioid, String dob) {
		return storedProcedureReposistory.fetchExamZones(applicatioid, dob);
	}

	@Override
	public List<PageSetup> pagesetup(String data) {
		return storedProcedureReposistory.pagesetupforPDF(data);
	}
}
