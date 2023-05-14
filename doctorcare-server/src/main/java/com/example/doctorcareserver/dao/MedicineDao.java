package com.example.doctorcareserver.dao;

import java.util.ArrayList;

import javax.print.attribute.standard.Media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doctorcareserver.entity.Medicine;




public interface MedicineDao {
	ArrayList<Medicine> getMediasfrom(String name);
		
}