/**
 * *************************************************************************
 *
 * Filename : JobType.java 
 * Language : Java 2 v1.7
 * Purpose : Basic data entity, i.e. POJO, representing a JobType record 
 * on the M&B i-Interface database
 *
 * (C) COPYRIGHT Decision Insight Information Group, 2014 All Rights Reserved
 *
 * Author   Date        Changes 
 * sparry   2014-09-17  Initial Implementation
 *
 ****************************************************************************
 */
package com.mycompany.simplewebservice;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbljobtype")
public class JobType {

  //i've left the generation rules out for the time
  //being as I'm unfamiliar with how this works yet
  //(and it's just confusing anyway)
  @Id
  @Column(name = "pkjobtypeid")
  private int pkJobTypeId;

  //notice that the column names are all lower case.
  //this is not a requirement with Hibernate, but 
  //it is with Spring Data for some reason
  @Column(name = "jobtype")
  private String jobType;
  @Column(name = "instructionclass")
  private String instructionClass;
  @Column(name = "jobtypecode")
  private String jobTypeCode;
  @Column(name = "isactive")
  private short isActive;
  @Column(name = "createdon")
  private Date createdOn;
  @Column(name = "createdby")
  private int createdBy;

  //specific and general constructors
  public JobType() {
  }

  public JobType(int pkJobTypeId, String jobType, String jobTypeCode, short isActive, Date createdOn, int createdBy) {
    this.pkJobTypeId = pkJobTypeId;
    this.jobType = jobType;
    this.jobTypeCode = jobTypeCode;
    this.isActive = isActive;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
  }

  public JobType(int pkJobTypeId, String jobType, String instructionClass, String jobTypeCode, short isActive, Date createdOn, int createdBy) {
    this.pkJobTypeId = pkJobTypeId;
    this.jobType = jobType;
    this.instructionClass = instructionClass;
    this.jobTypeCode = jobTypeCode;
    this.isActive = isActive;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
  }

  //getters and setters
  public int getPkJobTypeId() {
    return this.pkJobTypeId;
  }

  public void setPkJobTypeId(int pkJobTypeId) {
    this.pkJobTypeId = pkJobTypeId;
  }

  public String getJobType() {
    return this.jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getInstructionClass() {
    return this.instructionClass;
  }

  public void setInstructionClass(String instructionClass) {
    this.instructionClass = instructionClass;
  }

  public String getJobTypeCode() {
    return this.jobTypeCode;
  }

  public void setJobTypeCode(String jobTypeCode) {
    this.jobTypeCode = jobTypeCode;
  }

  public short getIsActive() {
    return this.isActive;
  }

  public void setIsActive(short isActive) {
    this.isActive = isActive;
  }

  public Date getCreatedOn() {
    return this.createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public int getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }

  //and something just represent the record for debugging, etc.
  @Override
  public String toString() {
    return "JobType= [" + "pkJobTypeId=" + pkJobTypeId + 
                          ", jobType=" + jobType + 
                          ", instructionClass=" + instructionClass + 
                          ", jobTypeCode=" + jobTypeCode + 
                          ", isActive=" + isActive + 
                          ", createdOn=" + createdOn + 
                          ", createdBy=" + createdBy + ']';
  }

}
