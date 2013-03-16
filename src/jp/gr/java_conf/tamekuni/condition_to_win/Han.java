package jp.gr.java_conf.tamekuni.condition_to_win;

public enum Han {
	CANNOT(-1, "無理"), HAN1(0, "1翻"), HAN2(1, "2翻"), HAN3(2, "3翻"), HAN4(3, "4翻"), MANGAN(
			0, "満貫"), HANEMAN(1, "跳満"), BAIMAN(2, "倍満"), SANBAIMAN(3, "三倍満"), YAKUMAN(
			4, "役満");

	private int mValue;
	private String mString;

	Han(int aValue, String aString) {
		mValue = aValue;
		mString = aString;
	}

	public int toValue() {
		return mValue;
	}

	public String toString() {
		return mString;
	}

	public static Han toHan(int aValue) {
		if (aValue == HAN1.toValue()) {
			return HAN1;
		}
		if (aValue == HAN2.toValue()) {
			return HAN2;
		}
		if (aValue == HAN3.toValue()) {
			return HAN3;
		}
		if (aValue == HAN4.toValue()) {
			return HAN4;
		}
		return CANNOT;
	}

	public static Han toOrverMangan(int aValue) {
		if (aValue == MANGAN.toValue()) {
			return MANGAN;
		}
		if (aValue == HANEMAN.toValue()) {
			return HANEMAN;
		}
		if (aValue == BAIMAN.toValue()) {
			return BAIMAN;
		}
		if (aValue == SANBAIMAN.toValue()) {
			return SANBAIMAN;
		}
		if (aValue == YAKUMAN.toValue()) {
			return YAKUMAN;
		}

		return CANNOT;
	}
}
