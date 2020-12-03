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
import vn.citad.util.Base64;
import vn.citad.util.Sha256;
import vn.citad.util.Trimer;

public class Mac {
	private String contentMsg;
	public Mac(String contentMsg){
		// 입력 받은 전문에 여백/공백 모두 제거
		this.contentMsg = Trimer.trimAll(contentMsg);
	}
	
	// UTF-8 배열로 생성 (CITAD Spec 2.5 참고)
	private static byte[] getUtf8Bytes(String target) throws UnsupportedEncodingException {
		return target.getBytes("UTF-8");
	}
	
	/**
	 * Get MAC value
	 * @return MAC result (Message -> UTF-8 Bytes -> SHA256 -> Base64)
	 */
	public String fetch() {
		Sha256 hash;
		Base64 encoder;
		try {
			hash = new Sha256(this.getUtf8Bytes(this.contentMsg));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		encoder = new Base64(hash.toString());
		return encoder.toString();
	}
}