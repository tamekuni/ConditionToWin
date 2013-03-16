package jp.gr.java_conf.tamekuni.condition_to_win;

import jp.gr.java_conf.tamekuni.condition_to_win.CondInfoForMjTable;
import jp.gr.java_conf.tamekuni.condition_to_win.Han;
import jp.gr.java_conf.tamekuni.condition_to_win.MjPointTable;

public interface CondManagerForMjTableIF {

	public static final int NA = MjPointTable.NA;
	public static final int CANNOT = CondInfoForMjTable.CANNOT;

	public int getRonPoint();

	public Han getRonHan();

	public int getChildTsumoPoint();

	public int getParentTsumoPoint();

	public Han getTsumoHan();

	public Fu getFu();

	public ParentChild getParentChild();

}
