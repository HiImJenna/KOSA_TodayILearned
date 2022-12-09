package DAY5;
public class Ex03_Method_Call2 {

	public static void TV(String[] args) {
		// TODO Auto-generated method stub
		TV lgtv = new TV();
		lgtv.tvBrand = "LG";
		
		lgtv.tvInfo();
			lgtv.channelUp();
			lgtv.channelUp();
			lgtv.channelUp();
		
		lgtv.tvInfo();
			lgtv.channelDown();
		lgtv.tvInfo();
		
		TV sstv = new TV();
		sstv.tvBrand = "SS";
		
	}

}
