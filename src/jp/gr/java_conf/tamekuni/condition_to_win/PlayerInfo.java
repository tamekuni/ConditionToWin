package jp.gr.java_conf.tamekuni.condition_to_win;

import jp.gr.java_conf.tamekuni.condition_to_win.Rank;

class PlayerInfo {

	private int mPoint;
	private Rank mRank;

	PlayerInfo() {
		mPoint = 0;
		mRank = Rank.UNKNOWN;
	}

	int getPoint() {
		return mPoint;
	}

	void setPoint(int aPoint) {
		mPoint = aPoint;
	}

	Rank getRank() {
		return mRank;
	}

	void setRank(Rank aRank) {
		mRank = aRank;
	}

	/**
	 * 
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { System.out.println("Hello");
	 * Player player = new Player();
	 * 
	 * System.out.println(player.getPoint() + " " +
	 * player.getRank().getValue()); player.setPoint(100);
	 * player.setRank(Rank.RANK4); System.out.println(player.getPoint() + " " +
	 * player.getRank().getValue());
	 * 
	 * }
	 */
}
