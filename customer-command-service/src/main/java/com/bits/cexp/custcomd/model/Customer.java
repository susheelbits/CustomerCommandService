package com.bits.cexp.custcomd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;	

	@Column(name = "firstName", nullable = false)
	private String firstName;    

	@Column(name = "lastName")
	private String lastName;
	
    @Column(name = "customerAddress")
    private String customerAddress;

	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "acknowledgeFlag")
	private String acknowledgeFlag;	
	
	public Customer() {

	}
	
	public Customer(String firstName, String lastName, String customerAddress, String email,  String phone, String acknowledgeFlag) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerAddress = customerAddress;
		this.email = email;
		this.phone = phone;
		this.acknowledgeFlag = acknowledgeFlag;
	}	
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAcknowledgeFlag() {
		return acknowledgeFlag;
	}

	public void setAcknowledgeFlag(String acknowledgeFlag) {
		this.acknowledgeFlag = acknowledgeFlag;
	}
	
	@Override
	public String toString() {
		return "Customer "
				+ "[id=" + customerId + 
				", firstName=" + firstName + 
				", lastName=" + lastName + 
				", customerAddress=" + customerAddress + 
				", email=" + email +
				", phone=" + phone +
				"]";
	}	

}
