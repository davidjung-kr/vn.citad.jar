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
	private int length		= 0;
	private String name		= "";
	private String value	= "";
	private boolean isMandatory;
	
	public Field(String name, int length, boolean isMandatory) {
		this.name = name;
		this.length = length;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
