package vn.citad.type;
/**
 * [ VIETNAM CITAD ] Field
 * 	- 데이터 필드 타입 정의
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
public class Field {
	private int length;
	private String name;
	private boolean isMandatory;
	public Field(String name, int length, boolean isMandatory) {
		this.name = name;
		this.length = length;
	}
}
