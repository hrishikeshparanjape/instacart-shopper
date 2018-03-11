package com.instacart.shopper.repository;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.instacart.shopper.domain.ApplicantStatus;
import com.instacart.shopper.domain.ShopperApplicant;

@Service
public class ApplicantRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicantRepository.class);

	private static final Map<String, ShopperApplicant> shopperList = new HashMap<String, ShopperApplicant>();

	private long nextLong() {
		return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
	}

	public ShopperApplicant createNew(String email, String address, String phone, String name) throws Exception {
		ShopperApplicant applicant = shopperList.get(email);
		if (applicant == null) {
			applicant = new ShopperApplicant();
			applicant.setId(nextLong()); // if we used real database, we would have used autoincrementing ids
			applicant.setCreated_at(Calendar.getInstance());
			applicant.setUpdated_at(Calendar.getInstance());
			applicant.setName(name);
			applicant.setEmail(email);
			applicant.setPhone(phone);
			applicant.setStatus(ApplicantStatus.NEW);
			shopperList.put(email, applicant);
			log.info("created new applicant: applicant=" + applicant.toString());
			return applicant;
		} else {
			throw new Exception("applicant with that email already exists");
		}
	}
	
	public ShopperApplicant findByEmail(String email) {
		ShopperApplicant applicant = shopperList.get(email);
		if(applicant != null) {
			log.info("found applicant with provided email: applicant=" + applicant.toString());
		}
		return applicant;
	}
}
