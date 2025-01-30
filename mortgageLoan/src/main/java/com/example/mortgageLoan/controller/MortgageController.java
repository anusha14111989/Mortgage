package com.example.mortgageLoan.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mortgageLoan.model.InterestRate;
import com.example.mortgageLoan.model.MortgageCheckRequest;
import com.example.mortgageLoan.model.MortgageCheckResponse;
import com.example.mortgageLoan.service.MortgageService;

@RestController
@RequestMapping("/api")
public class MortgageController {

	private final MortgageService mortgageService;
	
	public MortgageController(MortgageService mortgageService) {
		this.mortgageService=mortgageService;
	}
	
	@GetMapping("/interest-rates")
	public ResponseEntity<List<InterestRate>> getInterestRates(){
		return ResponseEntity.ok(mortgageService.getInterestRates());
	}
	
	@PostMapping("/mortgage-check")
	public ResponseEntity<MortgageCheckResponse> checkMortgage(@RequestBody MortgageCheckRequest request){
		MortgageCheckResponse response= mortgageService.checkMortgage(request) ;
		return ResponseEntity.ok(response);
		
	}
}
