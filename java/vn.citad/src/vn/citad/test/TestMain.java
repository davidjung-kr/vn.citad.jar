package vn.citad.test;
/**
 * [ VIETNAM CITAD ] TestMain
 * 	- 단위 테스트를 일괄로 수행한다.
 * ※ By David Jung
 * 
 * ※ License: LGPL-v2.1 (https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html)
 * ※ See: https://github.com/davidjung-kr/vn.citad.jar
 */
import vn.citad.Mac;

import vn.citad.*;

public class TestMain {
	public static void main(String[] args) throws Exception {
		System.out.println("----- Unit Test from Main func -----");
		
		// 테스트 목록 정의
		TestUnit[] unitList = {
				new TestUtilSha256(),
				new TestUtilBase64(),
				new TestUtilTrimer()
		};
		
		// 테스트 수행
		for(int i=0; i<unitList.length; i++)
			{ unitList[i].assertTest(); }
		
		System.out.printf("\n");

		System.out.println("----- MAC Generator -----");
		String contentMsg = "HH10302022DD201001ADD101001BTT10302022";
		Mac mac = new Mac(contentMsg);
		
		System.out.printf("* Input data:\n%s\n\n",	contentMsg);
		System.out.printf("* MAC result:\n%s",		mac.fetch());
	}
}
