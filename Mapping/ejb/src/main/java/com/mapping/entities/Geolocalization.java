package com.mapping.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the geolocalization database table.
 * 
 */
@Entity
@Table(name="geolocalization")
public class Geolocalization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USR_ID")
	private int usrId;

	
	@Column(name="GEO_DATE")
	private Date geoDate;

	@Column(name="GEO_ID")
	private int geoId;

	@Column(name="GEO_LATITUDE")
	private BigDecimal geoLatitude;

	@Column(name="GEO_LENGTH")
	private BigDecimal geoLength;

	@Column(name="GEO_STATE")
	private String geoState;

	//bi-directional one-to-one association to Form
	@OneToOne(mappedBy="geolocalization")
	private Form form;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="USR_ID")
	private User user;

	public Geolocalization() {
	}

	public int getUsrId() {
		return this.usrId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public Date getGeoDate() {
		return this.geoDate;
	}

	public void setGeoDate(Date geoDate) {
		this.geoDate = geoDate;
	}

	public int getGeoId() {
		return this.geoId;
	}

	public void setGeoId(int geoId) {
		this.geoId = geoId;
	}

	public BigDecimal getGeoLatitude() {
		return this.geoLatitude;
	}

	public void setGeoLatitude(BigDecimal geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	public BigDecimal getGeoLength() {
		return this.geoLength;
	}

	public void setGeoLength(BigDecimal geoLength) {
		this.geoLength = geoLength;
	}

	public String getGeoState() {
		return this.geoState;
	}

	public void setGeoState(String geoState) {
		this.geoState = geoState;
	}

	public Form getForm() {
		return this.form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}