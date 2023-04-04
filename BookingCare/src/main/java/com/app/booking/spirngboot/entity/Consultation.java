package com.app.booking.spirngboot.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultations")
public class Consultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	private String diagnasis;
	
	private String treatment;
	
//	@OneToMany(mappedBy = "consultation")
//	private List<ConsultationDetail> consultationDetails;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "consultation_details",
               joinColumns = @JoinColumn(name = "consultation_id"),
               inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine> medicines;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "examnination_history_id")
    private ExamninationHistory examninationHistory;
	
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiagnasis() {
		return diagnasis;
	}

	public void setDiagnasis(String diagnasis) {
		this.diagnasis = diagnasis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	
	
	
}
