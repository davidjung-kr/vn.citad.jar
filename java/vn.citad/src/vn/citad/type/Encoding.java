package vn.citad.type;
/**
 * [ VIETNAM CITAD ] (E)Encoding
 * 	- 표준 구현은 UTF-16을 기반으로 하나, JVM 기본 String의 캐릭터셋은 UTF-8이므로 이를 지원하기 위한 타입 정의
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
public enum Encoding {
	UTF8,
	UTF16
}