package vn.citad.type;

public class OtfData {
	private final int length = 44;

	private final String[] fieldNames = {
		"REC_TYPE",
		"TRX_TYPE",
		"SD_TIME",
		"SERIAL_NO",
		"RELATION_NO",
		"RESPONSE_CODE",
		"O_CI_CODE",
		"R_CI_CODE",
		"O_INDIRECT_CODE",
		"R_INDIRECT_CODE",
		
		"FEE_CI_CODE",
		"TRX_DATE",
		"CURRENCY",
		"EXCHANGE_RATE",
		"AMOUNT",
		"SD_CODE",
		"SD_NAME",
		"SD_ADDR",
		"SD_ACCNT",
		"SD_ID_NO",
		
		"SD_ISSUE_DATE",
		"SD_ISSUER",
		"RV_CODE",
		"RV_NAME",
		"RV_ADDR",
		"RV_ACCNT",
		"RV_ID_NO",
		"RV_ISSUE_DATE",
		"RV_ISSUER",
		"CONTENT",
		
		"CUS_TYPE",
		"AUTHORIZED",
		"FEE_FLAG",
		"REFERENCE",
		"EX_E_SIGN",
		"CREATE_TIME",
		"APPR_ID",
		"E_SIGN",
		"OPTION1",
		"OPTION2",
		
		"OPTION3",
		"SPACE",
		"MAC",
		"CONTENT_EX"
		
	};
	
	private final int[] fieldSizes = {
		  2,   6,  14,   8,  40,   4,  12,  12,  12,  12,
		 12,   8,   3,  12,  22,  20,  70, 100,  25,  20,
		  8,  25,  20,  70, 100,  25,  20,   8,  25, 210,
		  3,   1,   1, 100, 400,  14,  16, 400,  20,  30,
		 40,  50,  44, 3000
	};
	
	private final boolean[] fieldMandatory = {
		 true,  true, false, false,  true, false,  true,  true,  true,  true,
		 true,  true,  true, false,  true, false,  true, false,  true, false,
		false, false, false,  true, false,  true, false, false, false,  true,
		 true, false, false, false, false, false, false, false, false, false,
		false, false, false, false
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
