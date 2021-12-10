/**
 * 
 */
package com.dfte.oracle.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author dinebhat
 *
 */

@RestController
@RequestMapping("/oracle-oscar")
public class OracleOSCARController {

	
	/**
	 * @return
	 */
	@GetMapping("/downloadTemplate")
	public ResponseEntity<ByteArrayResource> downloadTemplate() {
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			InputStream inputxls = new FileInputStream(ResourceUtils.getFile("classpath:OscarCreateUserTemplate.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(inputxls);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "force-download"));
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Create User Template.xlsx");
			workbook.write(stream);
			workbook.close();
			return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @param file
	 */
	@PostMapping("/createUser")
	public void createUser(@RequestParam("file") MultipartFile file) {
		
	}
	
	
	/**
	 * 
	 */
	@PostMapping("/updateEmailAddress")
	public void updateEmailAddress() {
		
	}
	
	
	/**
	 * 
	 */
	@PostMapping("/userRoleAssignment")
	public void userRoleAssignment() {
		
	}
	
	
	/**
	 * 
	 */
	@PostMapping("/deleteUser")
	public void deleteUser() {
		
	}
	
	/**
	 * 
	 */
	@PostMapping("/passwordReset")
	public void passwordReset() {
		
	}
	
	
	/**
	 * 
	 */
	@PostMapping("/activateDeactivateUser")
	public void activateDeactivateUser() {
		
	}
	
	
	/**
	 * 
	 */
	@PostMapping("/dataAccessSetAssignment")
	public void dataAccessSetAssignment() {
		
	}
	
	
	/**
	 * 
	 */
	@PostMapping("/procurementAgentSetup")
	public void procurementAgentSetup() {
		
	}
	
	
	/**
	 * 
	 */
	@PostMapping("/linkPersonRecordToUser")
	public void linkPersonRecordToUser() {
		
	}
}
