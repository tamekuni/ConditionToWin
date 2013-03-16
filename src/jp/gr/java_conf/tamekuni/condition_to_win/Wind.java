package jp.gr.java_conf.tamekuni.condition_to_win;

public enum Wind {
	TON(0, "東"), NAN(1, "南"), SYA(2, "西"), PEI(3, "北");

	private int mValue;
	private String mString;
	private static final int SIZE = 4;

	private Wind(int aValue, String aString) {
		mValue = aValue;
		mString = aString;
	}

	public int toValue() {
		return mValue;
	}

	public static int size() {
		return SIZE;
	}

	public String toString() {
		return mString;
	}

	public static Wind toWind(int aValue) {
		if (aValue == TON.toValue()) {
			return TON;
		}
		if (aValue == NAN.toValue()) {
			return NAN;
		}
		if (aValue == SYA.toValue()) {
			return SYA;
		}
		if (aValue == PEI.toValue()) {
			return PEI;
		}
		return TON;
	}

	public Wind getKamitya() {
		return Wind.toWind((mValue + 3) % 4);
	}

	public Wind getToimen() {
		return Wind.toWind((mValue + 2) % 4);
	}

	public Wind getShimotya() {
		return Wind.toWind((mValue + 1) % 4);
	}
}
