package vn.citad.util;

/**
 * [ VIETNAM CITAD ] Base64
 * 	- String to Base64 String
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import java.util.Base64.Encoder;

public class Base64 {
	/**
	 * Base64 Encoding
	 * @param target
	 */
	public static String encoding(byte[] target) {
		Encoder encoder = java.util.Base64.getEncoder();
		byte[] tmp = encoder.encode(target);
		String result = new String(tmp);
		return result;
	}

	/**
	 * Base64 Encoding
	 * @param target
	 */
	public static String encoding(String target) {
		return Base64.encoding(target.getBytes());
	}
}