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

	public static void main(String[] args) {
		List<String> fileList = new ArrayList<String>();
		fileList.add("employee1.ser");
		fileList.add("employee2.ser");
		fileList.add("employee3.ser");
		fileList.add("employee4.ser");
		fileList.add("employee3.ser");
		fileList.add("employee5.ser");
		Converter converter = new FileConvertor();
		/*
		 * try {
		 * 
		 * Employee employee=new Employee("E5", "Basant", "SSE", "Bangalore");
		 * ObjectOutputStream outputStream=new ObjectOutputStream(new
		 * FileOutputStream(new File("./employee5.ser")));
		 * outputStream.writeObject(employee); } catch (Exception e) { }
		 */
		for (String file : fileList) {
			try {
				Employee employee = converter.readAndConvert(file);
				ObjectToXml objectToXml = new ObjectToXml();
				objectToXml.convertToXml(employee);
			} catch (Error e) {
				if (e.getErroeCode() == 1001) {
					System.out.println(e.getErrorMessage());
				} else {
					e.printStackTrace();
					System.out.println("unable to process file");
				}
			}
		}
	}

}
