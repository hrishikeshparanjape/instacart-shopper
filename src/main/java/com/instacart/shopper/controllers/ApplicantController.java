package com.instacart.shopper.controllers;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instacart.shopper.domain.ShopperApplicant;
import com.instacart.shopper.repository.ApplicantRepository;

@RestController
public class ApplicantController {
	
	@Autowired
	ApplicantRepository applicantRepository;
	
	@RequestMapping(path="/applicant", method=RequestMethod.POST)
	public ShopperApplicant createApplicant(@RequestBody CreateApplicantRequest createApplicantRequest) throws Exception {
		ShopperApplicant ret = applicantRepository.createNew(createApplicantRequest.getEmail(),
				createApplicantRequest.getAddress(),
				createApplicantRequest.getPhone(),
				createApplicantRequest.getName());
		return ret;
	}

	@RequestMapping(path="/applicant/{email}", method=RequestMethod.GET)
	public ShopperApplicant findByEmail(@PathVariable String email) {
		return applicantRepository.findByEmail(email);
	}
}
