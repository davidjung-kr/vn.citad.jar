package vn.citad.test;
/**
 * [ VIETNAM CITAD ] TestUtilTrimer
 * 	- Trimer 단위 테스트
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import vn.citad.util.Trimer;

public class TestUtilTrimer implements TestUnit {
	public void assertTest() throws TestException {
		String target = "HH 123\nDD 1234\n\tTT1234   ";
		String result = Trimer.trimAll(target);
		if( !"HH123DD1234TT1234".equals(result) ) {
			throw new TestException("[FAIL] TestUtilTrimer: " + Trimer.trimAll(target));
		}
		System.out.println("[PASS] TestUtilTrimer");
	}
}