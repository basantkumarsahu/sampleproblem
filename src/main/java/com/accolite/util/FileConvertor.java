package com.accolite.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.accolite.bean.Employee;
import com.accolite.exception.Error;

public class FileConvertor implements Converter {
	List<String>serializedFileList;
	
	public FileConvertor() {
		serializedFileList=new ArrayList<String>();
	}
	//read the searilized file from the specified path and create Employee object
	public Employee readAndConvert(String filePath) {
		Employee employee=null;
		
			if(serializedFileList.contains(filePath)) {
				throw new Error(filePath+" file Already Processed", new Throwable(), 1001);
			}
			serializedFileList.add(filePath);
			File searlizedFile=new File(filePath);
			try(ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(searlizedFile))){
			Object obj=inputStream.readObject();
			
			if(obj instanceof Employee) {
				employee=(Employee) obj;
			}
		} catch (IOException | ClassNotFoundException  e) {
			throw new Error("not able to deserialize the file",e,1002);
		}
		
		return employee;
	}

}
