package com.iib.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iibapp_uploadedfile")
public class IibappUploadfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "file_name")
    private String filename;
	@Column(name = "file_type")
    private String filetype;
	@Column(name = "month")
    private String month;
	@Column(name = "year")
    private String year;
	@Column(name = "uploaded_on")
    private String uploadedon;
	@Column(name = "uploaded_file")
    private String uploadedfile;
	@Column(name = "file_status")
    private String filestatus;
	@Column(name = "control_amount")
    private String controlamount;
	@Column(name = "control_number")
    private String controlnumber;
	@Column(name = "failed_reason")
    private String failedreason;
	@Column(name = "processed_on")
    private String processedon;
	@Column(name = "insurer_id")
    private int insurerid;
	@Column(name = "uploaded_by_user_id")
    private int uploadedbyuserid;
	@Column(name = "failure_records")
    private int failurerecords;
	@Column(name = "processed_records")
    private int processrecords;
	@Column(name = "success_records")
    private int successrecords;
	@Column(name = "file_extension")
    private String fileextension;
	@Column(name = "is_active")
    private int isactive;
	
	
	
	@Override
	public String toString() {
		return "IibappUploadfile [id=" + id + ", filename=" + filename + ", filetype=" + filetype + ", month=" + month
				+ ", year=" + year + ", uploadedon=" + uploadedon + ", uploadedfile=" + uploadedfile + ", filestatus="
				+ filestatus + ", controlamount=" + controlamount + ", controlnumber=" + controlnumber
				+ ", failedreason=" + failedreason + ", processedon=" + processedon + ", insurerid=" + insurerid
				+ ", uploadedbyuserid=" + uploadedbyuserid + ", failurerecords=" + failurerecords + ", processrecords="
				+ processrecords + ", successrecords=" + successrecords + ", fileextension=" + fileextension
				+ ", isactive=" + isactive + "]";
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getUploadedon() {
		return uploadedon;
	}
	public void setUploadedon(String uploadedon) {
		this.uploadedon = uploadedon;
	}
	public String getUploadedfile() {
		return uploadedfile;
	}
	public void setUploadedfile(String uploadedfile) {
		this.uploadedfile = uploadedfile;
	}
	public String getFilestatus() {
		return filestatus;
	}
	public void setFilestatus(String filestatus) {
		this.filestatus = filestatus;
	}
	public String getControlamount() {
		return controlamount;
	}
	public void setControlamount(String controlamount) {
		this.controlamount = controlamount;
	}
	public String getControlnumber() {
		return controlnumber;
	}
	public void setControlnumber(String controlnumber) {
		this.controlnumber = controlnumber;
	}
	public String getFailedreason() {
		return failedreason;
	}
	public void setFailedreason(String failedreason) {
		this.failedreason = failedreason;
	}
	public String getProcessedon() {
		return processedon;
	}
	public void setProcessedon(String processedon) {
		this.processedon = processedon;
	}
	public int getInsurerid() {
		return insurerid;
	}
	public void setInsurerid(int insurerid) {
		this.insurerid = insurerid;
	}
	public int getUploadedbyuserid() {
		return uploadedbyuserid;
	}
	public void setUploadedbyuserid(int uploadedbyuserid) {
		this.uploadedbyuserid = uploadedbyuserid;
	}
	public int getFailurerecords() {
		return failurerecords;
	}
	public void setFailurerecords(int failurerecords) {
		this.failurerecords = failurerecords;
	}
	public int getProcessrecords() {
		return processrecords;
	}
	public void setProcessrecords(int processrecords) {
		this.processrecords = processrecords;
	}
	public int getSuccessrecords() {
		return successrecords;
	}
	public void setSuccessrecords(int successrecords) {
		this.successrecords = successrecords;
	}
	public String getFileextension() {
		return fileextension;
	}
	public void setFileextension(String fileextension) {
		this.fileextension = fileextension;
	}
	public int getIsactive() {
		return isactive;
	}
	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
    

}
