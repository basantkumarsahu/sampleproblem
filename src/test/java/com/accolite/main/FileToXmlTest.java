package com.accolite.main;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accolite.bean.Employee;
import com.accolite.exception.Error;
import com.accolite.util.Converter;
import com.accolite.util.FileConvertor;

public class FileToXmlTest {
	private Converter converter;
	String serializedFileName;
	Employee expected;
	@Before
	public void init() {
		converter=new FileConvertor();
		serializedFileName="./employee.ser";
		expected=new Employee("E1", "Basant", "SSE", "Bangalore");
		try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(new File(serializedFileName)))){
		outputStream.writeObject(expected);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void fileConverterTest() {
		Employee actual=null;
		actual=converter.readAndConvert(serializedFileName);
		assertEquals(expected,actual);
	}
	
	@Test(expected=Error.class)
	public void fileConverterExceptionTest() {
		Employee actual=null;
		actual=converter.readAndConvert("ab.ser");
		assertEquals(expected,actual);
	}
	@After
	public void destroy() {
		File file=new File(serializedFileName);
		file.delete();
	}
}
