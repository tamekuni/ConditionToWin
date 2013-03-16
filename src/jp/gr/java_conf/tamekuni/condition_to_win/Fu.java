package jp.gr.java_conf.tamekuni.condition_to_win;

public enum Fu {
	FU20(0, "20符"), FU25(1, "25符"), FU30(2, "30符"), FU40(3, "40符"), FU50(4,
			"50符"), FU60(5, "60符"), FU70(6, "70符"), FU80(7, "80符"), FU90(8,
			"90符"), FU100(9, "100符"), FU110(10, "110符");

	private int mValue;
	private String mString;

	private Fu(int aValue, String aString) {
		mValue = aValue;
		mString = aString;
	}

	public int toValue() {
		return mValue;
	}

	public String toString() {
		return mString;
	}

}
