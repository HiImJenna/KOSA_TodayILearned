# 2022.08.23.Wed 📅
<br>

# 제어문 ✔
--------------
▪ 조건문 : if (3가지), switch(조건) {case : ...break}
▪ 반복문 : for(반복 횟수가 명확), while(진위){}, do {} ~ while ()
▪ 분기분 : break(블럭탈출), continue(아래구문 skip)
<br>

## 1. for문
* ### for 문제 풀이
    #### Q1. 1 ~ 100 누적값

	'''

	    int sum = 0;
	
	    for (int i = 1; i <= 100; i++) {
		System.out.println(" i : " + i);
		sum += i;
        

    '''

<br>

 * ### continue & break
    #### for + (분기문) continue, break

	'''

	for(int i =2; i<=9; i++ ) {
		for (int j = 0; j <= 9; j++) {
			if(i == j) {
				continue; //아래 구문 스킵
			}
			
			System.out.printf("[%d]*[%d]=[%d]\t", i, j, i*j);
		}
		System.out.println();

    '''

   ✨ _continue (아래 구분 skip), break(for, while 블럭 탈출)_

<br>

## 2. while문
![이미지링크](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcafeptthumb1.phinf.naver.net%2F20140516_22%2Fvenus0720_1400244016895cXwq5_PNG%2Fdo_while%25B5%25BF%25C0%25DB.png%3Ftype%3Dw740%22&type=cafe_wa740)

## 3. do - while문
![이미지링크](https://dthumb-phinf.pstatic.net/?src=%22http%3A%2F%2Fcafeptthumb1.phinf.naver.net%2F20140516_22%2Fvenus0720_1400244016895cXwq5_PNG%2Fdo_while%25B5%25BF%25C0%25DB.png%3Ftype%3Dw740%22&type=cafe_wa740)
