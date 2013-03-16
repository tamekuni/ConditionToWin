package jp.gr.java_conf.tamekuni.condition_to_win;

class MjPointTable {
	static final int NA = -1;

	private static final int[][] mChildRon = { { NA, NA, NA, NA },
			{ NA, 1600, 3200, 6400 }, { 1000, 2000, 3900, 7700 },
			{ 1300, 2600, 5200, 8000 }, { 1600, 3200, 6400, 8000 },
			{ 2000, 3900, 7700, 8000, 8000 }, { 2300, 4500, 8000, 8000 },
			{ 2600, 5200, 8000, 8000 }, { 2900, 5800, 8000, 8000 },
			{ 3200, 6400, 8000, 8000 }, { 3600, 7100, 8000, 8000 } };

	private static final int[] mChildRonMangan = { 8000, 12000, 16000, 24000,
			32000 };

	private static final int[][] mParentRon = { { NA, NA, NA, NA },
			{ NA, 2400, 4800, 9600 }, { 1500, 2900, 5800, 11600 },
			{ 2000, 3900, 7700, 12000 }, { 2400, 4800, 9600, 12000 },
			{ 2900, 5800, 11600, 12000 }, { 3400, 6800, 12000, 12000 },
			{ 3900, 7700, 12000, 12000 }, { 4400, 8700, 12000, 12000 },
			{ 4800, 9600, 12000, 12000 }, { 5300, 10600, 12000, 12000 } };

	private static final int[] mParentRonMangan = { 12000, 18000, 24000, 36000,
			48000 };

	private static final int[][] mChildTsumo = { { NA, 400, 700, 1300 },
			{ NA, NA, 800, 1600 }, { 300, 500, 1000, 2000 },
			{ 400, 700, 1300, 2000 }, { 400, 800, 1600, 2000 },
			{ 500, 1000, 2000, 2000 }, { 600, 1200, 2000, 2000 },
			{ 700, 1300, 2000, 2000 }, { 800, 1500, 2000, 2000 },
			{ 800, 1600, 2000, 2000 }, { 900, 1800, 2000, 2000 } };

	private static final int[] mChildTsumoMangan = { 2000, 3000, 4000, 6000,
			8000 };

	private static final int[][] mParentTsumo = { { NA, 700, 1300, 2600 },
			{ NA, NA, 1600, 3200 }, { 500, 1000, 2000, 3900 },
			{ 700, 1300, 2600, 4000 }, { 800, 1600, 3200, 4000 },
			{ 1000, 2000, 3900, 4000 }, { 1200, 2300, 4000, 4000 },
			{ 1300, 2600, 4000, 4000 }, { 1500, 2900, 4000, 4000 },
			{ 1600, 3200, 4000, 4000 }, { 1800, 3600, 4000, 4000 } };

	private static final int[] mParentTsumoMangan = { 4000, 6000, 8000, 12000,
			16000 };

	// get child ron
	public int[][] getChildRon() {
		return mChildRon;
	}

	public int[] getChildRonMangan() {
		return mChildRonMangan;
	}

	// get parent ron.
	public int[][] getParentRon() {
		return mParentRon;
	}

	public int[] getParentRonMangan() {
		return mParentRonMangan;
	}

	// get child tsumo.
	public int[][] getChildTsumo() {
		return mChildTsumo;
	}

	public int[] getChildTsumoMangan() {
		return mChildTsumoMangan;
	}

	// get parent tsumo.
	public int[][] getParentTsumo() {
		return mParentTsumo;
	}

	public int[] getParentTsumoMangan() {
		return mParentTsumoMangan;
	}
}
