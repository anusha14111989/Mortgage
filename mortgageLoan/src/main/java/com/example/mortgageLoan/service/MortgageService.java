package com.example.mortgageLoan.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mortgageLoan.model.InterestRate;
import com.example.mortgageLoan.model.MortgageCheckRequest;
import com.example.mortgageLoan.model.MortgageCheckResponse;

@Service
public class MortgageService {
	
	private final List<InterestRate> interestRates;
	
	public MortgageService() {
		this.interestRates=List.of( new InterestRate(15,5.5,Instant.now()),
				new InterestRate(20,5.8,Instant.now()),
				new InterestRate(30,6.0,Instant.now()));
	}

	public List<InterestRate> getInterestRates() {
		return interestRates;
	}

	public Optional<Double> getInterestRateForMaturityperiod(int maturityPeriod){
		Optional<Double> interestRate = interestRates.stream().filter(rate -> rate.getMaturityPeriod() == maturityPeriod)
				                     .map(InterestRate::getInterestRate).findFirst();
	return interestRate;
	}
	
	public MortgageCheckResponse checkMortgage(MortgageCheckRequest request) {
		double totalIncome = request.getIncome() + (request.getPartnerIncome() != null ? request.getPartnerIncome():0);
		double maxLoanAllowed = totalIncome * 4;
		
		if(request.getLoanValue() > maxLoanAllowed) {
			return new MortgageCheckResponse(false,0.0);
		}
		
		Optional<Double> interestRateOpt = getInterestRateForMaturityperiod(request.getMaturityPeriod());		
		
		if(interestRateOpt.isEmpty()) {
			return new MortgageCheckResponse(false,0.0);
		}
		
		double r = interestRateOpt.get()/100/12;
		int n = 12;
		int t = request.getMaturityPeriod();
		double P = request.getLoanValue();
		double monthlyPayment = P * (r) * Math.pow((1 + r), (n * t)) / Math.pow((1 + r), (n * t) - 1);
	
		return new MortgageCheckResponse(true,monthlyPayment);
	}

}
