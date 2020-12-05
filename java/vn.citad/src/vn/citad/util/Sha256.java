package vn.citad.util;
import java.nio.charset.StandardCharsets;
/**
 * [ VIETNAM CITAD ] Sha256
 * 	- String to Sha256 String
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import java.security.MessageDigest;
//import java.util.Base64;
import vn.citad.util.Base64;
import vn.citad.type.Encoding;
import vn.citad.type.UtfBytes;

public class Sha256 {
	private byte[] target;
	private Encoding charset = Encoding.UTF8;
	
	public Sha256(String target) {
		this.target = target.getBytes();
	}
	
	public Sha256(UtfBytes target) {
		this.target = target.getBytes();
		this.charset = Encoding.UTF16;
	}
	
	public Sha256(byte[] target, Encoding charset) {
		this.target = target;
		this.charset = charset;
	}
	
	public Encoding getCharset() {
		return this.charset;
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
	
	public String toBase64String() {
		byte[] hash = {};
		String result = "";
		try {
			hash = MessageDigest.getInstance("SHA-256").digest(this.target);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		result = new String(Base64.encoding(hash));
		return result;
	}
}