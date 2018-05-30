package com.accolite.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.accolite.bean.Employee;

public class ObjectToXml {
	public void convertToXml(Employee employee) {
		try {
			JAXBContext jaxbContext=JAXBContext.newInstance(Employee.class);
			Marshaller marshaller=jaxbContext.createMarshaller();
			OutputStream outputStream=new FileOutputStream(new File("employee.xml"));
			marshaller.marshal(employee, outputStream);
			System.out.println("Xml File Created in current path");
		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
