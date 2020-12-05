package vn.citad.type;
/**
 * [ VIETNAM CITAD ] UtfBytes
 * 	- UTF-16 타입 정의
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import java.io.UnsupportedEncodingException;
import vn.citad.type.Encoding;
import vn.citad.type.Encoding;

public class UtfBytes {
	private byte[] bytes;
	private Encoding charset = Encoding.UTF16;
	
	/**
	 * Initialize
	 * @param target
	 * @param charset
	 * @throws UnsupportedEncodingException
	 */
	public UtfBytes(String target, Encoding charset) throws UnsupportedEncodingException {
		String encoding = "";
		switch(charset) {
		case UTF16:
			encoding = "UTF-16";
			break;
		default:
			encoding = "UTF-8";
			break;
		}
		this.bytes = target.getBytes(encoding);
	}
	
	/**
	 * Initialize. Default character set is 'UTF-8'.
	 * @param target
	 * @throws UnsupportedEncodingException
	 */
	public UtfBytes(String target) throws UnsupportedEncodingException {
		this.bytes = target.getBytes("UTF-8");
	}
	
	/**
	 * (Getter) String
	 */
	public String toString() {
		return this.bytes.toString();
	}
	
	/**
	 * (Getter) Bytes
	 */
	public byte[] getBytes() {
		return this.bytes;
	}

	/**
	 * (Getter) Character set
	 */
	public Encoding getCharset() {
		return this.charset;
	}
}