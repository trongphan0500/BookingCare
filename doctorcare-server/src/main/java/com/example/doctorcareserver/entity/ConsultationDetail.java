package com.example.doctorcareserver.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "consultation_details")
public class ConsultationDetail {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	
		
		private int quantity;
		
		@ManyToOne
		@JoinColumn(name = "medicine_id")
		private Medicine medicine;
		
		@ManyToOne
		@JoinColumn(name = "consultation_id")
		private Consultation consultation;
		
		

		
		
		
}
