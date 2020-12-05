package vn.citad.test;
/**
 * [ VIETNAM CITAD ] TestUtilBase64
 * 	- Base64 인코딩 테스트
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import vn.citad.util.Base64;

public class TestUtilBase64 implements TestUnit {
	public void assertTest() throws TestException {
		String s = Base64.encoding("Hello world");
		if( !("SGVsbG8gd29ybGQ=".equals(s)) ) {
			throw new TestException("[FAIL] TestUtilBase64");
		}
		System.out.println("[PASS] TestUtilBase64");
	}
}