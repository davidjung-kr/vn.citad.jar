package vn.citad.test;

import vn.citad.gaw.OtfWriter;

public class TestGawOtfWriter implements TestUnit {
	public void assertTest() throws TestException {
		OtfWriter ow = new OtfWriter();
		
		ow.setHeader(new String[]{
			"HH",
			"21234567",
			"GAWOTF19980101.123456",
			"19980101",
			"00000001"
		});

		String result = ow.fetch();
		
		result = result.trim();
		
		int i = 0;
		if(!("HH21234567    GAWOTF19980101.123456    1998010100000001").equals(result)) {
			throw new TestException("[FAIL] TestGawOtf : `"+result+"`");
		}
		System.out.println("[PASS] TestGawOtf");
	}

}