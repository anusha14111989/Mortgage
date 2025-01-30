package com.example.mortgageLoan.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class InterestRate {
	
	private int maturityPeriod; //in years
	private double interestRate; // percentage (eg:6.0 for 6%)
	private Instant lastUpdate;

	public InterestRate(int maturityPeriod, double interestRate, Instant lastUpdate) {
		this.maturityPeriod = maturityPeriod;
		this.interestRate = interestRate;
		this.lastUpdate = lastUpdate;
	}
	
	public int getMaturityPeriod() {
		return maturityPeriod;
	}
	public void setMaturityPeriod(int maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public Instant getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	

}
