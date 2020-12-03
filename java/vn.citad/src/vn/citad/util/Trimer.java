package vn.citad.util;
/**
 * [ VIETNAM CITAD ] Trimer
 * 	- 문자열 내 개행, 스페이스 삭제
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
public class Trimer {
	public static String trimAll(String target) {
		return target	.replaceAll(" ",									"")		// SPACE
						.replaceAll("\t",									"")		// TAB
						.replaceAll("\n",									"")		// NL
						.replaceAll(System.getProperty("line.separator"),	"");	// NL
	}
}