package tousanticovid.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class BigNumbers {
	
	public static String FormatConvert(int number) {
		BigDecimal  no = new BigDecimal(number);
		
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setGroupingSeparator(' ');

		DecimalFormat formatter = new DecimalFormat("###,###.##", symbols);
		
		return formatter.format(no.longValue());
	}

	
}
