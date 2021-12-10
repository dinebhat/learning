package com.dfte.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfte.oracle.service.OracleRpaService;

@RestController
@RequestMapping("/oracle-rpa")
public class OracleRPAController {
	
	@Autowired
	OracleRpaService oracleRPAService;
	
	/**
	 * @author naichowdhury
	 * the method communicated with the uipath orchestrator
	 * and returns the status of the rpa bot jobs
	 * @return rpa bot job status
	 */
	@GetMapping("/job-status")
	public ResponseEntity<String> getRpaJobStatus() {
		String status = oracleRPAService.getRpaJobStatus();
		return ResponseEntity.ok(status);
	}

}
