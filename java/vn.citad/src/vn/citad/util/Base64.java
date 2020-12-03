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
	private String contentMsg;
	
	/**
	 * Init
	 * @param target
	 */
	public Base64(String target) {
		this.contentMsg = target;
	}
	
	public String toString() {
		Encoder encoder = java.util.Base64.getEncoder();
		byte[] tmp = encoder.encode(this.contentMsg.getBytes());
		String result = new String(tmp); // byte to string
		return result;
	}
}