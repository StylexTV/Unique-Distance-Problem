package de.stylextv.udp.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MathUtil {
	
	public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
	
}
