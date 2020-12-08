package vn.citad.gaw;
/**
 * [ VIETNAM CITAD ] Otf
 * 	- Out-going
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
public class Otf {
	private Field[] fields = {
		new Field("REC_TYPE",	2,	true),
		new Field("TRX_TYPE",	6,	true)
	};
}

class Field {
	private int length;
	private String name;
	private boolean isMandatory;
	public Field(String name, int length, boolean isMandatory) {
		this.name = name;
		this.length = length;
	}
	
}