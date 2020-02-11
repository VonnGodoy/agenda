package br.gdtech.agenda.util;

import org.apache.commons.beanutils.PropertyUtils;
import java.lang.reflect.InvocationTargetException;

public class PropertyUtil {

	public static Object getValue(Object obj, String fieldName) {

		try {
			if (PropertyUtils.isReadable(obj, fieldName)) {
				return PropertyUtils.getNestedProperty(obj, fieldName);
			} else {
				return "";
			}
		} catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

//	public static MapExternal getFields(Object obj) throws Exception {
//		Class<?> clazz = obj.getClass();
//		MapExternal elements = new MapExternal();
//		int qtdEx = 0;
//		int qtdIn = 0;
//		for (Field field : clazz.getDeclaredFields()) {
//			field.setAccessible(true);
//			Object val = field.get(obj);
//			if (val != null) {
//				if (field.isAnnotationPresent(ExternalField.class)) {
//					if (val.getClass().isPrimitive() || val instanceof java.lang.String) {
//						qtdEx++;
//					} else {
//						MapExternal elAux = getFields(val);
//						qtdEx += elAux.getQtdExternal();
//						qtdIn += elAux.getQtdInternal();
//					}
//				} else if (val.getClass().isPrimitive() || val instanceof java.lang.String) {
//					qtdIn++;
//				}
//			}
//		}
//		elements.setQtdExternal(qtdEx);
//		elements.setQtdInternal(qtdIn);
//		return elements;
//	}

}
