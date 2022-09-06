/*
게임 : 유닛 unit

unit : 공통기능 >> 이동좌표, 이동, 멈춘다) : 추상화, 일반화 / 이동 방법은 다르다 (unit마다 별도의 구현 강제)

abstract class Unit { abstract void move() }
*/

abstract class Unit {
	int x, y;

	void stop() {
		System.out.println("Unit stop");
	}

	// 이동 (서로 다르게) 강제구현 ... 다름을 구현
	abstract void move(int x, int y); // 실행블럭(x) >> 추상함수
}

//Tank
class Tank extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank 소리내며 이동 : " + this.x + "," + this.y);
	}

	// 필요하다면 Tank만의 구체화 된 특수화 된 내용을 구현
	void changeMode() {
		System.out.println("탱크모드 변환");
	}
}

class Marine extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine 이동 : " + this.x + "," + this.y);
	}

	void stimpack() {
		System.out.println("스팀팩 가능");
	}
}

class Dropship extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Dropship 하늘로 이동 : " + this.x + "," + this.y);
	}

	void load() {
		System.out.println("Unit load");
	}

	void unload() {
		System.out.println("Unit Unload");
	}
}

public class Ex02_abstract_class {

	public static void main(String[] args) {
		Tank tank = new Tank();
		tank.move(500, 200);
		tank.stop();
		tank.changeMode();

		Marine marine = new Marine();
		marine.move(200, 300);
		marine.stop();
		marine.stimpack();

		// 1. 탱크 3대를 만들고 같은 좌표 (600, 800)으로 이동시키세요.
		Tank[] tanklist = { new Tank(), new Tank(), new Tank() };
		for (Tank t : tanklist) {
			t.move(600, 800);
		}

		// 2. 여러개의 (Tank 1대, Marine 1대, Dropship 1대)를 생성하고 같은 좌표(666, 888)로 이동시키세요.
		Unit[] unitlist = { new Tank(), new Marine(), new Dropship() };
		// 단점 : 각 유닛들의 구체화된 특수 자원에 접근할 수 엇ㅂ음
		for (Unit u : unitlist) {
			u.move(666, 888);
		}

	}

}
