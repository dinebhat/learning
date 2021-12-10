/**
 * 
 */
package com.dfte.oracle.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.dfte.oracle.service.OracleOsamService;

/**
 * @author dinebhat
 *
 */

@RestController
@RequestMapping("/oracle-osam")
public class OracleOSAMController {

	@Autowired
	private OracleOsamService service;
	
	/**
	 * @return
	 */
	@GetMapping("/getRuleFile")
	public ResponseEntity<ByteArrayResource> downloadTemplate() {
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			InputStream inputxls = new FileInputStream(ResourceUtils.getFile("classpath:OsamSODRuleTemplate.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(inputxls);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "force-download"));
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=OsamSODRuleTemplate.xlsx");
			workbook.write(stream);
			workbook.close();
			return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param responibilityFiles
	 * @param roleToResponsibity
	 * @param roleOrResponsibility
	 * @return
	 */
	@PostMapping("/runEbsRules")
	public ResponseEntity<ByteArrayResource> runEbsRules(
			@RequestParam("responibilityFiles") MultipartFile[] responibilityFiles,
			@RequestParam("roleToResponsibity") MultipartFile roleToResponsibity,
			@RequestParam("roleToResponsibity") MultipartFile roleOrResponsibility) {

		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			XSSFWorkbook workbook = service.runEBSRules(responibilityFiles, roleToResponsibity, roleOrResponsibility);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "force-download"));
			header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=EBS_SOD_Output.xlsx");
			workbook.write(stream);
			workbook.close();
			return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * @param roleDesign
	 * @param userToRole
	 * @return
	 */
	@PostMapping("/runCloudRules")
	public ResponseEntity<ByteArrayResource> runCloudRules(@RequestParam("roleDesign") MultipartFile[] roleDesign,
			@RequestParam("userToRole") MultipartFile userToRole) {

		return null;

	}
	
	
	/**
	 * @param roleOrResponsibility
	 * @return
	 * 
	 * THIS IS FOR TESTING PURPOSE
	 */
	@PostMapping("/xlsToPojo")
	public String xlsToJavaTesting(@RequestParam("file") MultipartFile roleOrResponsibility) {
		
		return service.xlsToJavaTesting(roleOrResponsibility);
	}

}
