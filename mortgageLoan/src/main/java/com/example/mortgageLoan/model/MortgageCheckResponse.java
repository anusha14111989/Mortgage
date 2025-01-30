package com.example.mortgageLoan.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class MortgageCheckResponse {
	
	private boolean feasible;
	private double monthlyPayment;
	
	public MortgageCheckResponse(boolean feasible, double monthlyPayment) {
		super();
		this.feasible = feasible;
		this.monthlyPayment = monthlyPayment;
	}

	public boolean isFeasible() {
		return feasible;
	}

	public void setFeasible(boolean feasible) {
		this.feasible = feasible;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	
	
}
