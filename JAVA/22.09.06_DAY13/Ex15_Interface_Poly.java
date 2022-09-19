
//인터페이스 설계
//~~ 할 수 있는(수리할 수 있는)
interface Irepairable{}


class Unit2 {
   int hitpoint; // 기본에너지
   final int MAX_HP; // 최대에너지
   // Unit2(){}

   Unit2(int hp) {
      this.MAX_HP = hp;
   }
}

//지상유닛, 공중유닛. 건물유닛

//지상유닛
class GroundUnit extends Unit2 {
   public GroundUnit(int hp) {
      super(hp);
   }
}

class AirUnit extends Unit2 {
   public AirUnit(int hp) {
      super(hp);

   }
}

//건물

class CommandCenter implements Irepairable{
}

class Tank2 extends GroundUnit implements Irepairable{
   public Tank2() {
      super(50);
      this.hitpoint = this.MAX_HP;
   }

   @Override
   public String toString() {
      return "Tank2";
   }
}

class Marine2 extends GroundUnit {
   public Marine2() {
      super(50);
      this.hitpoint = this.MAX_HP;
   }

   @Override
   public String toString() {
      return "Marine2";
   }
}

class Scv extends GroundUnit implements Irepairable{
   public Scv() {
      super(50);
      this.hitpoint = this.MAX_HP;
   }

   @Override
   public String toString() {
      return "Scv";
   }
   
   /* 
    Scv 구체화 , 특수화된 고유한 기능
    수리하다 (repair)
    tank2, Scv
   
    전자제품 매장 제품 1000개 >> buy() 1000개 생성 (x)
    다형성 부모타입을 이용해 buy(Product P)
   
    문제점) 부모는 찾았어요 : GroundUnit (Tank2, Marine2, Scv)
   
    Marine2는 repair 대상이 아니에요.
    void repair(Unit2 unit) >> Tank2, Marine2(x), Scv
    void repair(GroundUnit unit) >> Tank2, Marine2(x), Scv
   
    고민 ??
   
   ** CommandCenter repair 대상이야
   Tank2, Marine2, Scv, CommandCenter 연결된 고리 (연관성)
   
    implements Irepairable{} 연관성 같은 부모....
   
   class CommandCenter implements Irepairable {}
   class Tank2 extends GroundUnit implements Irepairable
   class Scv extends GroundUnit implements Irepairable
   
   단 부모자원만 접근 가능
   단 재정의된 자원 접근
   
   1. void repair(Irepairable repairunit) >> CommandCenter,Tank2,Scv
   Irepairable 의 자식타입
   repair Tank2, Scv >> scv.hitpoint += 5;
   repair CommandCenter 다른 방법

    */
   
   void repair(Irepairable repairunit) {
      //repairunit 통해 Unit2 접근
      
//      답) Tank2, Scv만 오면 > Unit2
//      Unit2 unit = (Unit2)repairunit; //Down
//      unit.hitpoint += 5;
      
//      CommandCenter > Unit2 연관성이 없다
//      Unit2 unit = (Unit2)rerepairunit; (예외)
      
//      repair(Irepairalbe repairunit) 사용
//      비교 (타입) >> instanceof >> 타입 질문
      
      if(repairunit instanceof Unit2) {
         //Tank2, Scv
         Unit2 unit = (Unit2)repairunit;
         if(unit.hitpoint != unit.MAX_HP) {
            unit.hitpoint = unit.MAX_HP; //완충
         }
      }else {
         //다른 객체
         System.out.println("다른 충전방식을 통해서 repair를 제공합니다.");
      }
      
   }

//   void repair(Tank2 tank) {
//      if (tank.hitpoint != tank.MAX_HP) {
//         tank.hitpoint += 5;
//      }
//   }
//
//   void repair(Scv scv) {
//      if (scv.hitpoint != scv.MAX_HP) {
//         scv.hitpoint += 5;
//      }
//   }
}

public class Ex15_Interface_Poly {

	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		//전투
		tank.hitpoint-=20;
		System.out.println("탱크 : " + tank.hitpoint);
		System.out.println("Scv 수리 요청");
		scv.repair(tank);
		
		System.out.println("탱크 수리 완료 : " + tank.hitpoint);
		
		scv.hitpoint-=30;
		System.out.println("scv : " + scv.hitpoint);
		System.out.println("Scv 수리 요청");
		scv.repair(scv);
		System.out.println("scv 수리 완료 : " + scv.hitpoint);
		
		CommandCenter center = new CommandCenter();
		scv.repair(center);

	}

}