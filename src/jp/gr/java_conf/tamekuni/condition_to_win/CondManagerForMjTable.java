package jp.gr.java_conf.tamekuni.condition_to_win;

import jp.gr.java_conf.tamekuni.condition_to_win.AgariType;
import jp.gr.java_conf.tamekuni.condition_to_win.CondInfoForMjTable;
import jp.gr.java_conf.tamekuni.condition_to_win.Fu;
import jp.gr.java_conf.tamekuni.condition_to_win.MjPointTable;
import jp.gr.java_conf.tamekuni.condition_to_win.ParentChild;

public class CondManagerForMjTable implements CondManagerForMjTableIF {

	private CondInfoForMjTable mCondInfo;
	private MjPointTable mMjPointTable;

	public CondManagerForMjTable(Fu aFu, double aCondPoint,
			ParentChild aParentChild) {
		mCondInfo = new CondInfoForMjTable(aFu, aParentChild);
		mMjPointTable = new MjPointTable();
		setCondInfo(aFu, aCondPoint, aParentChild);
	}

	@Override
	public int getRonPoint() {
		return mCondInfo.getRonPoint();
	}

	@Override
	public Han getRonHan() {
		return mCondInfo.getRonHan();
	}

	@Override
	public int getChildTsumoPoint() {
		return mCondInfo.getChildTsumoPoint();
	}

	@Override
	public int getParentTsumoPoint() {
		return mCondInfo.getParentTsumoPoint();
	}

	@Override
	public Han getTsumoHan() {
		return mCondInfo.getTsumoHan();
	}

	@Override
	public Fu getFu() {
		return mCondInfo.getFu();
	}

	@Override
	public ParentChild getParentChild() {
		return mCondInfo.getParentChild();
	}

	private void setCondInfo(Fu aFu, double aCondPoint, ParentChild aParentChild) {
		setRon(aFu, aCondPoint, aParentChild);
		setTsumo(aFu, aCondPoint, aParentChild);
	}

	private void setRon(Fu aFu, double aCondPoint, ParentChild aParentChild) {
		int[] pointTable = getPointTable(aFu, AgariType.RON, aParentChild);
		int[] pointTableMangan = getPointTableMangan(AgariType.RON,
				aParentChild);
		int mangan = 0;

		if (aParentChild == ParentChild.PARENT) {
			mangan = 12000;
		} else {
			mangan = 8000;
		}

		if (aFu == Fu.FU20) {
			mCondInfo.setRonPoint(CANNOT);
			mCondInfo.setRonHan(Han.CANNOT);
			return;
		}

		for (int i = 0; i < pointTable.length; i++) {
			if ((double) pointTable[i] >= aCondPoint) {
				mCondInfo.setRonPoint(pointTable[i]);
				if (pointTable[i] == mangan) {
					mCondInfo.setRonHan(Han.MANGAN);
				} else {
					mCondInfo.setRonHan(Han.toHan(i));
				}
				return;
			}
		}

		for (int i = 0; i < pointTableMangan.length; i++) {
			if ((double) pointTableMangan[i] >= aCondPoint) {
				mCondInfo.setRonPoint(pointTableMangan[i]);
				mCondInfo.setRonHan(Han.toOrverMangan(i));
				return;
			}
		}
		mCondInfo.setRonPoint(CANNOT);
		mCondInfo.setRonHan(Han.CANNOT);
	}

