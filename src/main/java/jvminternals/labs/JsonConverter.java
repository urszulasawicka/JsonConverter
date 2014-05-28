package jvminternals.labs;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class JsonConverter implements JsonConverterInterface {
	
    public static final String boolName = "boolean";
    public static final String stringName = "java.lang.String";
    public static final String intName = "int";
    public static final String listName = "java.util.List";
	
	@Override
	public <T> String toJson(T obj) throws JsonConverterException, IllegalArgumentException, IllegalAccessException {
		
		if (obj == null) {
			throw new JsonConverterException("null object converion");
		}
		System.out.println("{");
		
		for (Field f : obj.getClass().getDeclaredFields()){
			try {
				switch(f.getType().getCanonicalName()){
					case JsonConverter.boolName:
						System.out.println(f.getName() + " : " + f.getBoolean(obj) + ",");
						break;
					case JsonConverter.stringName:
						System.out.println(f.getName() + " : \"" + f.get(obj).toString() + "\",");
						break;
					case JsonConverter.intName:
						System.out.println(f.getName() + " : " + f.getInt(obj) + ",");
						break;
					case JsonConverter.listName:
						printList(f, obj);
						break;
					default:
						System.out.println(f.getType().getCanonicalName());
						System.out.println(f.getName() + " : \"" + f.get(obj).toString() + "add\",");
				}
			} catch (java.lang.IllegalAccessException e) {
				
			}

		}
		
		System.out.println("}");
		return "foo";

	}
	private void printList(Field f, Object obj) throws IllegalArgumentException, IllegalAccessException{
		System.out.print(f.getName() + " : [");
		List list = (List) f.get(obj);
		for (Object o : list){
			System.out.print(o.toString());
			if(list.lastIndexOf(o) == list.size()-1){
				break;
			}
			System.out.print(",");
		}
		System.out.println("]");
	}

	@Override
	public <T> T fromJson(String json, Class<T> cls)
			throws JsonConverterException {
		try {
			return (T) cls.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new JsonConverterException(e);
		}
	}

}
