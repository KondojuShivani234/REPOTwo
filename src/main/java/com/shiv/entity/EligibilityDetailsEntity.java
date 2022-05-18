package com.shiv.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Eligibility_Details")
public class EligibilityDetailsEntity {
	@Id
	@GeneratedValue
	@Column(name = "Elig_ID")
	private Integer eligId;
	@Column(name = "Case_Num")
	private Long caseNum;
	@Column(name = "Plan_Name")
	private String planName;
	@Column(name = "Plan_Status")
	private String planStatus;
	@Column(name = "Benefit_Amt")
	private Double benefitAmt;
	@Column(name = "Start_Date")
	private LocalDate startDate;
	@Column(name = "End_Date")
	private LocalDate endDate;
	@Column(name = "Denail_Reason")
	private String denailReason;
	@Column(name = "Holder_Name")
	private String holderName;
	@Column(name = "Holder_Ssn")
	private Long holderSsn;

}
