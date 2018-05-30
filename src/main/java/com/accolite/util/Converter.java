package com.accolite.util;


import com.accolite.bean.Employee;

public interface Converter {
	public Employee readAndConvert(String filePath);
}
