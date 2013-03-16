package jp.gr.java_conf.tamekuni.condition_to_win;

import jp.gr.java_conf.tamekuni.condition_to_win.AgariType;
import jp.gr.java_conf.tamekuni.condition_to_win.Rank;
import jp.gr.java_conf.tamekuni.condition_to_win.Wind;

public interface GameManagerIF {

	public int getPlayerPoint(Wind aPlayer);

	public void setPlayerPoint(Wind aPlayer, int aValue);

	public Rank getPlayerRank(Wind aPlayer);

	public int getKyotaku();

	public void setKyotaku(int aValue);

	public int getTsumibo();

	public void setTsumibo(int aValue);

	public Wind getMe();

	public void setMe(Wind aMe);

	public Wind getPlayerForRank(Rank aRank);

	public boolean isParent(Wind aPlayer);

	public ParentChild getParentChild(Wind aPlayer);

	public int getDiffPoint(Wind aTarget);

	public int getTotalPoint();

	public double getCondPoint(AgariType aType, Wind aTarget);
}
