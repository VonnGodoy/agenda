package br.gdtech.agenda.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumUtil {

	public static List<EnumDecription> toList(Class<? extends Enum> enn) throws Exception {
		return toList(Arrays.asList(enn.getEnumConstants()));
	}

	public static List<EnumDecription> toList(List<? extends Enum> enn) throws Exception {
		List<EnumDecription> retorno = new ArrayList<EnumDecription>();

		for (Enum e : enn) {
			retorno.add(new EnumDecription(e.name(), String.valueOf(PropertyUtil.getValue(e, "nome"))));
		}
		return retorno;
	}

}
