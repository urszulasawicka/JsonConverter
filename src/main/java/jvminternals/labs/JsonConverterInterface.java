package jvminternals.labs;

public interface JsonConverterInterface {
	public <T> String toJson(T obj) throws JsonConverterException, IllegalArgumentException, IllegalAccessException;
	public <T> T fromJson(String json, Class<T> cls) throws JsonConverterException;
}
