package vn.citad.type;

public class Record {
	public		final int		length;
	protected	final String[]	fieldNames;
	protected	final int[]		fieldSizes;
	protected	final boolean[]	fieldMandatory;
	public		final Padding[]	fieldPadding;
	private	String[] fields;
	
	public Record(int length, String[] names, int[] sizes, boolean[] mandatory, Padding[] padding) {
		this.length			= length;
		this.fieldNames		= names;
		this.fieldSizes		= sizes;
		this.fieldMandatory = mandatory;
		this.fieldPadding	= padding;
		this.fields			= new String[this.length];
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
	
	public void setFields(String[] array) {
		this.fields = array;
	}
	
	public void setField(int index, String value) {
		this.fields[index] = value;
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
	
	public String getFieldValue(int index) {
		return this.fields[index];
	}
}