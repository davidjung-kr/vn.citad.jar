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
		String result = ow.fetch();
		int i = 0;
		if(!("HH79640001GAWOTF19980101.123456199801010000001\r\n"
				+ "\r\n"
				+ "").equals(result)) {
			throw new TestException("[FAIL] TestGawOtf");
		}
		System.out.println("[PASS] TestGawOtf");
	}

}