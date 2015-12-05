package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the otp_request_details database table.
 * 
 */
@Entity
@Table(name="otp_request_details")
@NamedQuery(name="OtpRequestDetailDO.findAll", query="SELECT o FROM OtpRequestDetailDO o")
public class OtpRequestDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp createdDate;

	private byte isActive;

	private byte isValidated;

	private int otp;

	private int requestedby;

	public OtpRequestDetailDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsValidated() {
		return this.isValidated;
	}

	public void setIsValidated(byte isValidated) {
		this.isValidated = isValidated;
	}

	public int getOtp() {
		return this.otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public int getRequestedby() {
		return this.requestedby;
	}

	public void setRequestedby(int requestedby) {
		this.requestedby = requestedby;
	}

}