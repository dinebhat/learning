/**
 * 
 */
package com.dfte.oracle.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author dinebhat
 *
 */
public interface OracleOsamService {

	public XSSFWorkbook runEBSRules(MultipartFile[] responibilityFiles, MultipartFile roleToResponsibity,
			MultipartFile roleOrResponsibility) throws Exception;

	public XSSFWorkbook runCloudRules(MultipartFile[] roleDesign, MultipartFile userToRole) throws Exception;
	
	public String xlsToJavaTesting(MultipartFile file);

}
