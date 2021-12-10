/**
 * 
 */
package com.dfte.oracle.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dfte.oracle.dto.EbsSodOutput;
import com.dfte.oracle.dto.SodRules;
import com.dfte.oracle.utilities.ExcelToPojoUtils;
import com.google.gson.Gson;

import net.sf.jxls.transformer.XLSTransformer;

/**
 * @author dinebhat
 *
 */
@Service
public class OracleOsamServiceImpl implements OracleOsamService {

	@Autowired
	private ExcelToPojoUtils utils;

	//THIS IS FOR TESTING AND DEMO PURPOSE
	public static final String[] tobeSkipped_SODRULE = new String[] { "Instructions: Please see example below.",
			"PLEASE NOTE THAT NOT ALL FIELDS ARE REQUIRED", "[Add any additional instructions here.]" };

	@Override
	public XSSFWorkbook runEBSRules(MultipartFile[] responibilityFiles, MultipartFile roleToResponsibity,
			MultipartFile roleOrResponsibility) throws Exception {

		return createEBS_SODOutput();
	}

	@Override
	public XSSFWorkbook runCloudRules(MultipartFile[] roleDesign, MultipartFile userToRole) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public XSSFWorkbook createEBS_SODOutput() throws Exception {

		List<EbsSodOutput> objects = new ArrayList<EbsSodOutput>();
		int i = 0;
		/*
		 * while (i < 10) {
		 * 
		 * objects.add(deriveDataAfterSodAnalysis(i)); //EbsSodOutput get individual
		 * records i++; }
		 */

		XSSFWorkbook wb = null;
		Map<String, Object> currentDataMap = new HashMap<String, Object>();
		currentDataMap.put("sodOutput", objects);
		InputStream ExcelFileToRead = new FileInputStream(ResourceUtils.getFile("classpath:EBS_SOD_Output.xlsx"));

		XLSTransformer transformer = new XLSTransformer();

		wb = (XSSFWorkbook) transformer.transformXLS(ExcelFileToRead, currentDataMap);
		return wb;
	}

	/**
	 *
	 */
	@Override
	public String xlsToJavaTesting(MultipartFile file) {
		List<SodRules> pojos = null;
		try {

			InputStream inputxls = file.getInputStream();
			XSSFWorkbook workbook = new XSSFWorkbook(inputxls);
			pojos = utils.toPojo(SodRules.class, workbook.getSheetAt(0), tobeSkipped_SODRULE, 0);

			inputxls.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Gson().toJson(pojos);
	}

}
