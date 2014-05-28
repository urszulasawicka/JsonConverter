package jvminternals.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SampleClass implements SampleInterface{
	
	public int integerValue;
	public TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	public boolean booleanValue = true;
	public String stringValue = new String("Ala");
	public List<String> publicList = new ArrayList<String>();
	
	public SampleClass() {
	}
	
	public SampleClass(int integerValue, int integerPrivateValue) {
		super();
		publicList.add("ala");
		publicList.add("kota");
		map.put("ala", 1);
		map.put("kota", 2);
		this.integerValue = integerValue;
	}
	
	@Override
	public void doSomething() {
	}

	public int getIntegerValue() {
		return integerValue;
	}

	public void setIntegerValue(int integerValue) {
		this.integerValue = integerValue;
	}

	public boolean isBooleanValue() {
		return booleanValue;
	}

	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	
}
