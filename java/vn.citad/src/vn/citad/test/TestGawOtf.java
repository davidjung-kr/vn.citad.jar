package vn.citad.test;

import vn.citad.gaw.Otf;

public class TestGawOtf implements TestUnit {
	public void assertTest() throws TestException {
		Otf otf = new Otf();

		otf.setHeader(0, "HH");
		otf.setHeader(1, "79640001");
		otf.setHeader(2, "GAWOTF19980101.123456");
		otf.setHeader(3, "19980101");
		otf.setHeader(4, "0000001");
		String result = otf.fetch();
		int i = 0;
		if(!("HH79640001GAWOTF19980101.123456199801010000001\r\n"
				+ "\r\n"
				+ "").equals(result)) {
			throw new TestException("[FAIL] TestGawOtf");
		}
		System.out.println("[PASS] TestGawOtf");
	}

}
