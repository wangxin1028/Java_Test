package org.wx.dp;

public class SBSingleDog {
	private SBSingleDog () {
		
	}
	private static SBSingleDog singleDog = null;
	public static SBSingleDog getInstance() {
		if(singleDog == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			singleDog = new SBSingleDog();
		}
		return singleDog;
	}
}
