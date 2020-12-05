package vn.citad.test;
/**
 * [ VIETNAM CITAD ] TestUtilSha256
 * 	- SHA256 컨버팅 테스트
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import vn.citad.util.Sha256;
import vn.citad.test.TestUnit;
import vn.citad.test.TestException;

public class TestUtilSha256 implements TestUnit {
	public void assertTest() throws TestException {
		String target = "Hello world";
		Sha256 obj = new Sha256(target);
		if( !("64ec88ca00b268e5ba1a35678a1b5316d212f4f366b2477232534a8aeca37f3c".equals(obj.toString())) ) {
			throw new TestException("[FAIL] TestUtilSha256 - toString: " + obj.toString());
		}
		
		
		if( !("ZOyIygCyaOW6GjVnihtTFtIS9PNmskdyMlNKiuyjfzw=".equals(obj.toBase64String())) ) {
			throw new TestException("[FAIL] TestUtilSha256 - toBase64String: " + obj.toBase64String());
		}
		
		System.out.println("[PASS] TestUtilSha256");
	}
}