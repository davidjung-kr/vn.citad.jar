package vn.citad.type;
/**
 * [ VIETNAM CITAD ] Utf16Bytes
 * 	- UTF-16 타입 정의
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import java.io.UnsupportedEncodingException;

public class Utf16Bytes {
	private byte[] bytes;
	
	public Utf16Bytes(String target) throws UnsupportedEncodingException {
		this.bytes = target.getBytes("UTF-16");
	}
	
	public String toString() {
		return this.bytes.toString();
	}
	
	public byte[] getBytes() {
		return this.bytes;
	}
}