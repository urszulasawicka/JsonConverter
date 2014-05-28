package jvminternals.labs;

import static org.junit.Assert.*;
import jvminternals.model.SampleClass;

import org.junit.Test;

class TestClass {
	public int SomeField;
	public TestClass() { }
}

public class JsonConverterTests {

	@Test
	public void testFromJson() throws JsonConverterException {
		JsonConverterInterface json = new JsonConverter();
		TestClass tc = json.fromJson("SomeField: 1", TestClass.class);
		assertNotNull(tc);
	}

	@Test
	public void testToJson() throws JsonConverterException, IllegalArgumentException, IllegalAccessException {
		JsonConverterInterface json = new JsonConverter();
		//String s = json.toJson(new TestClass());
		//String s = json.toJson(new SampleClass());
		String s = json.toJson(new SampleClass(1990,24));
		assertNotNull(s);
		assertNotEquals(s,"");
		
	}
}
