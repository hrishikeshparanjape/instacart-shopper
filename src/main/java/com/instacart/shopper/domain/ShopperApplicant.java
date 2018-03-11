package com.instacart.shopper.domain;

import java.util.Calendar;

public class ShopperApplicant {
	private long id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private ApplicantStatus status;
	private Calendar created_at;
	private Calendar updated_at;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ApplicantStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicantStatus status) {
		this.status = status;
	}
	public Calendar getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Calendar created_at) {
		this.created_at = created_at;
	}
	public Calendar getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Calendar updated_at) {
		this.updated_at = updated_at;
	}
	
	@Override
	public String toString() {
		return "ShopperApplicant [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", status=" + status + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}
}