	private void setTsumo(Fu aFu, double aCondPoint, ParentChild aParentChild) {

		int[] pointTableParent = getPointTable(aFu, AgariType.TSUMO,
				ParentChild.PARENT);
		int[] pointTableManganParent = getPointTableMangan(AgariType.TSUMO,
				ParentChild.PARENT);
		int[] pointTableChild = getPointTable(aFu, AgariType.TSUMO,
				ParentChild.CHILD);
		int[] pointTableManganChild = getPointTableMangan(AgariType.TSUMO,
				ParentChild.CHILD);
		int point = 0;
		int mangan = 0;

		if (aParentChild == ParentChild.PARENT) {
			mCondInfo.setChildTsumoPoint(CANNOT);
			mangan = 12000;
		} else {
			mangan = 8000;
		}

		for (int i = 0; i < pointTableParent.length; i++) {
			if (aParentChild == ParentChild.PARENT) {
				point = pointTableParent[i] * 3;
			} else {
				point = pointTableChild[i] * 2 + pointTableParent[i];
			}
			if ((double) point >= aCondPoint) {
				mCondInfo.setParentTsumoPoint(pointTableParent[i]);
				if (aParentChild == ParentChild.CHILD) {
					mCondInfo.setChildTsumoPoint(pointTableChild[i]);
				}
				if (point == mangan) {
					mCondInfo.setTsumoHan(Han.MANGAN);
				} else {
					mCondInfo.setTsumoHan(Han.toHan(i));
				}
				return;
			}
		}
		for (int i = 0; i < pointTableManganParent.length; i++) {
			if (aParentChild == ParentChild.PARENT) {
				point = pointTableManganParent[i] * 3;
			} else {
				point = pointTableManganChild[i] * 2
						+ pointTableManganParent[i];
			}

			if ((double) point >= aCondPoint) {
				mCondInfo.setParentTsumoPoint(pointTableManganParent[i]);
				if (aParentChild == ParentChild.CHILD) {
					mCondInfo.setChildTsumoPoint(pointTableManganChild[i]);
				}
				mCondInfo.setTsumoHan(Han.toOrverMangan(i));
				return;
			}
		}
		mCondInfo.setParentTsumoPoint(CANNOT);
		mCondInfo.setChildTsumoPoint(CANNOT);
		mCondInfo.setTsumoHan(Han.CANNOT);

	}

	// /////////////////////

	private int[] getPointTable(Fu aFu, AgariType aType,
			ParentChild aParentChild) {
		int[] ret = null;
		int[][] table = null;

		switch (aType) {
		case DIRECT_RON:
		case RON:
			switch (aParentChild) {
			case PARENT:
				table = mMjPointTable.getParentRon();
				ret = table[aFu.toValue()];
				break;
			case CHILD:
				table = mMjPointTable.getChildRon();
				ret = table[aFu.toValue()];
				break;
			default:
				break;
			}
			break;
		case TSUMO:
			switch (aParentChild) {
			case PARENT:
				table = mMjPointTable.getParentTsumo();
				ret = table[aFu.toValue()];
				break;
			case CHILD:
				table = mMjPointTable.getChildTsumo();
				ret = table[aFu.toValue()];
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return ret;
	}

	private int[] getPointTableMangan(AgariType aType, ParentChild aParentChild) {

		int[] ret = null;

		switch (aType) {
		case DIRECT_RON:
		case RON:
			switch (aParentChild) {
			case PARENT:
				ret = mMjPointTable.getParentRonMangan();
				break;
			case CHILD:
				ret = mMjPointTable.getChildRonMangan();
				break;
			default:
				break;
			}
			break;
		case TSUMO:
			switch (aParentChild) {
			case PARENT:
				ret = mMjPointTable.getParentTsumoMangan();
				break;
			case CHILD:
				ret = mMjPointTable.getChildTsumoMangan();
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return ret;
	}

	public void disp() {
		System.out.println("ロン " + getRonPoint() + "点 "
				+ getRonHan().toString());
		System.out.println("ツモ " + getChildTsumoPoint() + "点 "
				+ getParentTsumoPoint() + "点 " + getTsumoHan().toString());
	}

	// ////////////////

	public static void main(String[] args) {

		CondManagerForMjTable cm = new CondManagerForMjTable(Fu.FU40, 0,
				ParentChild.PARENT);
		cm.disp();

		System.out.println(Wind.PEI.getKamitya().toString());
		System.out.println(Wind.PEI.getToimen().toString());
		System.out.println(Wind.PEI.getShimotya().toString());
	}
}
