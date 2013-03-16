package jp.gr.java_conf.tamekuni.condition_to_win;

import jp.gr.java_conf.tamekuni.condition_to_win.PlayerInfo;
import jp.gr.java_conf.tamekuni.condition_to_win.TableInfo;
import jp.gr.java_conf.tamekuni.condition_to_win.Wind;

public class GameInfo {

	final PlayerInfo[] mPlayerList;
	final TableInfo mTable;
	private Wind mMe;

	GameInfo() {
		mPlayerList = new PlayerInfo[Wind.size()];
		for (int i = 0; i < Wind.size(); i++) {
			mPlayerList[i] = new PlayerInfo();
		}
		mTable = new TableInfo();
		mMe = Wind.TON;
	}

	public Wind getMe() {
		return mMe;
	}

	public void setMe(Wind aMe) {
		mMe = aMe;
	}
}
