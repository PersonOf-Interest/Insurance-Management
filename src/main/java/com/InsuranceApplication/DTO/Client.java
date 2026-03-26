package com.InsuranceApplication.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {

	@Id
	@Column(name ="clientId")
	private int clientId;
	@Column(name ="clientName")
	private String clientName;
	@Column(name ="clientDateOfBirth")
	private String clientDateOfBirth;
	@Column(name ="clientAddress")
	private String clientAddress;
	@Column(name ="clientContactInformation")
	private String clientContactInformation;
	
	
	@ManyToOne
	@JoinColumn(name="policyId")
	private InsurancePolicy insurancePolicy;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientDateOfBirth() {
		return clientDateOfBirth;
	}
	public void setClientDateOfBirth(String clientDateOfBirth) {
		this.clientDateOfBirth = clientDateOfBirth;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientContactInformation() {
		return clientContactInformation;
	}
	public void setClientContactInformation(String clientContactInformation) {
		this.clientContactInformation = clientContactInformation;
	}
	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}
	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}
	
	
}
