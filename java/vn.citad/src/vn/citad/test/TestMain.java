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
import vn.citad.type.UtfBytes;
import vn.citad.type.Encoding;
import vn.citad.test.*;
import vn.citad.util.Sha256;

public class TestMain {
	public static void main(String[] args) throws Exception {
		System.out.println("----- Unit Test from Main func -----");
		
		// 테스트 목록 정의
		TestUnit[] unitList = {
				new TestUtilSha256(),
				new TestUtilBase64(),
				new TestUtilTrimer(),
				new TestGawOtf()
		};
		
		// 테스트 수행
		for(int i=0; i<unitList.length; i++)
			{ unitList[i].assertTest(); }
		
		System.out.printf("\n");

		System.out.println("----- MAC Generator -----");
		
		String contentMsg = "HH10302022DD201001ADD101001BTT10302022";
		UtfBytes u8bytes = new UtfBytes(contentMsg, Encoding.UTF8);
		UtfBytes u16bytes = new UtfBytes(contentMsg, Encoding.UTF16);
		
		System.out.printf("* Input data:\n%s\n\n",					contentMsg);
		System.out.printf("* SHA-256 Result(from UTF-8):\n%s\n\n",	new Sha256(u8bytes).toString());
		System.out.printf("* SHA-256 Result(from UTF-16):\n%s\n\n",	new Sha256(u16bytes).toString());
		System.out.printf("* MAC result:\n%s",						new Mac(contentMsg).fetch());
	}
}
