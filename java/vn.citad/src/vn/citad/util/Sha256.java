package vn.citad.util;
/**
 * [ VIETNAM CITAD ] Sha256
 * 	- String to Sha256 String
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import java.security.MessageDigest;

public class Sha256 {
	private byte[] target;
	
	public Sha256(String target) {
		this.target = target.getBytes();
	}
	
	public Sha256(byte[] target) {
		this.target = target;
	}
	
	public String toString() {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(this.target);
			
			StringBuffer strBf = new StringBuffer();
			
			for(int i=0; i<hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1)
					strBf.append('0');
				strBf.append(hex);
			}
			String result = strBf.toString();
			return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}