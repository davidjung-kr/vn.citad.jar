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
import vn.citad.type.UtfBytes;
import vn.citad.util.Sha256;
import vn.citad.util.Trimer;

public class Mac {
	private String contentMsg;
	
	/**
	 * Initialize
	 * @param contentMsg
	 */
	public Mac(String contentMsg){
		// 입력 받은 전문에 여백&공백 모두 제거
		this.contentMsg = Trimer.trimAll(contentMsg);
	}
	
	/**
	 * Get file MAC value.
	 * @return MAC result (Message -> UTF-16 Bytes -> SHA256 but represent to Base64 string)
	 * @throws UnsupportedEncodingException 
	 */
	public String fetch() throws UnsupportedEncodingException {
		Sha256 hash;
		UtfBytes u16bytes = new UtfBytes(this.contentMsg, Encoding.UTF16);
		try {
			hash = new Sha256(u16bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return hash.toBase64String();
	}
}