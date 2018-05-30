package com.accolite.main;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.accolite.bean.Employee;
import com.accolite.exception.Error;
import com.accolite.util.Converter;
import com.accolite.util.FileConvertor;

public class FileToXmlTest {
	private static FileToXml fileToXml;
	private Converter converter;
	String serializedFileName;
	Employee expected;

	@Before
	public void init() {
		converter = new FileConvertor();
		serializedFileName = "./employee.ser";
		expected = new Employee("E1", "Basant", "SSE", "Bangalore");
		try (ObjectOutputStream outputStream = new ObjectOutputStream(
				new FileOutputStream(new File(serializedFileName)))) {
			outputStream.writeObject(expected);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileConverterTest() {
		Employee actual = null;
		actual = converter.readAndConvert(serializedFileName);
		assertEquals(expected, actual);
	}

	@Test(expected = Error.class)
	public void fileConverterExceptionTest() {
		Employee actual = null;
		actual = converter.readAndConvert("ab.ser");
		assertEquals(expected, actual);
	}
	@Test
	public void convertToXmlTest() {
		List<String> fileList = new ArrayList<String>();
		int max=6;
		for(int i=1;i<max;i++) {
			fileList.add("./employee"+i+".ser");
		}
		int expectedCount=max-1;
		int actualCount=fileToXml.convertToXml(fileList);
		assertEquals(expectedCount, actualCount);
	}

	@After
	public void destroy() {
		File file = new File(serializedFileName);
		file.delete();
	}

	@BeforeClass
	public static void create() {
		fileToXml=new FileToXml();
		Converter converter=new FileConvertor();
		fileToXml.setConverter(converter);
		for(int i=1;i<6;i++) {
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("./employee"+i+".ser")))) {
			Employee employee = new Employee("E"+i, "Basant", "SSE", "Bangalore");
			outputStream.writeObject(employee);
		} catch (Exception e) {
		}
		}
	}

	@AfterClass
	public static void delete() {
		for(int i=1;i<6;i++) {
			File file=new File("./employee"+i+".ser");
			file.delete();
		}
	}
}
