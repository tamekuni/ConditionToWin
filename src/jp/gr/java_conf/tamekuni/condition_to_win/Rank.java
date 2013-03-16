package jp.gr.java_conf.tamekuni.condition_to_win;

public enum Rank {
	UNKNOWN(0), RANK1(1), RANK2(2), RANK3(3), RANK4(4);

	private int mValue;
	private static final int SIZE = 5;

	private Rank(int aValue) {
		mValue = aValue;
	}

	public int toValue() {
		return mValue;
	}

	public static Rank toRank(int aValue) {
		if (aValue == RANK1.toValue()) {
			return RANK1;
		}
		if (aValue == RANK2.toValue()) {
			return RANK2;
		}
		if (aValue == RANK3.toValue()) {
			return RANK3;
		}
		if (aValue == RANK4.toValue()) {
			return RANK4;
		}
		return UNKNOWN;
	}

	public static int size() {
		return SIZE;
	}
}
