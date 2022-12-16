# 2022.12.16.THU 📅
----------------
<br>

# 1. EMP 테이블 실습 - 1) 기본 설정 및 구조 이해하기 ✔
### 💡 [log4j.xml]
- 레거시 프로젝트 생성 시 자동으로 생성됨 (src/main/resources)
- 기본 세팅이니 교수님과 함께 한 코드로 덮어쓰기
<br>

### 💡 [log4jdbc.log4j2.properties]
- 레거시 프로젝트 생성 시 자동으로 생성 X -> 직접 만들어주기
- src/main/resources
```xml
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
```
- 특별한 기능을 하는 것이 아니고 그냥 DB에서 가져온 값을 예쁘게 콘솔창에 띄워줌
<br>

