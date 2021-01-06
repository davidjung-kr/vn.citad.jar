package vn.citad.type;

public class OtfHeader extends Record {
	public OtfHeader() {
		super(
			5,
			new String[]{
				"REC_TYPE",
				"CI_CODE",
				"FILE_NAME",
				"TR_DATE",
				"DATA_CNT"
			},
			new int[] {
				2, 12, 25, 8, 8
			},
			new boolean[]{
				true,
				true,
				true,
				true,
				true		
			},
			new Padding[] {
				Padding.NONE,
				Padding.LEFT,
				Padding.RIGHT,
				Padding.NONE,
				Padding.NONE	
			}
		);
	}
}