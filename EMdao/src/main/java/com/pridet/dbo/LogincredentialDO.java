package com.pridet.dbo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the logincredentials database table.
 * 
 */
@Entity
@Table(name="logincredentials")
@NamedQuery(name="LogincredentialDO.findAll", query="SELECT l FROM LogincredentialDO l")
public class LogincredentialDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int otp;

	private String password;

	private String username;

	//bi-directional many-to-one association to ProfessionaldetailDO
	@ManyToOne
	@JoinColumn(name="professionaldetails")
	private ProfessionaldetailDO professionaldetail;

	public LogincredentialDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOtp() {
		return this.otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ProfessionaldetailDO getProfessionaldetail() {
		return this.professionaldetail;
	}

	public void setProfessionaldetail(ProfessionaldetailDO professionaldetail) {
		this.professionaldetail = professionaldetail;
	}

}