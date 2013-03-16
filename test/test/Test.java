package test;

import java.util.ArrayList;
import java.util.List;

import jp.gr.java_conf.tamekuni.condition_to_win.AgariType;
import jp.gr.java_conf.tamekuni.condition_to_win.CondManagerForMjTable;
import jp.gr.java_conf.tamekuni.condition_to_win.Fu;
import jp.gr.java_conf.tamekuni.condition_to_win.GameManager;
import jp.gr.java_conf.tamekuni.condition_to_win.ParentChild;
import jp.gr.java_conf.tamekuni.condition_to_win.Wind;

public class Test {

	private GameManager mGm;
	private Wind mTarget;

	public Test() {
		mTarget = Wind.NAN;
		mGm = new GameManager();

		mGm.setKyotaku(1);
		mGm.setTsumibo(0);
		mGm.setMe(Wind.SYA);
		mGm.setPlayerPoint(Wind.TON, 20000);
		mGm.setPlayerPoint(Wind.NAN, 22000);
		mGm.setPlayerPoint(Wind.SYA, 11000);
		mGm.setPlayerPoint(Wind.PEI, 46000);
		mGm.disp();
	}

	public static void main(String[] args) {

		Test test = new Test();

		ParentChild parentChild = test.mGm.getParentChild(test.mGm.getMe());

		List<CondManagerForMjTable> directRonCondList = test.makeCondList(
				parentChild, AgariType.DIRECT_RON);
		List<CondManagerForMjTable> ronCondList = test.makeCondList(
				parentChild, AgariType.RON);
		List<CondManagerForMjTable> tsumoCondList = test.makeCondList(
				parentChild, AgariType.TSUMO);

		String directRonStr = test.makeCondStr(directRonCondList,
				AgariType.DIRECT_RON);
		String ronStr = test.makeCondStr(ronCondList, AgariType.RON);
		String tsumoStr = test.makeCondStr(tsumoCondList, AgariType.TSUMO);

		System.out.print(directRonStr);
		System.out.print(ronStr);
		System.out.print(tsumoStr);

	}

	private List<CondManagerForMjTable> makeCondList(ParentChild aParentChild,
			AgariType aType) {

		List<CondManagerForMjTable> list = new ArrayList<CondManagerForMjTable>();

		double condPoint = 0;

		switch (aType) {
		case DIRECT_RON:
			condPoint = mGm.getCondPoint(AgariType.DIRECT_RON, mTarget);
			break;
		case RON:
			condPoint = mGm.getCondPoint(AgariType.RON, mTarget);
			break;
		case TSUMO:
			condPoint = mGm.getCondPoint(AgariType.TSUMO, mTarget);
			break;
		default:
			break;
		}

		list.add(new CondManagerForMjTable(Fu.FU30, condPoint, aParentChild));
		list.add(new CondManagerForMjTable(Fu.FU40, condPoint, aParentChild));
		list.add(new CondManagerForMjTable(Fu.FU50, condPoint, aParentChild));

		return list;
	}

	private String makeCondStr(List<CondManagerForMjTable> aList,
			AgariType aType) {
		StringBuilder strb = new StringBuilder();
		double condPoint = mGm.getCondPoint(aType, mTarget);

		strb.append((int) Math.ceil(condPoint) + "点必要。\n");

		for (final CondManagerForMjTable cond : aList) {
			strb.append(cond.getFu().toString() + ":");

			switch (aType) {
			case DIRECT_RON:
			case RON:
				strb.append(cond.getRonHan().toString() + "("
						+ cond.getRonPoint() + "点)で");

				if (condPoint == (double) cond.getRonPoint()) {
					strb.append("同点です!!\n");

				} else {
					strb.append("逆転です!!\n");
				}
				break;

			case TSUMO:
				switch (mGm.getParentChild(mGm.getMe())) {
				case PARENT:
					strb.append(cond.getTsumoHan().toString() + "("
							+ cond.getParentTsumoPoint() + "点オール)で");

					if (mGm.getCondPoint(aType, mTarget) == (double) (cond
							.getParentTsumoPoint() * 3)) {
						strb.append("同点です!!\n");

					} else {
						strb.append("逆転です!!\n");
					}
					break;
				case CHILD:
					strb.append(cond.getTsumoHan().toString() + "("
							+ cond.getChildTsumoPoint() + "-"
							+ cond.getParentTsumoPoint() + "点)で");

					if (mGm.getCondPoint(aType, mTarget) == (double) (cond
							.getChildTsumoPoint() * 2 + cond
							.getParentTsumoPoint())) {
						strb.append("同点です!!\n");

					} else {
						strb.append("逆転です!!\n");
					}
					break;
				}
				break;
			default:
				break;

			}
		}

		strb.append("\n");
		return strb.toString();
	}
}
