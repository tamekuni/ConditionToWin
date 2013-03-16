package jp.gr.java_conf.tamekuni.condition_to_win;

import java.util.Arrays;

public class GameManager implements GameManagerIF {

	private GameInfo mGameInfo;

	public GameManager() {
		mGameInfo = new GameInfo();
		setPlayerRank();
	}

	@Override
	public int getPlayerPoint(Wind aPlayer) {
		return mGameInfo.mPlayerList[aPlayer.toValue()].getPoint();
	}

	@Override
	public void setPlayerPoint(Wind aPlayer, int aValue) {
		mGameInfo.mPlayerList[aPlayer.toValue()].setPoint(aValue);
		setPlayerRank();
	}

	@Override
	public Rank getPlayerRank(Wind aPlayer) {
		return mGameInfo.mPlayerList[aPlayer.toValue()].getRank();
	}

	@Override
	public int getKyotaku() {
		return mGameInfo.mTable.getKyotaku();
	}

	@Override
	public void setKyotaku(int aValue) {
		mGameInfo.mTable.setKyotaku(aValue);
	}

	@Override
	public int getTsumibo() {
		return mGameInfo.mTable.getTsumibo();
	}

	@Override
	public void setTsumibo(int aValue) {
		mGameInfo.mTable.setTsumibo(aValue);
	}

	@Override
	public Wind getMe() {
		return mGameInfo.getMe();
	}

	@Override
	public void setMe(Wind aMe) {
		mGameInfo.setMe(aMe);
	}

	@Override
	public Wind getPlayerForRank(Rank aRank) {
		Wind ret = Wind.TON;

		for (int i = 0; i < Wind.size(); i++) {
			if (mGameInfo.mPlayerList[i].getRank() == aRank) {
				ret = Wind.toWind(i);
				break;
			}
		}
		return ret;
	}

	@Override
	public boolean isParent(Wind aPlayer) {
		if (aPlayer == Wind.TON) {
			return true;
		}
		return false;
	}

	@Override
	public ParentChild getParentChild(Wind aPlayer) {
		if (isParent(aPlayer)) {
			return ParentChild.PARENT;
		}
		return ParentChild.CHILD;
	}

	@Override
	public int getDiffPoint(Wind aTarget) {
		return getPlayerPoint(aTarget) - getPlayerPoint(getMe());
	}

	@Override
	public int getTotalPoint() {
		int ret = 0;
		for (int i = 0; i < Wind.size(); i++) {
			ret += getPlayerPoint(Wind.toWind(i));
		}
		ret += getKyotaku() * 1000;
		return ret;
	}

	@Override
	public double getCondPoint(AgariType aType, Wind aTarget) {
		double cond = 0.0;
		double diffPoint = (double) getDiffPoint(aTarget);
		double kyotaku = (double) getKyotaku();
		double tsumibo = (double) getTsumibo();

		switch (aType) {
		case DIRECT_RON:
			cond = (diffPoint - (kyotaku * 1000) - (tsumibo * 600)) * 0.5;
			break;
		case RON:
			cond = diffPoint - (kyotaku * 1000) - (tsumibo * 300);
			break;
		case TSUMO:
			if (isParent(getMe())) {
				cond = (diffPoint - (kyotaku * 1000) - (tsumibo * 400)) * 0.75;
			} else if (isParent(aTarget)) {
				cond = (diffPoint - (kyotaku * 1000) - (tsumibo * 400)) * 2.0 / 3.0;
			} else {
				cond = (diffPoint - (kyotaku * 1000) - (tsumibo * 400)) * 0.8;
			}
			break;
		default:
			break;
		}

		if (cond < 0) {
			return 0;
		}

		return cond;
	}

	private void setPlayerRank() {
		int[] tmpPointList = new int[4];// 昇順
		int[] pointList = new int[4];// 降順

		for (int i = 0; i < Wind.size(); i++) {
			tmpPointList[i] = getPlayerPoint(Wind.toWind(i));
			mGameInfo.mPlayerList[i].setRank(Rank.UNKNOWN);
		}
		Arrays.sort(tmpPointList);

		// Reverse
		for (int i = 0, j = 3; i < Wind.size(); i++, j--) {
			pointList[i] = tmpPointList[j];
		}

		int rank = 1;
		for (int i = 0; i < Wind.size(); i++) {
			for (int j = 0; j < Wind.size(); j++) {
				if (pointList[i] == getPlayerPoint(Wind.toWind(j))
						&& getPlayerRank(Wind.toWind(j)) == Rank.UNKNOWN) {
					mGameInfo.mPlayerList[j].setRank(Rank.toRank(rank));
					rank++;
					break;
				}
			}
		}
	}

	public void disp() {
		System.out.println("-------------dbg-------------------");
		System.out.print("供託 " + getKyotaku() + " ");
		System.out.println("積棒 " + getTsumibo());
		System.out.println("Me " + getMe().toString());

		for (int i = 0; i < Wind.size(); i++) {
			System.out.print(Wind.toWind(i).toString() + " ");
			System.out.println(getPlayerRank(Wind.toWind(i)).toValue() + "位");
			System.out.print(getPlayerPoint(Wind.toWind(i)) + "点(");
			System.out.println(getDiffPoint(Wind.toWind(i)) + ")");
		}

		System.out.println("合計 " + getTotalPoint() + "点");

		for (int i = 1; i < Rank.size(); i++) {
			System.out.print(getPlayerForRank(Rank.toRank(i)).toString() + " ");
		}
		System.out.println();
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		GameManager gm = new GameManager();
		gm.disp();

		gm.setKyotaku(1);
		gm.setTsumibo(1);
		gm.setMe(Wind.SYA);
		gm.setPlayerPoint(Wind.TON, 20000);
		gm.setPlayerPoint(Wind.NAN, 22000);
		gm.setPlayerPoint(Wind.SYA, 2000);
		gm.setPlayerPoint(Wind.PEI, 22000);
		gm.disp();

		for (int i = 0; i < Wind.size(); i++) {
			double direct;
			double ron;
			double tsumo;

			direct = gm.getCondPoint(AgariType.DIRECT_RON, Wind.toWind(i));
			ron = gm.getCondPoint(AgariType.RON, Wind.toWind(i));
			tsumo = gm.getCondPoint(AgariType.TSUMO, Wind.toWind(i));

			System.out.println("直撃:" + direct);
			System.out.println("ロン:" + ron);
			System.out.println("ツモ:" + tsumo);
		}

	}

}
