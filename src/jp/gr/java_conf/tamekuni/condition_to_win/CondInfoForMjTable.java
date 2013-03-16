package jp.gr.java_conf.tamekuni.condition_to_win;

import jp.gr.java_conf.tamekuni.condition_to_win.Han;

class CondInfoForMjTable {

	static final int CANNOT = -1;

	private int mRonPoint;
	private Han mRonHan;
	private int mChildTsumoPoint;
	private int mParentTsumoPoint;
	private Han mTsumoHan;
	private Fu mFu;
	private ParentChild mParentChild;

	CondInfoForMjTable(Fu aFu, ParentChild aParentChild) {
		mRonPoint = CANNOT;
		mRonHan = Han.CANNOT;
		mChildTsumoPoint = CANNOT;
		mParentTsumoPoint = CANNOT;
		mTsumoHan = Han.CANNOT;
		mFu = aFu;
		mParentChild = aParentChild;
	}

	int getRonPoint() {
		return mRonPoint;
	}

	void setRonPoint(int aValue) {
		mRonPoint = aValue;
	}

	Han getRonHan() {
		return mRonHan;
	}

	void setRonHan(Han aValue) {
		mRonHan = aValue;
	}

	int getChildTsumoPoint() {
		return mChildTsumoPoint;
	}

	void setChildTsumoPoint(int aValue) {
		mChildTsumoPoint = aValue;
	}

	int getParentTsumoPoint() {
		return mParentTsumoPoint;
	}

	void setParentTsumoPoint(int aValue) {
		mParentTsumoPoint = aValue;
	}

	Han getTsumoHan() {
		return mTsumoHan;
	}

	void setTsumoHan(Han aValue) {
		mTsumoHan = aValue;
	}

	Fu getFu() {
		return mFu;
	}

	ParentChild getParentChild() {
		return mParentChild;
	}

}
