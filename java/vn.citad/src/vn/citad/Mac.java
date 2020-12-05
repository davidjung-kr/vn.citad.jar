package vn.citad;
/**
 * [ VIETNAM CITAD ] Mac
 * 	- 파일 MAC 산출 수행
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import java.io.UnsupportedEncodingException;
import vn.citad.type.Encoding;
import vn.citad.type.Utf16Bytes;
import vn.citad.util.Base64;
import vn.citad.util.Sha256;
import vn.citad.util.Trimer;

public class Mac {
	private String contentMsg;
	public Mac(String contentMsg){
		// 입력 받은 전문에 여백/공백 모두 제거
		this.contentMsg = Trimer.trimAll(contentMsg);
	}
	
	/**
	 * Get MAC value
	 * @return MAC result (Message -> UTF-8 Bytes -> SHA256 -> Base64)
	 * @throws UnsupportedEncodingException 
	 */
	public String fetch() throws UnsupportedEncodingException {
		Sha256 hash;
		Base64 encoder;
		Utf16Bytes encoding = new Utf16Bytes(this.contentMsg);
		try {
			hash = new Sha256(encoding.getBytes(), Encoding.UTF16);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		encoder = new Base64(hash.toString());
		return encoder.toString();
	}
}