/**
 * 
 */
package ar.com.notarip.bridge.util;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.util.DigestUtils;

/**
 * @author pablo
 *
 */
public class SlugHelper {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	public static String toSlug(String input) {
		String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}
	
	public static String toHashSlug(String input){
		
		byte[] md5Digest = DigestUtils.md5Digest(input.getBytes());
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(md5Digest).substring(0,5);
		
		return toSlug(md5DigestAsHex);
		
	}

	public static String toFullSlug(Date timestamp, String slug) {

		StringBuilder sb = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		sb.append(cal.get(Calendar.YEAR));
		sb.append(".");
		sb.append(cal.get(Calendar.MONTH));
		sb.append(".");
		sb.append(cal.get(Calendar.DAY_OF_MONTH));
		sb.append(".");
		sb.append(cal.get(Calendar.HOUR));
		sb.append(":");
		sb.append(cal.get(Calendar.MINUTE));
		sb.append(":");
		sb.append(slug);

		return sb.toString();
	}

}
