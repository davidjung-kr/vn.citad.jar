package vn.citad.test;
/**
 * [ VIETNAM CITAD ] (I)TestUnit
 * 	- 단위테스트 
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import vn.citad.test.TestException;
public interface TestUnit {
	public void assertTest() throws TestException;
}
