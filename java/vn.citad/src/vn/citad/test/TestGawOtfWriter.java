package vn.citad.test;

import vn.citad.gaw.OtfWriter;

public class TestGawOtfWriter implements TestUnit {
	public void assertTest() throws TestException {
		OtfWriter ow = new OtfWriter();

		ow.setHeader(0, "HH");
		ow.setHeader(1, "79640001");
		ow.setHeader(2, "GAWOTF19980101.123456");
		ow.setHeader(3, "19980101");
		ow.setHeader(4, "0000001");
		String result = ow.fetch().trim();
		if(!("HH    79640001GAWOTF19980101.123456    199801010000001").equals(result)) {
			throw new TestException("[FAIL] TestGawOtf : `"+result+"`");
		}
		System.out.println("[PASS] TestGawOtf");
	}

}