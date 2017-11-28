package wx.euler.dp;

public class SingleDog {
	private SingleDog() {
		
	}
	public static SingleDog getInstance() {
		return InnerSingleDog.singleDog;
	}
	private static class InnerSingleDog{
		public static SingleDog singleDog = new SingleDog();
	}
}
