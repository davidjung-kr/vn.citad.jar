package vn.citad.gaw;
/**
 * [ VIETNAM CITAD ] Otf
 * 	- Out-going
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import vn.citad.type.Field;
import vn.citad.type.OtfHeader;
import vn.citad.type.OtfHeader.PADDING;

import java.util.HashMap;

public class OtfWriter {
	private OtfHeader otfHeader = new OtfHeader();
	private HashMap<String, Integer> headerKeys;
	private HashMap<String, Integer> dataKeys;
	private HashMap<String, Integer> trailerKeys;
	
	public OtfWriter(){
		this.headerKeys 	= new HashMap<String, Integer>();
		this.dataKeys		= new HashMap<String, Integer>();
		this.trailerKeys	= new HashMap<String, Integer>();
		
		for(int i=0; i<data.length; i++)
			dataKeys.put(data[i].getName(), i);
		
		for(int i=0; i<trailer.length; i++)
			trailerKeys.put(trailer[i].getName(), i);
	}
	
	// DD
	private Field[] data = {
		new Field("REC_TYPE",		2,		true),
		new Field("TRX_TYPE",		6,		true),
		new Field("SD_TIME",		14,		false),
		new Field("SERIAL_NO",		8,		false),
		new Field("RELATION_NO",	40,		true),
		new Field("RESPONSE_CODE",	4,		false),
		new Field("O_CI_CODE",		12,		true),
		new Field("R_CI_CODE",		12,		true),
		new Field("O_INDIRECT_CODE",	12,	true),
		new Field("R_INDIRECT_CODE",	12,	true),
		
		new Field("FEE_CI_CODE",	12,		true),
		new Field("TRX_DATE",		8,		true),
		new Field("CURRENCY",		3,		true),
		new Field("EXCHANGE_RATE",	12,		false),
		new Field("AMOUNT",			22,		true),
		new Field("SD_CODE",		20,		false),
		new Field("SD_NAME",		70,		true),
		new Field("SD_ADDR",		100,	false),
		new Field("SD_ACCNT",		25,		true),
		new Field("SD_ID_NO",		20,		false),
		
		new Field("SD_ISSUE_DATE",	8,		false),
		new Field("SD_ISSUER",		25,		false),
		new Field("RV_CODE",		20,		false),
		new Field("RV_NAME",		70,		true),
		new Field("RV_ADDR",		100,	false),
		new Field("RV_ACCNT",		25,		true),
		new Field("RV_ID_NO",		20,		false),
		new Field("RV_ISSUE_DATE",	8,		false),
		new Field("RV_ISSUER",		25,		false),
		new Field("CONTENT",		210,	true),
		
		new Field("CUS_TYPE",		3,		true),
		new Field("AUTHORIZED",		1,		false),
		new Field("FEE_FLAG",		1,		false),
		new Field("REFERENCE",		100,	false),
		new Field("EX_E_SIGN",		400,	false),
		new Field("CREATE_TIME",	14,		false),
		new Field("APPR_ID",		16,		false),
		new Field("E_SIGN",			400,	false),
		new Field("OPTION1",		20,		false),
		new Field("OPTION2",		30,		false),
		
		new Field("OPTION3",		40,		false),
		new Field("SPACE",			50,		false),
		new Field("MAC",			44,		false),
		new Field("CONTENT_EX",		3000,	false)
	};
	
	// trailer
	private Field[] trailer = {
		new Field("REC_TYPE",		2,		true),
		new Field("CI_CODE",		12,		true),
		new Field("FILE_NAME",		25,		true),
		new Field("TR_DATE",		8,		true),
		new Field("DATA_CNT",		8,		true)
	};

	
	public void setHeader(String[] values) {
		this.otfHeader.setFields(values);
	}
	
	public void setHeader(int index, String value) {
		this.otfHeader.setField(index, value);
	}
	
	public boolean setHeader(String name, String value) {
		int index = this.otfHeader.getFieldIndex(name);
		if(index<0)
			return false;
		this.otfHeader.setField(index, value);
		return true;
	}
	
	public void setData(String[] values) {
		for(int i=0; i<values.length; i++) {
			this.data[i].setValue(values[i]);
		}
	}
	
	public void setData(int index, String value) {
		this.data[index].setValue(value);
	}
	
	public void setData(String name, String value) {
		this.data[this.dataKeys.get(name)].setValue(value);
	}
	
	public void setTrailer(String[] values) {
		for(int i=0; i<values.length; i++) {
			this.trailer[i].setValue(values[i]);
		}
	}
	
	public void setTrailer(int index, String value) {
		this.trailer[index].setValue(value);
	}
	
	public void setTrailer(String name, String value) {
		this.data[this.trailerKeys.get(name)].setValue(value);
	}
	
	public String fetch() {
		StringBuffer sb = new StringBuffer();
		
		// 헤더 통합
		for(int i=0; i<this.otfHeader.length; i++) {			
			String paddingDirection	= otfHeader.fieldPadding[i]==PADDING.RIGHT? "-":"";
			String paddingLength	= otfHeader.fieldPadding[i]==PADDING.NONE ? "":String.valueOf(otfHeader.getFieldSize(i));

			sb.append( String.format("%"+paddingDirection+paddingLength+"s", this.otfHeader.getFieldValue(i) ) );
		}
		sb.append("\n");
		
		for(int i=0; i<data.length; i++) {

			String length = String.valueOf(data[i].getLength());
			sb.append( String.format("%"+length+"s", this.data[i].getValue()) );
		}
		sb.append("\n");
		
		for(int i=0; i<trailer.length; i++) {
			String length = String.valueOf(trailer[i].getLength());
			sb.append( String.format("%"+length+"s", this.trailer[i].getValue()) );
		}
		
		return sb.toString();
	}
}