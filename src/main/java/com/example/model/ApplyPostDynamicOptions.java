package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ApplyPostDynamicOptions {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	
	private String employeeid;
	private String postid;
	private String questionid;
	private String question;
	private String answertype;
	private String answer;
	
	
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswertype() {
		return answertype;
	}
	public void setAnswertype(String answertype) {
		this.answertype = answertype;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
