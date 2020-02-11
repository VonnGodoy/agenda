package br.gdtech.agenda.util;

import lombok.Data;

@Data
public class EnumDecription {

	String key;
	String nome;

	public EnumDecription(String key, String nome) {
		this.key = key;
		this.nome = nome;
	}
	
	public static <T extends Enum<T>> T getEnum(Class<T> enumeration, String name) {
		for(T enumValue : enumeration.getEnumConstants()) {
			if(enumValue.name().equalsIgnoreCase(name))
				return enumValue;
		}
		return null;
	}

}
