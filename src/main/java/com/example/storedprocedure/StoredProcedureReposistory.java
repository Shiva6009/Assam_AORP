package com.example.storedprocedure;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface StoredProcedureReposistory extends JpaRepository<PostMaster, Integer> {

	@Query(value = "{call Candidate_DashBoard1(:CandidateID)}", nativeQuery = true)
	List<PostMasterInterface> Candidate_DashBoard(int CandidateID);

	@Query(value = "{call whatsnew}", nativeQuery = true)
	List<AdvertistmentInterface> whatsnew();

	@Query(value = "{call EducationalQualification(1,:pOSTid)}", nativeQuery = true)
	List<EducationalQualificationforPostInterface> EducationalQualification(int pOSTid);

	@Query(value = "{call test(1,:pOSTid ,:selectedvalues)}", nativeQuery = true)
	List<EducationalQualificationforPostInterface1> EducationalQualification1(int pOSTid, String selectedvalues);

//	@Query(value = "{call EducationalQualification(3,:pOSTid)}" , nativeQuery = true)
//	List<EducationalQualificationforPostInterface2> EducationalQualification2(int pOSTid);

	@Query(value = "{call DocumentuPLOAD(:pOSTid)}", nativeQuery = true)
	List<DocumentUploadforPost> DocumentUploadforPost(int pOSTid);
	
	@Query(value = "{call USP_LoadDynamicOptions(:PostID , :EmpID)}" , nativeQuery = true)
	List<DynamicOptionsforApplyPostInterface> DynamicOPtions(int PostID , int EmpID);

	@Query(value = "{call WorkExperience(:pOSTid)}", nativeQuery = true)
	List<WorkExperienceforPost> WorkExperienceforPost(int pOSTid);

	@Query(value = "{ call USP_LoadExaminaitonZone(:PostID)}", nativeQuery = true)
	List<ExaminationZoneInterface> Examinationzoneforapplypost(int PostID);
	
	@Query(value = "{ call applypostdynamicdropdowns(:Postid)}" , nativeQuery = true)
	ApplyPostDynamicDropdown fetchapplypostdynamicdropdownvalues(int Postid);

	@Query(value = "{ call USP_PaymentDetials(:PostID , :RegID)}", nativeQuery = true)
	PayementModuleInterface PaymentDetailsforPost(int PostID, int RegID);
	
	@Query(value = "{ call USP_FetchPaymentDetails(:PostID , :EmplpyeID)}" ,nativeQuery = true)
	PayslipDetails fetchpayslipdetails(int PostID , int EmplpyeID);
	
	@Query(value = "{ call paymentpendingstatus(:postid , :employeeid)}" ,nativeQuery = true)
	PaymentPendingDetailsAttributes paymentpendingdetailsattributes(int postid , int employeeid);
	
	@Query(value = "{call ValidatePayment(:EmpID)}" , nativeQuery = true)
	String validatepayment(int EmpID);
	
	@Query(value = "{call SubPostWE(:PostID ,:input)}" , nativeQuery = true)
	List<WorkExperienceforPost> fetchworkexperiencefordynamicvalue(int PostID , String input);
	
	@Query(value = "{call PaymentAck(:PostID , :EmployeeID)}" , nativeQuery = true)
	PaymentSuccessDetails fetchpaymentsuccessdetails(int PostID , int EmployeeID);
	
	@Modifying
	@Query(value = "{ call DeleteApplicationForm(:postid ,:CandidateID)}" , nativeQuery = true)
	void DeleteApplicationForm(int postid , int CandidateID);
		
	@Query(value = "{call USP_PaymentDetialssplitUP(:PostID , :RegID)}" , nativeQuery = true)
	SpliupPayment fetchpaymentsplitup(int PostID , int RegID );
	
	@Query(value = "{call dynamicdetails(:Id)}" , nativeQuery = true)
    List<String> fetchdynamicheadingforapplypost(int Id);
	
	@Query(value = "{call LoadDynamicOptions_DropDown(:postid , :employeeid)}" , nativeQuery = true)
	List<String> fetchdropdownvaluesfordynamicquestions(int postid , int employeeid);

	@Query(value = "{call Validate_Eligibility(:CandidateID , :PostID)}" , nativeQuery = true)
	int validateforMVI(int CandidateID , int PostID);
	
	@Query(value = "{call PrintAdmitCard (1,:ApplicantID , :Dateofbirth)}" , nativeQuery = true)
	AdmitCard printAdmitCard(String ApplicantID , String Dateofbirth);
	
	
	@Query(value = "{call PrintAdmitCard (2, :ApplicantID , :Dateofbirth)}" , nativeQuery = true)
	List<ExamZones> fetchExamZones(String ApplicantID , String Dateofbirth);
	
	@Query(value = "{call Pageset(:data)}" , nativeQuery = true)
	List<PageSetup> pagesetupforPDF(String data);
	
}
