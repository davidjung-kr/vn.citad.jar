package vn.citad.type;

public class OtfTrailer {
	private final int length = 5;
	private String[] fieldNames = {
		"REC_TYPE",
		"CI_CODE",
		"FILE_NAME",
		"TR_DATE",
		"DATA_CNT"
	};
	
	private final int[] fieldSizes = {
		2, 12, 25, 8, 8,
	};
	
	private final boolean[] fieldMandatory = {
		true,
		true,
		true,
		true,
		true
	};
	
	public int getLength() {
		return this.length;
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
		boolean mandatory = false;
		for(int i=0; i<fieldNames.length; i++) {
			if(fieldNames[i].equals(fieldName)) {
				mandatory = fieldMandatory[i];
				break;
			}
		}
		return mandatory;
	}
}