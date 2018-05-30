package com.accolite.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.accolite.bean.Employee;
import com.accolite.exception.Error;
import com.accolite.util.Converter;
import com.accolite.util.FileConvertor;
import com.accolite.util.ObjectToXml;

public class FileToXml {
	private Converter converter ;
	
	public void setConverter(Converter converter) {
		this.converter = converter;
	}

	public  int convertToXml(List<String> fileList) {
		int numberOfFileProcessed=0;
		for (String file : fileList) {
			try {
				Employee employee = converter.readAndConvert(file);
				ObjectToXml objectToXml = new ObjectToXml();
				objectToXml.convertToXml(employee);
				++numberOfFileProcessed;
			} catch (Error e) {
				if (e.getErroeCode() == 1001) {
					System.out.println(e.getErrorMessage());
				} else {
					e.printStackTrace();
					System.out.println("unable to process file");
				}
			}
		}
		return numberOfFileProcessed;
	}

}
