package vn.citad.type;



public class OtfHeader {
	public enum PADDING {
		NONE,
		LEFT,
		RIGHT
	}
	
	public static final int length = 5;
	public String[] fields = new String[length];
	private final String[] fieldNames = {
		"REC_TYPE",
		"CI_CODE",
		"FILE_NAME",
		"TR_DATE",
		"DATA_CNT"
	};
	
	public final PADDING[] fieldPadding = {
			PADDING.NONE,
			PADDING.LEFT,
			PADDING.RIGHT,
			PADDING.NONE,
			PADDING.NONE
	};
	
	private final int[] fieldSizes = {
		2, 12, 25, 8, 8
	};
	
	private final boolean[] fieldMandatory = {
		true,
		true,
		true,
		true,
		true		
	};
	
	public void setFields(String[] array) {
		this.fields = array;
	}
	
	public void setField(int index, String value) {
		this.fields[index] = value;
	}
	
	public int getFieldIndex(String fieldName) {
		int result = -1;
		for(int i=0; i<fieldNames.length; i++) {
			if(fieldNames[i].equals(fieldName)) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	public String getFieldName(int index) {
		return this.fieldNames[index];
	}
	
	public int getFieldSize(int index) {
		return this.fieldSizes[index];
	}
	
	public int getFieldSize(String fieldName) {
		int index = -1;
		for(int i=0; i<fieldNames.length; i++) {
			if(fieldName.equals(fieldNames[i]) ) {
				index = i;
				break;
			}
		}
		return fieldSizes[index];
	}
	
	public boolean isFieldMandatory(int index) {
		return this.fieldMandatory[index];
	}
	
	public boolean isFieldMandatory(String fieldName) {
		int index = this.getFieldIndex(fieldName);
		return index>=0 ? fieldMandatory[index]:false; // -1일 때 무조건 false
	}
	
	public String getFieldValue(int index) {
		return this.fields[index];
	}
}