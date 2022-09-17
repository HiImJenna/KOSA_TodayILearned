package DAY6;

import kr.or.kosa.Card;

public class Ex08_Static_Card {

	public static void main(String[] args) {
		
		//카드 53장 제작
		//메모리(heap)
		
		Card c = new Card();
		c.makeCard(1, "heart");
		c.h = 40;
		c.w = 10;
		c.cardDisplay();
		
		Card c2 = new Card();
		c.makeCard(2, "heart");
		c.cardDisplay();
		
		Card c3 = new Card();
		c.makeCard(3, "heart");
		c.cardDisplay();
	}

}
