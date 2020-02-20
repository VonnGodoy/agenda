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

}
